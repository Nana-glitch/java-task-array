package array.parser;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import array.exception.ArrayProcessingException;
import array.parser.impl.ArrayParserImpl;
import org.junit.jupiter.api.Test;

class ArrayParserImplTest {

  private static final String VALID_LINE = "1;2;3";
  private static final int[] EXPECTED_VALUES = {1, 2, 3};
  private static final String BLANK_LINE = "";
  private static final String LINE_WITH_LETTER_IN_TOKEN = "1y1;21;32";

  @Test
  void shouldParseSemicolonDelimitedLineIntoMatchingArray() throws ArrayProcessingException {
    final ArrayParser parser = new ArrayParserImpl();
    final int[] actual = parser.parse(VALID_LINE);
    assertArrayEquals(EXPECTED_VALUES, actual);
  }

  @Test
  void shouldParseBlankLineIntoEmptyArray() throws ArrayProcessingException {
    final ArrayParser parser = new ArrayParserImpl();
    final int[] actual = parser.parse(BLANK_LINE);
    assertArrayEquals(new int[0], actual);
  }

  @Test
  void shouldThrowArrayProcessingExceptionForNonNumericToken() {
    final ArrayParser parser = new ArrayParserImpl();
    assertThrows(ArrayProcessingException.class, () -> parser.parse(LINE_WITH_LETTER_IN_TOKEN));
  }
}
