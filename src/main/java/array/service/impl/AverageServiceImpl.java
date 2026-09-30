package array.service.impl;

import array.service.AverageService;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AverageServiceImpl implements AverageService {

  private final Logger logger = LogManager.getLogger(getClass());

  @Override
  public Optional<Double> calculateAverage(int[] values) {
    final IntStream stream = IntStream.of(values);
    final OptionalDouble averageValue = stream.average();
    final Optional<Double> result = boxOptionalDouble(averageValue);
    logger.debug("average of array with length {} is {}", values.length, result);
    return result;
  }

  private Optional<Double> boxOptionalDouble(OptionalDouble value) {
    if (value.isEmpty()) {
      return Optional.empty();
    }
    final double primitiveValue = value.getAsDouble();
    return Optional.of(primitiveValue);
  }
}
