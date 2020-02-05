package edu.schwabe.sequencesort.algorithm.inplace;

import edu.schwabe.sequencesort.algorithm.Algorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class GivenAnEmptyIntArray {

  private static final int[] EMPTY_INT_ARRAY = {};

  @Nested
  public class WhenSortedByTheAlgorithm {

    private Algorithm testUnit;

    @BeforeEach
    public void setup() {
      this.testUnit = new AlgorithmImpl();
    }

    @Test
    public void thenItShouldRemainEmpty() {
      Assertions.assertArrayEquals(
          GivenAnEmptyIntArray.EMPTY_INT_ARRAY,
          this.testUnit.sort(GivenAnEmptyIntArray.EMPTY_INT_ARRAY).getReturnedValue()
      );
    }
  }
}
