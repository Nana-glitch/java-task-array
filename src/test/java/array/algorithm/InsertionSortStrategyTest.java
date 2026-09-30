package array.algorithm;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class InsertionSortStrategyTest {

  private static final int[] UNSORTED_VALUES = {3, 1, 2};
  private static final int[] EXPECTED_SORTED_VALUES = {1, 2, 3};
  private static final int[] EXPECTED_UNCHANGED_SOURCE_VALUES = {3, 1, 2};
  private static final int[] EMPTY_VALUES = {};

  @Test
  void shouldSortUnsortedArrayInAscendingOrder() {
    final SortStrategy strategy = new InsertionSortStrategy();
    final int[] actual = strategy.sort(UNSORTED_VALUES);
    assertArrayEquals(EXPECTED_SORTED_VALUES, actual);
  }

  @Test
  void shouldReturnEmptyArrayWhenSourceIsEmpty() {
    final SortStrategy strategy = new InsertionSortStrategy();
    final int[] actual = strategy.sort(EMPTY_VALUES);
    assertArrayEquals(EMPTY_VALUES, actual);
  }

  @Test
  void shouldNotMutateSourceArray() {
    final SortStrategy strategy = new InsertionSortStrategy();
    strategy.sort(UNSORTED_VALUES);
    assertArrayEquals(EXPECTED_UNCHANGED_SOURCE_VALUES, UNSORTED_VALUES);
  }
}
