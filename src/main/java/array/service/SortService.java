package array.service;

import array.algorithm.SortStrategy;

public interface SortService {

  int[] sort(int[] values, SortStrategy strategy);
}
