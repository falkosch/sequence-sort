package edu.schwabe.sequencesort.testrunner;

import java.util.Arrays;
import java.util.Random;
import java.util.ServiceLoader;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import edu.schwabe.sequencesort.api.Algorithm;

class Main {

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

	for (var j = 0; j < 7; j++) {

	    final var size = (long) Math.pow(10, j);
	    final Supplier<IntStream> given = () -> new Random(0).ints(size);
	    final var givenNotSorted = given.get().toArray();
	    final var expectedSorted = given.get().sorted().toArray();

	    final var startTime = System.nanoTime();

	    final var operationResult = algorithmUnderTest.sort(givenNotSorted);
	    final int[] actual = operationResult.returnedValue();

	    final var duration = System.nanoTime() - startTime;

	    System.out.printf("Trial %1$d with n=%2$d elements:", Integer.valueOf(j), Long.valueOf(size));
	    if (Arrays.equals(actual, expectedSorted)) {
		System.out.println("\tarray is sorted!");
	    } else {
		System.out.println("\tarray is NOT sorted!");
	    }

	    System.out.printf("\tTime:\t\t\t%1$dns | <%2$ds\n", Long.valueOf(duration),
		    Long.valueOf(TimeUnit.NANOSECONDS.toSeconds(duration) + 1));
	    System.out.printf("\tTime per element:\t%1$dns\n", Long.valueOf(duration / size));

	    System.out.printf("\tComparisons:\t c=%1$d | c/(n*ln(n))=%2$f | c/(n*sqrt(n))=%3$f | c/(n*n)=%4$f\n",
		    Long.valueOf(operationResult.comparisons()),
		    // will be relatively near 1 if the algorithm is of time complexity O(n*log(n))
		    Double.valueOf(Main.divideByNLnN(operationResult.comparisons(), size)),
		    // same ... if it is of tc. O(n*sqrt(n))
		    Double.valueOf(Main.divideByNSqrtN(operationResult.comparisons(), size)),
		    // same ... if it is of tc. O(n*n)
		    Double.valueOf(Main.divideBySqrN(operationResult.comparisons(), size)));

	    System.out.printf("\tSwappings:\t s=%1$d | s/(n*ln(n))=%2$f | s/(n*sqrt(n))=%3$f | s/(n*n)=%4$f\n",
		    Long.valueOf(operationResult.swaps()),
		    // will be relatively near 1 if the algorithm is of time complexity O(n*log(n))
		    Double.valueOf(Main.divideByNLnN(operationResult.swaps(), size)),
		    // same ... if it is of tc. O(n*sqrt(n))
		    Double.valueOf(Main.divideByNSqrtN(operationResult.swaps(), size)),
		    // same ... if it is of tc. O(n*n)
		    Double.valueOf(Main.divideBySqrN(operationResult.swaps(), size)));
	}
    }

}
