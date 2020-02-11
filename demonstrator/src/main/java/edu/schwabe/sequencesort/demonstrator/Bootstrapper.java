package edu.schwabe.sequencesort.demonstrator;

import edu.schwabe.sequencesort.algorithm.Algorithm;
import edu.schwabe.sequencesort.algorithm.OperationReport;
import edu.schwabe.sequencesort.algorithm.Reporter;
import edu.schwabe.sequencesort.demonstrator.arguments.TrialArgumentParser;
import java.util.Random;
import java.util.ServiceLoader;
import java.util.stream.IntStream;

final class Bootstrapper {

  private static final Random RANDOM_WITH_FIXED_SEEK = new Random(0);

  public static void main(final String[] args) {
    final int trialCount = TrialArgumentParser.parseTrialArgument(args);

    final var reporter = ServiceLoader.load(Reporter.class).findFirst();

    ServiceLoader.load(Algorithm.class).forEach(
        algorithmUnderTest -> Bootstrapper.runTest(algorithmUnderTest, reporter.get(), trialCount)
    );
  }

  private static void runTest(
      final Algorithm algorithmUnderTest, final Reporter reporter, final int trialCount
  ) {

    final var operationReportStream = IntStream.range(0, trialCount).mapToObj(trial -> {
      final var itemCount = (long) Math.pow(10, trial);
      final var items = Bootstrapper.RANDOM_WITH_FIXED_SEEK.ints(itemCount).toArray();

      final var startTime = System.nanoTime();
      final var operationResult = algorithmUnderTest.sort(items);
      final var duration = System.nanoTime() - startTime;

      return new OperationReport(operationResult, trial, duration);
    });

    reporter.display(algorithmUnderTest.getClass(), operationReportStream);
  }

}
