package edu.schwabe.sequencesort.algorithm.outofplace.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.schwabe.sequencesort.algorithm.outofplace.AlgorithmImpl;

class WhenCreatingAnAlgorithm {

	@Test
	void itShouldNotThrow() {
		Assertions.assertDoesNotThrow(() -> {
			return new AlgorithmImpl();
		});
	}
}
