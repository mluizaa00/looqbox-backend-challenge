package com.looqbox.challenge.factory;

import com.looqbox.challenge.model.Pokemon;
import com.looqbox.challenge.model.PokemonsResponse;
import com.looqbox.challenge.service.RestService;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
public final class PokemonFactory {

  @Autowired
  private RestService service;

  private final Map<String, Pokemon> pokemonRegistry;

  public PokemonFactory() {
    final PokemonsResponse response = service.getAll();
    this.pokemonRegistry = new LinkedHashMap<>(response.getCount());

    update(response);
  }

  private void update(final PokemonsResponse response) {
    response.getResults().forEach(pokemon -> pokemonRegistry.put(pokemon.getName(), pokemon));
  }

}
