package com.looqbox.challenge.model.dto;

import java.io.Serializable;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class PokemonEntryDto implements Serializable {

  private List<String> result;

}
