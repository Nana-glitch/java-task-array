package array;

import array.algorithm.BubbleSortStrategy;
import array.algorithm.InsertionSortStrategy;
import array.algorithm.SortStrategy;
import array.entity.IntArray;
import array.exception.ArrayProcessingException;
import array.factory.ArrayFactory;
import array.factory.impl.ArrayFactoryImpl;
import array.parser.ArrayParser;
import array.parser.impl.ArrayParserImpl;
import array.reader.ArrayReader;
import array.reader.impl.ArrayReaderImpl;
import array.service.AverageService;
import array.service.MinMaxService;
import array.service.SortService;
import array.service.SumService;
import array.service.impl.AverageServiceImpl;
import array.service.impl.MinMaxServiceImpl;
import array.service.impl.SortServiceImpl;
import array.service.impl.SumServiceImpl;
import array.validator.ArrayValidator;
import array.validator.impl.ArrayValidatorImpl;
import array.writer.ResultWriter;
import array.writer.impl.ResultWriterImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

  private static final String INPUT_FILE_PATH = "data/arrays.txt";
  private static final String OUTPUT_FILE_PATH = "output/result.txt";

  private final Logger logger = LogManager.getLogger(getClass());

  public void run() {
    final ArrayReader reader = new ArrayReaderImpl();
    final ArrayValidator validator = new ArrayValidatorImpl();
    final ArrayParser parser = new ArrayParserImpl();
    final ArrayFactory factory = new ArrayFactoryImpl(reader, validator, parser);

    final MinMaxService minMaxService = new MinMaxServiceImpl();
    final SumService sumService = new SumServiceImpl();
    final AverageService averageService = new AverageServiceImpl();
    final SortService sortService = new SortServiceImpl();
    final SortStrategy bubbleSort = new BubbleSortStrategy();
    final SortStrategy insertionSort = new InsertionSortStrategy();
    final ResultWriter writer = new ResultWriterImpl();

    try {
      final List<IntArray> arrays = factory.createFromFile(INPUT_FILE_PATH);
      final List<String> report = new ArrayList<>();
      for (IntArray array : arrays) {
        report.add(describe(array, minMaxService, sumService, averageService, sortService,
            bubbleSort, insertionSort));
      }
      writer.writeLines(OUTPUT_FILE_PATH, report);
      logger.info("processing finished, {} array(s) written to [{}]", arrays.size(),
          OUTPUT_FILE_PATH);
    } catch (ArrayProcessingException e) {
      logger.error("processing failed", e);
    }
  }

  private String describe(IntArray array, MinMaxService minMaxService, SumService sumService,
      AverageService averageService, SortService sortService, SortStrategy bubbleSort,
      SortStrategy insertionSort) {
    final int[] values = array.getValues();
    final Optional<Integer> min = minMaxService.findMin(values);
    final Optional<Integer> max = minMaxService.findMax(values);
    final Optional<Long> sum = sumService.calculateSum(values);
    final Optional<Double> average = averageService.calculateAverage(values);
    final int[] bubbleSorted = sortService.sort(values, bubbleSort);
    final int[] insertionSorted = sortService.sort(values, insertionSort);

    final StringBuilder line = new StringBuilder();
    line.append("id=").append(array.getId());
    line.append(", values=").append(Arrays.toString(values));
    line.append(", min=").append(min.map(String::valueOf).orElse("N/A"));
    line.append(", max=").append(max.map(String::valueOf).orElse("N/A"));
    line.append(", sum=").append(sum.map(String::valueOf).orElse("N/A"));
    line.append(", average=").append(average.map(String::valueOf).orElse("N/A"));
    line.append(", bubbleSorted=").append(Arrays.toString(bubbleSorted));
    line.append(", insertionSorted=").append(Arrays.toString(insertionSorted));
    return line.toString();
  }

  public static void main(String[] args) {
    new Main().run();
  }
}
