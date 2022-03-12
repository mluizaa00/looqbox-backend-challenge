package com.looqbox.challenge.controller;

import com.looqbox.challenge.model.Pokemon;
import com.looqbox.challenge.model.dto.PokemonGetDto;
import com.looqbox.challenge.service.PokemonService;
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
  public ResponseEntity<PokemonGetDto> getByName(@RequestParam(name = "q", required = false) final String name) {
    final List<Pokemon> pokemonList = name == null
        ? service.getAll()
        : service.addHighlight(service.getPokemonByAlias(name), name);

    final PokemonGetDto getDto = PokemonGetDto.builder()
        .count(pokemonList.size())
        .result(pokemonList)
        .build();

    return ResponseEntity.status(HttpStatus.OK)
        .body(getDto);
  }


}
