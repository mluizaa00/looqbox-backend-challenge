package com.looqbox.challenge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class RestConfiguration {

  // @Value("${pokeapi.url}") TODO: Check this out why it isn't working on start
  public static final String POKEMON_API_URL;

  static {
    POKEMON_API_URL = "https://pokeapi.co/api/v2/";
  }

  @Bean
  public WebClient webClient(final WebClient.Builder builder) {
    return builder.baseUrl(POKEMON_API_URL)
        .build();
  }

}
