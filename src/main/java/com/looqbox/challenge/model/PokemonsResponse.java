package com.looqbox.challenge.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public final class PokemonsResponse {

  private final int count;

  private final String next;
  private final String previous;

  private final List<Pokemon> results;

}
