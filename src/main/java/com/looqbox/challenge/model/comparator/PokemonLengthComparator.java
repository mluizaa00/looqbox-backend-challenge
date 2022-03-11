package com.looqbox.challenge.model.comparator;

import com.looqbox.challenge.model.Pokemon;
import java.util.Comparator;

/**
 * The pokemon length comparator uses the Integer
 * class for sort algorithm.
 *
 * X: Pokemon one length,
 * Y: Pokemon two length.
 *
 * The method {@link #compare(Pokemon, Pokemon)} compares two int
 * values numerically.
 *
 * Situations:
 *
 * When the X > Y, it returns -1.
 * When X == Y, it returns 0;
 * When X < Y, it returns 1;
 */
public final class PokemonLengthComparator implements Comparator<Pokemon> {

  @Override
  public int compare(final Pokemon pokemonOne, final Pokemon pokemonTwo) {
    return Integer.compare(pokemonOne.getName().length(), pokemonTwo.getName().length());
  }

}
