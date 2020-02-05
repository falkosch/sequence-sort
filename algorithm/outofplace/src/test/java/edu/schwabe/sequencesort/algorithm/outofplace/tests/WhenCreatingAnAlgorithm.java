package edu.schwabe.sequencesort.algorithm.outofplace.tests;

import edu.schwabe.sequencesort.algorithm.outofplace.AlgorithmImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WhenCreatingAnAlgorithm {

  @Test
  public static void thenItShouldNotThrow() {
    Assertions.assertDoesNotThrow(() -> {
      return new AlgorithmImpl();
    });
  }
}
