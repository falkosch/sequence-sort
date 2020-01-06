package edu.schwabe.sequencesort.algorithm.outofplace.tests;

import edu.schwabe.sequencesort.algorithm.Algorithm;
import edu.schwabe.sequencesort.algorithm.outofplace.AlgorithmImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GivenASortedIntArray {

  private static final int[] SORTED_INT_ARRAY = { -1, 0, 1, 2, 2, 3, 4 };

  @Nested
  class WhenSortedByTheAlgorithm {

    private Algorithm testUnit;

    @BeforeEach
    void setup() {
      this.testUnit = new AlgorithmImpl();
    }

    @Test
    void itShouldRemainSorted() {
      Assertions.assertArrayEquals(
        GivenASortedIntArray.SORTED_INT_ARRAY,
        this.testUnit.sort(GivenASortedIntArray.SORTED_INT_ARRAY).returnedValue()
      );
    }
  }

}
