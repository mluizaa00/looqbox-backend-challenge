package com.looqbox.challenge.controller;

import com.looqbox.challenge.model.dto.PokemonEntryDto;
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

  @GetMapping
  @ResponseBody
  public ResponseEntity<PokemonEntryDto> getByName(@RequestParam final String name) {
    return ResponseEntity.status(HttpStatus.OK).build();
  }


}
