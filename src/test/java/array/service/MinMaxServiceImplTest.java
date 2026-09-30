package array.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import array.service.impl.MinMaxServiceImpl;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class MinMaxServiceImplTest {

  private static final int[] SAMPLE_VALUES = {5, -3, 8, 0, 42};
  private static final int[] EMPTY_VALUES = {};
  private static final int EXPECTED_MIN = -3;
  private static final int EXPECTED_MAX = 42;

  @Test
  void shouldFindMinimumOfNonEmptyArray() {
    final MinMaxService service = new MinMaxServiceImpl();
    final Optional<Integer> actual = service.findMin(SAMPLE_VALUES);
    assertEquals(Optional.of(EXPECTED_MIN), actual);
  }

  @Test
  void shouldFindMaximumOfNonEmptyArray() {
    final MinMaxService service = new MinMaxServiceImpl();
    final Optional<Integer> actual = service.findMax(SAMPLE_VALUES);
    assertEquals(Optional.of(EXPECTED_MAX), actual);
  }

  @Test
  void shouldReturnEmptyOptionalForMinOfEmptyArray() {
    final MinMaxService service = new MinMaxServiceImpl();
    final Optional<Integer> actual = service.findMin(EMPTY_VALUES);
    assertTrue(actual.isEmpty());
  }

  @Test
  void shouldReturnEmptyOptionalForMaxOfEmptyArray() {
    final MinMaxService service = new MinMaxServiceImpl();
    final Optional<Integer> actual = service.findMax(EMPTY_VALUES);
    assertTrue(actual.isEmpty());
  }
}
