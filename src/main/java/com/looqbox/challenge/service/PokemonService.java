package com.looqbox.challenge.service;

import com.looqbox.challenge.factory.PokemonFactory;
import com.looqbox.challenge.model.Pokemon;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

  @Autowired
  private PokemonFactory factory;

  public List<Pokemon> getPokemonByAlias(final String name) {
    return factory.getPokemonRegistry().values().stream()
        .filter(pokemon -> pokemon.getName().contains(name))
        .sorted(Comparator.comparing(Pokemon::getName))
        .collect(Collectors.toList());
  }

}
