package edu.schwabe.sequencesort.testrunner;

import java.util.Random;
import java.util.ServiceLoader;
import java.util.stream.IntStream;

import org.eclipse.jdt.annotation.NonNull;

import edu.schwabe.sequencesort.algorithm.Algorithm;
import edu.schwabe.sequencesort.algorithm.OperationReport;
import edu.schwabe.sequencesort.algorithm.Reporter;

final class Main {

    public static void main(final String[] args) {
        final var report = ServiceLoader.load(Reporter.class).findFirst().get();
        ServiceLoader.load(Algorithm.class)
            .forEach(algorithmUnderTest -> Main.runTest(algorithmUnderTest, report));
    }

    private static void runTest(
        final @NonNull Algorithm algorithmUnderTest, @NonNull final Reporter report
    ) {

        final var operationReportStream = IntStream.range(0, 7).mapToObj(trial -> {
            final var n = (long) Math.pow(10, trial);
            final var given = new Random(0).ints(n).toArray();

            final var startTime = System.nanoTime();

            final var operationResult = algorithmUnderTest.sort(given);

            final var duration = System.nanoTime() - startTime;

            return new OperationReport(operationResult, trial, duration);
        });

        report.display(algorithmUnderTest.getClass(), operationReportStream);
    }

}
