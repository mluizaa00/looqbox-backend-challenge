package com.looqbox.challenge.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RestConfiguration {

  @Value("${pokeapi.url}")
  public static String POKEMON_API_URL;

  static {
    // Just in-case the value doesn't work
    POKEMON_API_URL = "https://pokeapi.co/api/v2/";
  }

  @Bean
  public WebClient webClient(final WebClient.Builder builder) {
    return builder.baseUrl(POKEMON_API_URL)
        .build();
  }

}
