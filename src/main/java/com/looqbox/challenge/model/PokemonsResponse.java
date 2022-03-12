package com.looqbox.challenge.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The PokemonsResponse is the variables
 * from the getAll pokemon response from
 * the PokeAPI.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class PokemonsResponse implements Serializable {

  // Total of pokemons in the database
  @JsonProperty("count")
  private int count;

  @JsonProperty("next")
  private String next;
  @JsonProperty("previous")
  private String previous;

  @JsonProperty("results")
  private List<Pokemon> results;

}
