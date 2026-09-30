package array.reader;

import array.exception.ArrayProcessingException;
import java.util.List;

public interface ArrayReader {

  List<String> readLines(String filePath) throws ArrayProcessingException;
}
