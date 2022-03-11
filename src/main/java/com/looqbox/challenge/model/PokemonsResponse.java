package com.looqbox.challenge.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * The PokemonsResponse is the variables
 * from the getAll pokemon response from
 * the PokeAPI.
 */
@Data
@Builder
@AllArgsConstructor
public final class PokemonsResponse {

  // Total of pokemons in the database
  private final int count;

  private final String next;
  private final String previous;

  private final List<Pokemon> results;

}
