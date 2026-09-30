package array.algorithm;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BubbleSortStrategy implements SortStrategy {

  private final Logger logger = LogManager.getLogger(getClass());

  @Override
  public int[] sort(int[] source) {
    final int[] result = Arrays.copyOf(source, source.length);
    final int length = result.length;
    for (int i = 0; i < length - 1; i++) {
      for (int j = 0; j < length - 1 - i; j++) {
        if (result[j] > result[j + 1]) {
          swap(result, j, j + 1);
        }
      }
    }
    logger.debug("bubble-sorted array of length {}", length);
    return result;
  }

  private void swap(int[] array, int firstIndex, int secondIndex) {
    final int temporary = array[firstIndex];
    array[firstIndex] = array[secondIndex];
    array[secondIndex] = temporary;
  }
}
