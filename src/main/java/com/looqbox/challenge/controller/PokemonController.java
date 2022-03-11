package com.looqbox.challenge.controller;

import com.looqbox.challenge.model.Pokemon;
import com.looqbox.challenge.model.dto.PokemonEntryDto;
import com.looqbox.challenge.service.PokemonService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
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
  private PokemonService pokemonService;

  @GetMapping
  @ResponseBody
  public ResponseEntity<PokemonEntryDto> getByName(@RequestParam final String name) {
    final List<String> pokemonList = pokemonService.getPokemonByAlias(name).stream()
        .map(Pokemon::getName)
        .collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK)
        .body(new PokemonEntryDto(pokemonList));
  }


}
