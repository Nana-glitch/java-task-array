package array.service.impl;

import array.algorithm.SortStrategy;
import array.service.SortService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortServiceImpl implements SortService {

  private final Logger logger = LogManager.getLogger(getClass());

  @Override
  public int[] sort(int[] values, SortStrategy strategy) {
    final Class<? extends SortStrategy> strategyClass = strategy.getClass();
    final String strategyName = strategyClass.getSimpleName();
    logger.debug("delegating sort of length {} to {}", values.length, strategyName);
    return strategy.sort(values);
  }
}
