package edu.schwabe.sequencesort.outofplace;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.schwabe.sequencesort.api.Algorithm;

class TestAnEmptyIntArray {

    private Algorithm testUnit;

    @BeforeEach
    void setup() {
	this.testUnit = new AlgorithmImpl();
    }

    @Test
    void remainsEmpty() {
	final int[] given = {};
	Assertions.assertArrayEquals(given, this.testUnit.sort(given).returnedValue());
    }
}
