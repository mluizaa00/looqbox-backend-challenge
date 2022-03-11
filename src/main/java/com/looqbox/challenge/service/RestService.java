package com.looqbox.challenge.service;

import com.looqbox.challenge.model.PokemonsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * The RestService is responsible for accessing
 * the public PokeAPI and returns the results needed
 * for this RestAPI.
 */
@Service
public final class RestService {

  @Value("${pokeapi.url}")
  public static String POKEMON_API_URL;

  @Autowired
  private RestTemplate restTemplate;

  /**
   * This method connects with the
   * Pokemon API URL and returns all
   * pokemons listed in the database
   * using the RestTemplate bean.
   *
   * @return PokemonsResponse
   */
  public PokemonsResponse getAll() {
    return restTemplate
        .getForObject(POKEMON_API_URL + "/pokemon?offset=0&limit=1", PokemonsResponse.class);
  }

}
