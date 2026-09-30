package array.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import array.service.impl.AverageServiceImpl;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class AverageServiceImplTest {

  private static final int[] SAMPLE_VALUES = {2, 4, 6, 8};
  private static final int[] EMPTY_VALUES = {};
  private static final double EXPECTED_AVERAGE = 5.0;
  private static final double DELTA = 0.0001;

  @Test
  void shouldCalculateAverageOfNonEmptyArray() {
    final AverageService service = new AverageServiceImpl();
    final Optional<Double> actual = service.calculateAverage(SAMPLE_VALUES);
    assertEquals(EXPECTED_AVERAGE, actual.orElseThrow(), DELTA);
  }

  @Test
  void shouldReturnEmptyOptionalForEmptyArray() {
    final AverageService service = new AverageServiceImpl();
    final Optional<Double> actual = service.calculateAverage(EMPTY_VALUES);
    assertTrue(actual.isEmpty());
  }
}
