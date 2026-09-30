package array.algorithm;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InsertionSortStrategy implements SortStrategy {

  private final Logger logger = LogManager.getLogger(getClass());

  @Override
  public int[] sort(int[] source) {
    final int[] result = Arrays.copyOf(source, source.length);
    for (int i = 1; i < result.length; i++) {
      final int current = result[i];
      int j = i - 1;
      while (j >= 0 && result[j] > current) {
        result[j + 1] = result[j];
        j--;
      }
      result[j + 1] = current;
    }
    logger.debug("insertion-sorted array of length {}", result.length);
    return result;
  }
}
