package edu.schwabe.sequencesort.testrunner;

import java.util.Arrays;
import java.util.Random;
import java.util.ServiceLoader;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import edu.schwabe.sequencesort.api.Algorithm;

final class Main {

    public static void main(final String[] args) {
	ServiceLoader.load(Algorithm.class).forEach(Main::runTest);
    }

    private static double divideByNLnN(final long count, final long n) {
	return count / (n * Math.log(n));
    }

    private static double divideByNSqrtN(final long count, final long n) {
	return count / (n * Math.sqrt(n));
    }

    private static double divideBySqrN(final long count, final long n) {
	return count / (double) (n * n);
    }

    private static void runTest(final Algorithm algorithmUnderTest) {
	System.out.println(algorithmUnderTest.getClass().getName());

	for (var nExp10 = 0; nExp10 < 7; nExp10++) {

	    final var n = (long) Math.pow(10, nExp10);
	    final Supplier<IntStream> given = () -> new Random(0).ints(n);
	    final var givenNotSorted = given.get().toArray();
	    final var expectedSorted = given.get().sorted().toArray();

	    final var startTime = System.nanoTime();

	    final var operationResult = algorithmUnderTest.sort(givenNotSorted);
	    final int[] actual = operationResult.returnedValue();

	    final var duration = System.nanoTime() - startTime;

	    System.out.printf("Trial %1$d with n=%2$d elements:", Integer.valueOf(nExp10), Long.valueOf(n));
	    if (Arrays.equals(actual, expectedSorted)) {
		System.out.println("\tarray is sorted!");
	    } else {
		System.out.println("\tarray is NOT sorted!");
	    }

	    System.out.printf("\tTime:\t\t\t%1$dns | <%2$ds\n", Long.valueOf(duration),
		    Long.valueOf(TimeUnit.NANOSECONDS.toSeconds(duration) + 1));
	    System.out.printf("\tTime per element:\t%1$dns\n", Long.valueOf(duration / n));

	    Main.printMetric("Comparisons", "c", operationResult.comparisons(), n);
	    Main.printMetric("Swaps", "s", operationResult.swaps(), n);
	}
    }

    private static void printMetric(final String metricName, final String metricVariableName, final long metricValue,
	    final long n) {
	System.out.printf("\t%1$s:\t %2$s=%3$d | %2$s/(n*ln(n))=%4$f | %2$s/(n*sqrt(n))=%5$f | %2$s/(n*n)=%6$f\n",
		metricName, metricVariableName, Long.valueOf(metricValue),
		// will be relatively near 1 if the algorithm is of time complexity O(n*log(n))
		Double.valueOf(Main.divideByNLnN(metricValue, n)),
		// same ... if it is of tc. O(n*sqrt(n))
		Double.valueOf(Main.divideByNSqrtN(metricValue, n)),
		// same ... if it is of tc. O(n*n)
		Double.valueOf(Main.divideBySqrN(metricValue, n)));
    }

}
