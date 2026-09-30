package array.validator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import array.validator.impl.ArrayValidatorImpl;
import org.junit.jupiter.api.Test;

class ArrayValidatorImplTest {

  private static final String VALID_LINE = "1;2;3";
  private static final String VALID_LINE_WITH_NEGATIVE_NUMBER = "-5;10;-3";
  private static final String BLANK_LINE = "";
  private static final String COMMA_DELIMITED_LINE = "1,2,x3,6..5,77";
  private static final String LINE_WITH_LETTER_IN_TOKEN = "1y1;21;32";
  private static final String LINE_WITH_TRAILING_DELIMITER = "11-2-42-";

  @Test
  void shouldAcceptLineWithSemicolonDelimitedIntegers() {
    final ArrayValidator validator = new ArrayValidatorImpl();
    final boolean isValid = validator.isValid(VALID_LINE);
    assertTrue(isValid);
  }

  @Test
  void shouldAcceptLineWithNegativeIntegers() {
    final ArrayValidator validator = new ArrayValidatorImpl();
    final boolean isValid = validator.isValid(VALID_LINE_WITH_NEGATIVE_NUMBER);
    assertTrue(isValid);
  }

  @Test
  void shouldAcceptBlankLineAsAnEmptyArray() {
    final ArrayValidator validator = new ArrayValidatorImpl();
    final boolean isValid = validator.isValid(BLANK_LINE);
    assertTrue(isValid);
  }

  @Test
  void shouldRejectCommaDelimitedLine() {
    final ArrayValidator validator = new ArrayValidatorImpl();
    final boolean isValid = validator.isValid(COMMA_DELIMITED_LINE);
    assertFalse(isValid);
  }

  @Test
  void shouldRejectLineWithLetterInsideToken() {
    final ArrayValidator validator = new ArrayValidatorImpl();
    final boolean isValid = validator.isValid(LINE_WITH_LETTER_IN_TOKEN);
    assertFalse(isValid);
  }

  @Test
  void shouldRejectLineWithTrailingDelimiter() {
    final ArrayValidator validator = new ArrayValidatorImpl();
    final boolean isValid = validator.isValid(LINE_WITH_TRAILING_DELIMITER);
    assertFalse(isValid);
  }
}
