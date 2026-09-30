package array.service;

import java.util.Optional;

public interface MinMaxService {

  Optional<Integer> findMin(int[] values);

  Optional<Integer> findMax(int[] values);
}
