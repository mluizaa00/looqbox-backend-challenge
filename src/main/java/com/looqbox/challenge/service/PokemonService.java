package com.looqbox.challenge.service;

import com.looqbox.challenge.model.PokemonsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public final class PokemonService {

  @Value("${pokeapi.url}")
  public static String POKEMON_API_URL;

  @Autowired
  private RestTemplate restTemplate;

  public PokemonsResponse getAll() {
    return restTemplate
        .getForObject(POKEMON_API_URL + "/pokemon?offset=0&limit=1", PokemonsResponse.class);
  }

}
