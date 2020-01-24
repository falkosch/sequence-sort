package edu.schwabe.sequencesort.algorithm.inplace;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WhenCreatingAnAlgorithm {

  @Test
  public void itShouldNotThrow() {
    Assertions.assertDoesNotThrow(() -> {
      return new AlgorithmImpl();
    });
  }
}
