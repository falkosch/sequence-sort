package edu.schwabe.sequencesort.outofplace;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.schwabe.sequencesort.api.Algorithm;

class TestASortedIntArray {

    private Algorithm testUnit;

    @BeforeEach
    void setup() {
	this.testUnit = new AlgorithmImpl();
    }

    @Test
    void remainsSorted() {
	final int[] givenSorted = { -1, 0, 1, 2, 2, 3, 4 };
	Assertions.assertArrayEquals(givenSorted, this.testUnit.sort(givenSorted).returnedValue());
    }
}
