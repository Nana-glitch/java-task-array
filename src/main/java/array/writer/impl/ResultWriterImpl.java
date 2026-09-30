package array.writer.impl;

import array.exception.ArrayProcessingException;
import array.writer.ResultWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ResultWriterImpl implements ResultWriter {

  private final Logger logger = LogManager.getLogger(getClass());

  @Override
  public void writeLines(String filePath, List<String> lines) throws ArrayProcessingException {
    final Path path = Path.of(filePath);
    try {
      final Path parentDirectory = path.getParent();
      if (parentDirectory != null && !Files.exists(parentDirectory)) {
        Files.createDirectories(parentDirectory);
      }
      Files.write(path, lines, StandardCharsets.UTF_8);
      logger.info("wrote {} line(s) to [{}]", lines.size(), filePath);
    } catch (IOException e) {
      throw new ArrayProcessingException("cannot write file [" + filePath + "]", e);
    }
  }
}
