package array.parser;

import array.exception.ArrayProcessingException;

public interface ArrayParser {

  int[] parse(String line) throws ArrayProcessingException;
}
