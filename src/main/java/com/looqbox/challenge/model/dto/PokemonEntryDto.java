package com.looqbox.challenge.model.dto;

import com.looqbox.challenge.model.Pokemon;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public final class PokemonEntryDto {

  private final List<Pokemon> result;

}
