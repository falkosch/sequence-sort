package edu.schwabe.sequencesort.analysis;

import edu.schwabe.sequencesort.algorithm.Algorithm;
import edu.schwabe.sequencesort.algorithm.OperationReport;
import edu.schwabe.sequencesort.algorithm.OperationResult;
import edu.schwabe.sequencesort.algorithm.Reporter;
import edu.schwabe.sequencesort.algorithm.SortedProperty;
import edu.schwabe.sequencesort.analysis.report.OperationMetric;
import java.util.ServiceLoader;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public final class TextReporter implements Reporter {

  @Override
  public void display(
      final Class<? extends Algorithm> algorithmClass, final Stream<OperationReport> reportsStream
  ) {
    System.out.println(algorithmClass.getName());
    reportsStream.forEach(TextReporter::display);
  }

  private static void display(final OperationReport report) {
    TextReporter.display(report.getOperationResult(), report.getTrial(), report.getDuration());
  }

  private static void display(
      final OperationResult<int[]> operationResult, final int trial, final long duration
  ) {
    final var n = operationResult.getReturnedValue().length;
    final var isSortedQualifier = TextReporter.makeIsSortedQualifier(operationResult);
    final var message = "\tTrial %1$d with n=%2$d elements: array is %3$s%n";
    System.out.printf(message, Integer.valueOf(trial), Integer.valueOf(n), isSortedQualifier);

    final long durationSeconds = TimeUnit.NANOSECONDS.toSeconds(duration) + 1;
    final long durationPerElement = duration / n;
    System.out.printf(
        "\t\tTime:\t\t\t%1$dns | <%2$ds%n", Long.valueOf(duration), Long.valueOf(durationSeconds)
    );
    System.out.printf("\t\tTime per element:\t%1$dns%n", Long.valueOf(durationPerElement));

    TextReporter.printMetric("Comparisons", "c", operationResult.getComparisons(), n);
    TextReporter.printMetric("Swaps", "s", operationResult.getSwaps(), n);
  }

  private static String makeIsSortedQualifier(final OperationResult<int[]> operationResult) {
    final var sortedProperty = ServiceLoader.load(SortedProperty.class).findFirst();
    if (sortedProperty.isEmpty()) {
      return " - N/A - ";
    }

    final var propertyImplementor = sortedProperty.get();
    final var sortedPropertyFulfilled = propertyImplementor.fulfilledBy(operationResult);
    return sortedPropertyFulfilled ? "sorted" : "NOT sorted";
  }

  private static void printMetric(
      final String metricName, final String metricVariableName, final long metricValue,
      final long itemCount
  ) {
    final var metric = new OperationMetric(metricValue, itemCount);
    TextReporter.printMetric(metricName, metricVariableName, metric);
  }

  private static void printMetric(
      final String metricName, final String metricVariableName, final OperationMetric metric
  ) {
    System.out.printf(
        "\t\t%1$s:\t %2$s=%3$d | %2$s/(n*ln(n))=%4$f | %2$s/(n*sqrt(n))=%5$f | %2$s/(n*n)=%6$f%n",
        metricName, metricVariableName, metric.getValueAsBoxedLong(),
        // will be relatively near 1 if the algorithm is of time complexity O(n*log(n))
        metric.divideValueByNLnN(),
        // same ... if it is of tc. O(n*sqrt(n))
        metric.divideValueByNSqrtN(),
        // same ... if it is of tc. O(n*n)
        metric.divideValueBySqrN()
    );
  }
}
