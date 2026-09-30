package array.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import array.service.impl.SumServiceImpl;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class SumServiceImplTest {

  private static final int[] SAMPLE_VALUES = {1, 2, 3, 4};
  private static final int[] ZERO_SUM_VALUES = {100, -100, 50, -50, 0};
  private static final int[] EMPTY_VALUES = {};
  private static final int[] OVERFLOW_PRONE_VALUES = {Integer.MAX_VALUE, 1};
  private static final long EXPECTED_SUM = 10L;
  private static final long EXPECTED_ZERO_SUM = 0L;
  private static final long EXPECTED_OVERFLOW_SAFE_SUM = (long) Integer.MAX_VALUE + 1L;

  @Test
  void shouldCalculateSumOfNonEmptyArray() {
    final SumService service = new SumServiceImpl();
    final Optional<Long> actual = service.calculateSum(SAMPLE_VALUES);
    assertEquals(Optional.of(EXPECTED_SUM), actual);
  }

  @Test
  void shouldDistinguishZeroSumFromEmptyArray() {
    final SumService service = new SumServiceImpl();
    final Optional<Long> actual = service.calculateSum(ZERO_SUM_VALUES);
    assertEquals(Optional.of(EXPECTED_ZERO_SUM), actual);
  }

  @Test
  void shouldReturnEmptyOptionalForEmptyArray() {
    final SumService service = new SumServiceImpl();
    final Optional<Long> actual = service.calculateSum(EMPTY_VALUES);
    assertTrue(actual.isEmpty());
  }

  @Test
  void shouldNotOverflowWhenSummingValuesNearIntegerMax() {
    final SumService service = new SumServiceImpl();
    final Optional<Long> actual = service.calculateSum(OVERFLOW_PRONE_VALUES);
    assertEquals(Optional.of(EXPECTED_OVERFLOW_SAFE_SUM), actual);
  }
}
