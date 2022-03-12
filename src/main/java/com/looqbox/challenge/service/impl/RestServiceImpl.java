package com.looqbox.challenge.service.impl;

import com.looqbox.challenge.exception.PokemonGetException;
import com.looqbox.challenge.model.PokemonsResponse;
import com.looqbox.challenge.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * The RestService is responsible for accessing
 * the public PokeAPI and returns the results needed
 * for this RestAPI.
 */
@Service
@Qualifier("restService")
public class RestServiceImpl implements RestService {

  @Autowired
  private WebClient webClient;

  /**
   * This method connects with the
   * Pokemon API URL and returns all
   * pokemons listed in the database
   * using the RestTemplate bean.
   *
   * @return PokemonsResponse
   */
  @Override
  @Cacheable(value = "pokemons")
  public PokemonsResponse getAll() {
    final Mono<PokemonsResponse> responseMono = webClient.get()
        .uri("/pokemon?offset=0&limit=10000")
        .retrieve()
        .bodyToMono(PokemonsResponse.class);

    return responseMono.blockOptional().stream()
        .findFirst()
        .orElseThrow(() -> new PokemonGetException("An invalid response has been received."));
  }

}
