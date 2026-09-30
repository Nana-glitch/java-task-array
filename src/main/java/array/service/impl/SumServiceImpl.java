package array.service.impl;

import array.service.SumService;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SumServiceImpl implements SumService {

  private final Logger logger = LogManager.getLogger(getClass());

  @Override
  public Optional<Long> calculateSum(int[] values) {
    if (values.length == 0) {
      logger.debug("sum of an empty array is not defined");
      return Optional.empty();
    }
    final IntStream stream = IntStream.of(values);
    final LongStream longStream = stream.asLongStream();
    final long sum = longStream.sum();
    logger.debug("sum of array with length {} is {}", values.length, sum);
    return Optional.of(sum);
  }
}
