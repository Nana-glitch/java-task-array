package array.writer;

import array.exception.ArrayProcessingException;
import java.util.List;

public interface ResultWriter {

  void writeLines(String filePath, List<String> lines) throws ArrayProcessingException;
}
