package com.looqbox.challenge.config;

import com.looqbox.challenge.factory.PokemonFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public PokemonFactory pokemonFactory() {
    return new PokemonFactory();
  }

}
