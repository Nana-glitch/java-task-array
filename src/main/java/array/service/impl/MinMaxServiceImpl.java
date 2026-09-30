package array.service.impl;

import array.service.MinMaxService;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MinMaxServiceImpl implements MinMaxService {

  private final Logger logger = LogManager.getLogger(getClass());

  @Override
  public Optional<Integer> findMin(int[] values) {
    final IntStream stream = IntStream.of(values);
    final OptionalInt minValue = stream.min();
    final Optional<Integer> result = boxOptionalInt(minValue);
    logger.debug("min of array with length {} is {}", values.length, result);
    return result;
  }

  @Override
  public Optional<Integer> findMax(int[] values) {
    final IntStream stream = IntStream.of(values);
    final OptionalInt maxValue = stream.max();
    final Optional<Integer> result = boxOptionalInt(maxValue);
    logger.debug("max of array with length {} is {}", values.length, result);
    return result;
  }

  private Optional<Integer> boxOptionalInt(OptionalInt value) {
    if (value.isEmpty()) {
      return Optional.empty();
    }
    final int primitiveValue = value.getAsInt();
    return Optional.of(primitiveValue);
  }
}
