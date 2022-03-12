package com.looqbox.challenge.util;

import com.looqbox.challenge.model.Pokemon;
import com.looqbox.challenge.model.comparator.PokemonAlphabeticalComparator;
import com.looqbox.challenge.model.comparator.PokemonLengthComparator;
import com.looqbox.challenge.model.type.ArraySortType;
import java.util.List;

/**
 * The algorithm chosen to be used was the Quick Sort
 * due to it's performance and easy to use.
 *
 * The center, or pivot, object in the beginning of the sort
 * is the last element of the list.
 *
 * The algorithm loops through all elements and compares
 * then with the center object {@link PokemonAlphabeticalComparator},
 * {@link PokemonLengthComparator}, and then aligns them either to
 * the right side (larger) or left side (smaller).
 *
 * The loop is broken when the start index becomes the same or more
 * than the end index.
 */
public final class ArraySortUtil {

  private static final PokemonAlphabeticalComparator ALPHABETICAL_COMPARATOR;
  private static final PokemonLengthComparator LENGTH_COMPARATOR;

  static {
    ALPHABETICAL_COMPARATOR = new PokemonAlphabeticalComparator();
    LENGTH_COMPARATOR = new PokemonLengthComparator();
  }

  public static void quickSort(final List<Pokemon> list, final ArraySortType sortType) {
    quickSort(list, null, null, sortType);
  }

  /**
   * The quickSort algorithm repositions the larger elements to the right side
   * and the shorter to the left side.
   *
   * The last element of the list is taken as the "center".
   *
   * @param list Pokemon list to be sorted
   * @param startPosition First element index
   * @param endPosition Last element index
   */
  private static void quickSort(final List<Pokemon> list, final Integer startPosition, final Integer endPosition, final ArraySortType sortType) {
    // Checks if the list size is compatible for the sort (> 1)
    if (list.size() <= 1) {
      return;
    }

    final int start = startPosition != null
        ? startPosition
        : 0;

    final int end = endPosition != null
        ? endPosition
        : list.size() - 1;

    // Checks if we reached the end of the sort
    if (start > end) {
      return;
    }

    final int centerPosition = movePosition(list, start, end, sortType);

    quickSort(list, start, centerPosition - 1, sortType);
    quickSort(list, centerPosition + 1, end, sortType);
  }

  private static int movePosition(final List<Pokemon> list, int start, int end, final ArraySortType sortType) {
    final Pokemon center = list.get(end);

    int position = start;
    for (int current = start; current < end; current++) {
      // Uses the LengthComparator for checking both pokemon names
      if (sortType == ArraySortType.LENGTH && LENGTH_COMPARATOR.compare(list.get(current), center) >= 0) {
        invertPosition(list, current, position);
        position++;

        continue;
      }

      // Uses the AlphabeticalComparator for checking both pokemon names
      if (ALPHABETICAL_COMPARATOR.compare(list.get(current), center) <= 0) {
        invertPosition(list, current, position);
        position++;
      }
    }

    invertPosition(list, position, end);
    return position;
  }

  /**
   * Inverts the position of the elements
   * of both indexes presented at the
   * parameters of the method in the list.
   *
   * @param list Pokemon list
   * @param indexOne Index one
   * @param indexTwo Index two
   */
  private static void invertPosition(final List<Pokemon> list, final int indexOne, final int indexTwo) {
    final Pokemon pokemon = list.get(indexOne);

    list.set(indexOne, list.get(indexTwo));
    list.set(indexTwo, pokemon);
  }

}
