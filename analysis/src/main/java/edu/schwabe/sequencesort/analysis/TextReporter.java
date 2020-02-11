package edu.schwabe.sequencesort.analysis;

import edu.schwabe.sequencesort.algorithm.Algorithm;
import edu.schwabe.sequencesort.algorithm.OperationReport;
import edu.schwabe.sequencesort.algorithm.OperationResult;
import edu.schwabe.sequencesort.algorithm.Reporter;
import edu.schwabe.sequencesort.algorithm.SortedProperty;
import edu.schwabe.sequencesort.analysis.report.OperationMetric;
import java.io.PrintStream;
import java.util.ServiceLoader;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public final class TextReporter implements Reporter {

  private static final String MESSAGE_DURATION = "\t\tTime:\t\t\t%1$dns | <%2$ds%n";
  private static final String MESSAGE_METRIC_SCALING =
      "\t\t%1$s:\t %2$s=%3$d | %2$s/(n*ln(n))=%4$f | %2$s/(n*sqrt(n))=%5$f | %2$s/(n*n)=%6$f%n";
  private static final String MESSAGE_TIME_PER_ELEMENT = "\t\tTime per element:\t%1$dns%n";
  private static final String MESSAGE_TRIAL = "\tTrial %1$d with n=%2$d elements: array is %3$s%n";

  private static final String COMPARISONS_NAME = "Comparisons";
  private static final String COMPARISONS_VARIABLE = "c";

  private static final String SWAPS_NAME = "Swaps";
  private static final String SWAPS_VARIABLE = "s";

  private static final String NOT_SORTED_QUALIFIER = "NOT sorted";
  private static final String SORTED_QUALIFIER = "sorted";

  @Override
  public void display(
      final Class<? extends Algorithm> algorithmClass, final Stream<OperationReport> reportsStream
  ) {
    final var streamOut = System.out;
    streamOut.println(algorithmClass.getName());
    reportsStream.forEach(r -> TextReporter.display(r, streamOut));
  }

  private static void display(final OperationReport report, final PrintStream streamOut) {
    TextReporter
        .display(report.getOperationResult(), report.getTrial(), report.getDuration(), streamOut);
  }

  private static void display(
      final OperationResult<int[]> operationResult, final int trial, final long duration,
      final PrintStream streamOut
  ) {
    final var n = operationResult.getReturnedValue().length;
    final var isSortedQualifier = TextReporter.makeIsSortedQualifier(operationResult);
    streamOut.printf(
        TextReporter.MESSAGE_TRIAL, Integer.valueOf(trial), Integer.valueOf(n), isSortedQualifier
    );

    final var durationSeconds = TimeUnit.NANOSECONDS.toSeconds(duration) + 1;
    final var durationPerElement = duration / n;
    streamOut.printf(
        TextReporter.MESSAGE_DURATION, Long.valueOf(duration), Long.valueOf(durationSeconds)
    );
    streamOut.printf(TextReporter.MESSAGE_TIME_PER_ELEMENT, Long.valueOf(durationPerElement));

    TextReporter.printMetric(
        TextReporter.COMPARISONS_NAME, TextReporter.COMPARISONS_VARIABLE,
        operationResult.getComparisons(), n, streamOut
    );
    TextReporter.printMetric(
        TextReporter.SWAPS_NAME, TextReporter.SWAPS_VARIABLE, operationResult.getSwaps(), n,
        streamOut
    );
  }

  private static String makeIsSortedQualifier(final OperationResult<int[]> operationResult) {
    final var sortedProperty = ServiceLoader.load(SortedProperty.class).findFirst();

    final var propertyImplementor = sortedProperty.get();
    final var sortedPropertyFulfilled = propertyImplementor.fulfilledBy(operationResult);
    return sortedPropertyFulfilled ? TextReporter.SORTED_QUALIFIER
        : TextReporter.NOT_SORTED_QUALIFIER;
  }

  private static void printMetric(
      final String metricName, final String metricVariableName, final long metricValue,
      final long itemCount, final PrintStream streamOut
  ) {
    final var metric = new OperationMetric(metricValue, itemCount);
    TextReporter.printMetric(metricName, metricVariableName, metric, streamOut);
  }

  private static void printMetric(
      final String metricName, final String metricVariableName, final OperationMetric metric,
      final PrintStream streamOut
  ) {
    streamOut.printf(
        TextReporter.MESSAGE_METRIC_SCALING, metricName, metricVariableName,
        metric.getValueAsBoxedLong(),
        // will be relatively near 1 if the algorithm is of time complexity O(n*log(n))
        metric.divideValueByNLnN(),
        // same ... if it is of tc. O(n*sqrt(n))
        metric.divideValueByNSqrtN(),
        // same ... if it is of tc. O(n*n)
        metric.divideValueBySqrN()
    );
  }
}
