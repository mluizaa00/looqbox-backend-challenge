package com.looqbox.challenge.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon implements Serializable {

  private String name;
  private String url;
  private String highlight;

}
