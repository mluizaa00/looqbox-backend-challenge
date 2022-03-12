package com.looqbox.tests;

import com.looqbox.challenge.model.Pokemon;
import com.looqbox.challenge.model.type.ArraySortType;
import com.looqbox.challenge.util.ArraySortUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import org.junit.jupiter.api.Test;

final class TestApplication {

  private static final List<Pokemon> POKEMON_LIST;

  static {
    POKEMON_LIST = new ArrayList<>(0);

    final Pokemon vaporeon = Pokemon.builder()
        .name("Vaporeon")
        .build();

    final Pokemon pikachu = Pokemon.builder()
        .name("Pikachu")
        .build();

    final Pokemon eevee = Pokemon.builder()
        .name("Eevee")
        .build();

    POKEMON_LIST.addAll(Arrays.asList(vaporeon, pikachu, eevee));
  }

  @Test
  void test() {
    final List<Pokemon> pokemonList = new ArrayList<>(POKEMON_LIST);
    System.out.println("NON-SORTED LIST: " + join(pokemonList));

    ArraySortUtil.quickSort(pokemonList, ArraySortType.ALPHABETICAL);
    System.out.println("ALPHABETICAL SORTED LIST: " + join(pokemonList));

    ArraySortUtil.quickSort(pokemonList, ArraySortType.LENGTH);
    System.out.println("LENGTH SORTED LIST: " + join(pokemonList));
  }

  private String join(final List<Pokemon> pokemonList) {
    final StringJoiner joiner = new StringJoiner(", ");
    for (final Pokemon pokemon : pokemonList) {
      joiner.add(pokemon.getName());
    }

    return joiner.toString();
  }

}
