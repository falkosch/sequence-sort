package edu.schwabe.sequencesort.algorithm.inplace.tests;

import edu.schwabe.sequencesort.algorithm.inplace.AlgorithmImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WhenCreatingAnAlgorithm {

  @Test
  static void itShouldNotThrow() {
    Assertions.assertDoesNotThrow(() -> {
      return new AlgorithmImpl();
    });
  }
}
