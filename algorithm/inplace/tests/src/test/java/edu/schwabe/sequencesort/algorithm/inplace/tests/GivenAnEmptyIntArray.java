package edu.schwabe.sequencesort.algorithm.inplace.tests;

import org.eclipse.jdt.annotation.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import edu.schwabe.sequencesort.algorithm.Algorithm;
import edu.schwabe.sequencesort.algorithm.inplace.AlgorithmImpl;

class GivenAnEmptyIntArray {

	private static final int @NonNull [] EMPTY_INT_ARRAY = {};

	@Nested
	class WhenSortedByTheAlgorithm {

		private Algorithm testUnit;

		@BeforeEach
		void setup() {
			this.testUnit = new AlgorithmImpl();
		}

		@Test
		void itShouldRemainEmpty() {
			Assertions.assertArrayEquals(
			    GivenAnEmptyIntArray.EMPTY_INT_ARRAY,
			    this.testUnit.sort(GivenAnEmptyIntArray.EMPTY_INT_ARRAY).returnedValue()
			);
		}
	}
}
