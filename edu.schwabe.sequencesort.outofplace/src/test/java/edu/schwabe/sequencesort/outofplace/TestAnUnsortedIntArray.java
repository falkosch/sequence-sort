package edu.schwabe.sequencesort.outofplace;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.schwabe.sequencesort.api.Algorithm;

class TestAnUnsortedIntArray {

    private Algorithm testUnit;

    @BeforeEach
    void setup() {
	this.testUnit = new AlgorithmImpl();
    }

    @Test
    void isTransformedIntoASortedIntArray() {
	final int[] givenUnsorted = { 3, 1, 2, 0, 4, 2, -1 };
	final int[] expectedSorted = { -1, 0, 1, 2, 2, 3, 4 };
	Assertions.assertArrayEquals(expectedSorted, this.testUnit.sort(givenUnsorted).returnedValue());
    }
}
