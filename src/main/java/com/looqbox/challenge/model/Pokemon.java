package com.looqbox.challenge.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public final class Pokemon implements Serializable {

  private final String name;
  private final String url;

}
