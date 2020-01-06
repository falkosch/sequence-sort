package edu.schwabe.sequencesort.algorithm.inplace.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.schwabe.sequencesort.algorithm.inplace.AlgorithmImpl;

class WhenCreatingAnAlgorithm {

    @Test
    void itShouldNotThrow() {
        Assertions.assertDoesNotThrow(() -> {
            return new AlgorithmImpl();
        });
    }
}
