package array.factory;

import array.entity.IntArray;
import array.exception.ArrayProcessingException;
import java.util.List;

public interface ArrayFactory {

  List<IntArray> createFromFile(String filePath) throws ArrayProcessingException;
}
