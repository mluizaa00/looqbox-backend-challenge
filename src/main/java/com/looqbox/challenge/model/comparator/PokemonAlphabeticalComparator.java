package com.looqbox.challenge.model.comparator;

import com.looqbox.challenge.model.Pokemon;
import java.util.Comparator;

/**
 * The pokemon alphabetical comparator uses the String
 * class for sort algorithm via the compareTo method.
 */
public final class PokemonAlphabeticalComparator implements Comparator<Pokemon> {

  @Override
  public int compare(final Pokemon pokemonOne, final Pokemon pokemonTwo) {
    return pokemonOne.getName().compareTo(pokemonTwo.getName());
  }

}
