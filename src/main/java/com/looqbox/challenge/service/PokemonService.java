package com.looqbox.challenge.service;

import com.looqbox.challenge.factory.PokemonFactory;
import com.looqbox.challenge.model.Pokemon;
import com.looqbox.challenge.model.PokemonsResponse;
import com.looqbox.challenge.model.comparator.PokemonAlphabeticalComparator;
import com.looqbox.challenge.model.comparator.PokemonLengthComparator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The PokemonService is responsible
 * for receiving the parameter from the
 * endpoint, sorting and sending a List
 * as a response.
 */
@Service
public class PokemonService {

  @Autowired
  private PokemonFactory factory;

  public List<Pokemon> getPokemonByAlias(final String name) {
    return factory.getPokemonRegistry().values().stream()
        .filter(pokemon -> pokemon.getName().contains(name))
        .sorted(new PokemonAlphabeticalComparator())
        .sorted(new PokemonLengthComparator())
        .collect(Collectors.toList());
  }

  public List<Pokemon> addHighlight(final List<Pokemon> beforeList, final String parameter) {
    return beforeList.stream()
        .peek(pokemon -> {
          final StringBuilder builder = new StringBuilder();

          builder.append("<pre>");
          builder.append(parameter);
          builder.append("</pre>");

          pokemon.setHighlight(pokemon.getName().replace(parameter, builder));
        })
        .collect(Collectors.toList());
  }

  public void update(final PokemonsResponse response) {
    response.getResults().forEach(pokemon -> factory.getPokemonRegistry().put(pokemon.getName(), pokemon));
  }

}
