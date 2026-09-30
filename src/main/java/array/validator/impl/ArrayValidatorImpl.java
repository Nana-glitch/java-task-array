package array.validator.impl;

import array.validator.ArrayValidator;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayValidatorImpl implements ArrayValidator {

  private static final String DELIMITER_REGEX = ";";
  private static final Pattern INTEGER_TOKEN_PATTERN = Pattern.compile("\\s*-?\\d+\\s*");

  private final Logger logger = LogManager.getLogger(getClass());

  @Override
  public boolean isValid(String line) {
    if (line == null || line.isBlank()) {
      logger.debug("blank line accepted as an empty array");
      return true;
    }
    final String[] tokens = line.split(DELIMITER_REGEX, -1);
    for (String token : tokens) {
      if (!INTEGER_TOKEN_PATTERN.matcher(token).matches()) {
        logger.warn("rejected line [{}]: invalid token [{}]", line, token);
        return false;
      }
    }
    return true;
  }
}
