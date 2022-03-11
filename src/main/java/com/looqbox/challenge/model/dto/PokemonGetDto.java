package com.looqbox.challenge.model.dto;

import com.looqbox.challenge.model.Pokemon;
import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public final class PokemonGetDto implements Serializable {

  private int count;
  private List<Pokemon> result;

}
