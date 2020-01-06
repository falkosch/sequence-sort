package edu.schwabe.sequencesort.algorithm.outofplace.tests;

import edu.schwabe.sequencesort.algorithm.outofplace.AlgorithmImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WhenCreatingAnAlgorithm {

  @Test
  void itShouldNotThrow() {
    Assertions.assertDoesNotThrow(() -> {
      return new AlgorithmImpl();
    });
  }
}
