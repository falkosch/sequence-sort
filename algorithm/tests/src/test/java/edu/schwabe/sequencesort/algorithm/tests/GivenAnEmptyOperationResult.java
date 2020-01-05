package edu.schwabe.sequencesort.algorithm.tests;

import org.eclipse.jdt.annotation.NonNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import edu.schwabe.sequencesort.algorithm.OperationResult;

class GivenAnEmptyOperationResult {

	private OperationResult<int @NonNull []> testUnit;

	@BeforeEach
	void setup() {
		this.testUnit = new OperationResult<>();
	}

	@Nested
	class WhenAddingSwaps {

		private OperationResult<int @NonNull []> actual;

		@BeforeEach
		void setup() {
			this.actual = GivenAnEmptyOperationResult.this.testUnit.addSwaps(10);
		}

		@Test
		void itShouldReturnANewOperationResult() {
			Assertions.assertNotSame(GivenAnEmptyOperationResult.this.testUnit, this.actual);
		}

		@Test
		void theNewOperationResultShouldHaveTheCountOfAddedSwaps() {
			Assertions.assertEquals(10, this.actual.swaps());
		}
	}
}
