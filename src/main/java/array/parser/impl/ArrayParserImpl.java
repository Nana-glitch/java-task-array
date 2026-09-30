package array.parser.impl;

import array.exception.ArrayProcessingException;
import array.parser.ArrayParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayParserImpl implements ArrayParser {

  private static final String DELIMITER_REGEX = ";";

  private final Logger logger = LogManager.getLogger(getClass());

  @Override
  public int[] parse(String line) throws ArrayProcessingException {
    if (line == null || line.isBlank()) {
      logger.debug("parsed a blank line into an empty array");
      return new int[0];
    }
    final String[] tokens = line.split(DELIMITER_REGEX, -1);
    final int[] result = new int[tokens.length];
    for (int i = 0; i < tokens.length; i++) {
      result[i] = parseToken(tokens[i]);
    }
    return result;
  }

  private int parseToken(String token) throws ArrayProcessingException {
    try {
      return Integer.parseInt(token.trim());
    } catch (NumberFormatException e) {
      throw new ArrayProcessingException("cannot parse token [" + token + "]", e);
    }
  }
}
