package edu.schwabe.sequencesort.outofplace;

import java.util.ServiceLoader;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.schwabe.sequencesort.api.Algorithm;

class TestAnAlgorithm {

    private Algorithm testUnit;

    @BeforeEach
    void setup() {
	this.testUnit = ServiceLoader.load(Algorithm.class).findFirst().get();
    }

    @Test
    void isProvidedAsService() {
	Assertions.assertNotNull(this.testUnit);
    }

    @Test
    void isOfTheExpectedType() {
	Assertions.assertSame(AlgorithmImpl.class, this.testUnit.getClass());
    }
}
