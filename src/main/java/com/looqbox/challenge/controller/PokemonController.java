package com.looqbox.challenge.controller;

import com.looqbox.challenge.model.Pokemon;
import com.looqbox.challenge.model.dto.PokemonGetDto;
import com.looqbox.challenge.service.PokemonService;
import com.looqbox.challenge.service.impl.PokemonServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/pokemons")
public class PokemonController {

  @Autowired
  private PokemonService service;

  @GetMapping
  @ResponseBody
  @Cacheable(value = "pokemon-list")
  public ResponseEntity<PokemonGetDto> getByName(@RequestParam(name = "q") final String name) {
    final List<Pokemon> pokemonList = service.addHighlight(service.getPokemonByAlias(name), name);
    return ResponseEntity.status(HttpStatus.OK)
        .body(PokemonGetDto.builder()
            .count(pokemonList.size())
            .result(pokemonList)
            .build()
        );
  }


}
