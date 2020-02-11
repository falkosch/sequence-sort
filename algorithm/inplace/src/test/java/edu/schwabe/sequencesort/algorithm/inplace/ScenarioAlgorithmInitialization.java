package edu.schwabe.sequencesort.algorithm.inplace;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ScenarioAlgorithmInitialization {

  @Nested
  public class WhenCreatingTheAlgorithm {

    @Test
    public void thenItShouldNotThrow() {
      Assertions.assertDoesNotThrow(() -> {
        return new AlgorithmImpl();
      });
    }
  }
}
