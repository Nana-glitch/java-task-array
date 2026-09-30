package array.reader.impl;

import array.exception.ArrayProcessingException;
import array.reader.ArrayReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayReaderImpl implements ArrayReader {

  private final Logger logger = LogManager.getLogger(getClass());

  @Override
  public List<String> readLines(String filePath) throws ArrayProcessingException {
    final Path path = Path.of(filePath);
    try {
      final List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
      logger.info("read {} line(s) from [{}]", lines.size(), filePath);
      return lines;
    } catch (IOException e) {
      throw new ArrayProcessingException("cannot read file [" + filePath + "]", e);
    }
  }
}
