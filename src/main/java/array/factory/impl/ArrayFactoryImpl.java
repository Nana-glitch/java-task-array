package array.factory.impl;

import array.entity.IntArray;
import array.exception.ArrayProcessingException;
import array.factory.ArrayFactory;
import array.parser.ArrayParser;
import array.reader.ArrayReader;
import array.validator.ArrayValidator;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayFactoryImpl implements ArrayFactory {

  private final Logger logger = LogManager.getLogger(getClass());

  private final ArrayReader reader;
  private final ArrayValidator validator;
  private final ArrayParser parser;

  public ArrayFactoryImpl(ArrayReader reader, ArrayValidator validator, ArrayParser parser) {
    this.reader = reader;
    this.validator = validator;
    this.parser = parser;
  }

  @Override
  public List<IntArray> createFromFile(String filePath) throws ArrayProcessingException {
    final List<String> lines = reader.readLines(filePath);
    final List<IntArray> result = new ArrayList<>();
    long nextId = 1L;
    for (String line : lines) {
      if (!validator.isValid(line)) {
        logger.warn("skipped invalid line [{}]", line);
        continue;
      }
      final int[] values = parser.parse(line);
      result.add(new IntArray(nextId, values));
      nextId++;
    }
    logger.info("created {} array(s) out of {} line(s)", result.size(), lines.size());
    return result;
  }
}
