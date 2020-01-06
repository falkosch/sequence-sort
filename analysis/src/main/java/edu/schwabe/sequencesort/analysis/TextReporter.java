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
import org.eclipse.jdt.annotation.NonNull;

public final class TextReporter implements Reporter {

  @Override
  public void display(
    final @NonNull Class<? extends Algorithm> algorithmUnderTestClass,
    final @NonNull Stream<OperationReport> operationReportStream
  ) {
    System.out.println(algorithmUnderTestClass.getName());
    operationReportStream.forEach(TextReporter::display);
  }

  private static void display(final @NonNull OperationReport report) {
    TextReporter.display(report.operationResult(), report.trial(), report.duration());
  }

  private static void display(
    final @NonNull OperationResult<int @NonNull []> operationResult, final int trial,
    final long duration
  ) {
    final var n = operationResult.returnedValue().length;
    final String isSortedQualifier = TextReporter.makeIsSortedQualifier(operationResult);
    System.out
      .printf("\tTrial %1$d with n=%2$d elements: array is %3$s\n", Integer.valueOf(trial), Long.valueOf(n), isSortedQualifier);

    final long durationSeconds = TimeUnit.NANOSECONDS.toSeconds(duration) + 1;
    final long durationPerElement = duration / n;
    System.out.printf(
      "\t\tTime:\t\t\t%1$dns | <%2$ds\n", Long.valueOf(duration), Long.valueOf(durationSeconds)
    );
    System.out.printf("\t\tTime per element:\t%1$dns\n", Long.valueOf(durationPerElement));

    TextReporter.printMetric("Comparisons", "c", operationResult.comparisons(), n);
    TextReporter.printMetric("Swaps", "s", operationResult.swaps(), n);
  }

  private static String makeIsSortedQualifier(
    final @NonNull OperationResult<int @NonNull []> operationResult
  ) {
    final var sortedProperty = ServiceLoader.load(SortedProperty.class).findFirst().get();
    return sortedProperty.fulfilledBy(operationResult) ? "sorted" : "NOT sorted";
  }

  private static void printMetric(
    final String metricName, final String metricVariableName, final long metricValue, final long n
  ) {
    final var metric = new OperationMetric(metricValue, n);
    TextReporter.printMetric(metricName, metricVariableName, metric);
  }

  private static void printMetric(
    final String metricName, final String metricVariableName, final OperationMetric metric
  ) {
    System.out.printf(
      "\t\t%1$s:\t %2$s=%3$d | %2$s/(n*ln(n))=%4$f | %2$s/(n*sqrt(n))=%5$f | %2$s/(n*n)=%6$f\n",
      metricName, metricVariableName, metric.value(),
      // will be relatively near 1 if the algorithm is of time complexity O(n*log(n))
      metric.divideByNLnN(),
      // same ... if it is of tc. O(n*sqrt(n))
      metric.divideByNSqrtN(),
      // same ... if it is of tc. O(n*n)
      metric.divideBySqrN()
    );
  }
}
