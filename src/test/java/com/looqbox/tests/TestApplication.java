package com.looqbox.tests;

import com.google.common.flogger.FluentLogger;
import com.looqbox.challenge.model.Pokemon;
import com.looqbox.challenge.model.type.ArraySortType;
import com.looqbox.challenge.util.ArraySortUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

final class TestApplication {

  private static List<Pokemon> POKEMON_LIST;
  private static FluentLogger FLUENT_LOGGER;

  @BeforeAll
  static void start() {
    FLUENT_LOGGER = FluentLogger.forEnclosingClass();
    POKEMON_LIST = new ArrayList<>(0);

    final Pokemon vaporeon = Pokemon.builder()
        .name("Vaporeon")
        .build();

    final Pokemon alakazam = Pokemon.builder()
        .name("Alakazam")
        .build();

    final Pokemon eevee = Pokemon.builder()
        .name("Eevee")
        .build();

    POKEMON_LIST.addAll(Arrays.asList(vaporeon, alakazam, eevee));
  }

  @Test
  void test() {
    final List<Pokemon> pokemonList = new ArrayList<>(POKEMON_LIST);
    FLUENT_LOGGER.atInfo().log("NON-SORTED LIST: %s", join(pokemonList));

    ArraySortUtil.quickSort(pokemonList, ArraySortType.ALPHABETICAL);
    FLUENT_LOGGER.atInfo().log("ALPHABETICAL SORTED LIST: %s", join(pokemonList));

    ArraySortUtil.quickSort(pokemonList, ArraySortType.LENGTH);
    FLUENT_LOGGER.atInfo().log("LENGTH SORTED LIST: %s", join(pokemonList));
  }

  @Test
  void alphabeticalPerformanceTest() {
    final List<Pokemon> pokemonList = new ArrayList<>(POKEMON_LIST);

    final long start = System.nanoTime();
    ArraySortUtil.quickSort(pokemonList, ArraySortType.ALPHABETICAL);
    final long end = System.nanoTime();

    FLUENT_LOGGER.atInfo().log("ALPHABETICAL SORT NANO: %s", end - start);
  }

  @Test
  void lengthPerformanceTest() {
    final List<Pokemon> pokemonList = new ArrayList<>(POKEMON_LIST);

    final long start = System.nanoTime();
    ArraySortUtil.quickSort(pokemonList, ArraySortType.LENGTH);
    final long end = System.nanoTime();

    FLUENT_LOGGER.atInfo().log("LENGTH SORT NANO: %s", end - start);
  }

  private String join(final List<Pokemon> pokemonList) {
    final StringJoiner joiner = new StringJoiner(", ");
    for (final Pokemon pokemon : pokemonList) {
      joiner.add(pokemon.getName());
    }

    return joiner.toString();
  }

}
