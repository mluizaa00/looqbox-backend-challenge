package com.looqbox.challenge.factory;

import com.looqbox.challenge.model.Pokemon;
import com.looqbox.challenge.model.PokemonsResponse;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Getter
@Component
public final class PokemonFactory {

  private final Map<String, Pokemon> pokemonRegistry;

  public PokemonFactory() {
    this.pokemonRegistry = new LinkedHashMap<>();
  }

}
