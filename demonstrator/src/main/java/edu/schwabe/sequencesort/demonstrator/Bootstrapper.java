package edu.schwabe.sequencesort.demonstrator;

import edu.schwabe.sequencesort.algorithm.Algorithm;
import edu.schwabe.sequencesort.algorithm.OperationReport;
import edu.schwabe.sequencesort.algorithm.OperationResult;
import edu.schwabe.sequencesort.algorithm.Reporter;
import java.util.Random;
import java.util.ServiceLoader;
import java.util.stream.IntStream;

final class Bootstrapper {

  public static void main(final String[] args) {
    final var report = ServiceLoader.load(Reporter.class).findFirst();
    if (report.isEmpty()) {
      return;
    }
    ServiceLoader.load(Algorithm.class)
      .forEach(algorithmUnderTest -> Bootstrapper.runTest(algorithmUnderTest, report.get()));
  }

  private static void runTest(final Algorithm algorithmUnderTest, final Reporter report) {

    final var operationReportStream = IntStream.range(0, 7).mapToObj(trial -> {
      final var itemCount = (long) Math.pow(10, trial);
      final var items = new Random(0).ints(itemCount).toArray();
      if (items == null) {
        return new OperationReport(new OperationResult<>(), trial, -1);
      }

      final var startTime = System.nanoTime();
      final var operationResult = algorithmUnderTest.sort(items);
      final var duration = System.nanoTime() - startTime;
      return new OperationReport(operationResult, trial, duration);
    });

    report.display(algorithmUnderTest.getClass(), operationReportStream);
  }

}
