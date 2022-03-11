package com.looqbox.challenge.service;

import com.looqbox.challenge.model.Pokemon;
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

  // @Value("${pokeapi.url}") TODO: Check this out why it isn't working on start
  public static final String POKEMON_API_URL;

  static {
    POKEMON_API_URL = "https://pokeapi.co/api/v2/";
  }

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
        .getForObject(POKEMON_API_URL + "/pokemon?offset=0&limit=10000", PokemonsResponse.class);
  }

//  public Pokemon get(final int id) {
//    return restTemplate
//        .getForObject(POKEMON_API_URL + "pokemon/" + id, )
//  }

}
