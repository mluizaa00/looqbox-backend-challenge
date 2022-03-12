package com.looqbox.challenge.service.impl;

import com.looqbox.challenge.factory.PokemonFactory;
import com.looqbox.challenge.model.Pokemon;
import com.looqbox.challenge.model.PokemonsResponse;
import com.looqbox.challenge.model.type.ArraySortType;
import com.looqbox.challenge.service.PokemonService;
import com.looqbox.challenge.util.ArraySortUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * The PokemonService is responsible
 * for receiving the parameter from the
 * endpoint, sorting and sending a List
 * as a response.
 */
@Service
@Qualifier("service")
public class PokemonServiceImpl implements PokemonService {

  @Autowired
  private PokemonFactory factory;

  @Override
  public List<Pokemon> getPokemonByAlias(final String name) {
    final List<Pokemon> pokemonList = factory.getPokemonRegistry().values().stream()
        .filter(pokemon -> pokemon.getName().contains(name))
        .collect(Collectors.toList());

    ArraySortUtil.quickSort(pokemonList, ArraySortType.ALPHABETICAL);
    ArraySortUtil.quickSort(pokemonList, ArraySortType.LENGTH);

    return pokemonList;
  }

  @Override
  public List<Pokemon> getAll() {
    final List<Pokemon> pokemonList = new ArrayList<>(factory.getPokemonRegistry().values());

    ArraySortUtil.quickSort(pokemonList, ArraySortType.ALPHABETICAL);
    ArraySortUtil.quickSort(pokemonList, ArraySortType.LENGTH);

    return pokemonList;
  }

  @Override
  public List<Pokemon> addHighlight(final List<Pokemon> beforeList, final String parameter) {
    return beforeList.stream()
        .map(pokemon -> {
          final var builder = new StringBuilder();

          builder.append("<pre>");
          builder.append(parameter);
          builder.append("</pre>");

          pokemon.setHighlight(pokemon.getName().replace(parameter, builder));
          return pokemon;
        })
        .collect(Collectors.toList());
  }

  @Override
  public void update(final PokemonsResponse response) {
    response.getResults().forEach(pokemon -> {
      if (pokemon.getName().contains("-")) {
        return;
      }

      factory.getPokemonRegistry().put(pokemon.getName(), pokemon);
    });
  }

}
