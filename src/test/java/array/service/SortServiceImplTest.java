package array.service;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import array.algorithm.BubbleSortStrategy;
import array.algorithm.InsertionSortStrategy;
import array.algorithm.SortStrategy;
import array.service.impl.SortServiceImpl;
import org.junit.jupiter.api.Test;

class SortServiceImplTest {

  private static final int[] UNSORTED_VALUES = {5, -3, 8, 0, 42, -1};
  private static final int[] EXPECTED_SORTED_VALUES = {-3, -1, 0, 5, 8, 42};

  @Test
  void shouldSortArrayUsingBubbleSortStrategy() {
    final SortService service = new SortServiceImpl();
    final SortStrategy strategy = new BubbleSortStrategy();
    final int[] actual = service.sort(UNSORTED_VALUES, strategy);
    assertArrayEquals(EXPECTED_SORTED_VALUES, actual);
  }

  @Test
  void shouldSortArrayUsingInsertionSortStrategy() {
    final SortService service = new SortServiceImpl();
    final SortStrategy strategy = new InsertionSortStrategy();
    final int[] actual = service.sort(UNSORTED_VALUES, strategy);
    assertArrayEquals(EXPECTED_SORTED_VALUES, actual);
  }
}
