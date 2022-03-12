package com.looqbox.challenge.service;

import com.looqbox.challenge.model.Pokemon;
import com.looqbox.challenge.model.PokemonsResponse;
import java.util.List;

public interface PokemonService {

  List<Pokemon> getPokemonByAlias(final String name);

  List<Pokemon> getAll();

  List<Pokemon> addHighlight(final List<Pokemon> beforeList, final String parameter);

  void update(final PokemonsResponse response);


}
