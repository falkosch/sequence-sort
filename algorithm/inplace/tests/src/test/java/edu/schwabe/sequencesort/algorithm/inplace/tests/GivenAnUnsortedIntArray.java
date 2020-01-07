package edu.schwabe.sequencesort.algorithm.inplace.tests;

import edu.schwabe.sequencesort.algorithm.Algorithm;
import edu.schwabe.sequencesort.algorithm.inplace.AlgorithmImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GivenAnUnsortedIntArray {

  private static final int[] UNSORTED_INT_ARRAY = { 3, 1, 2, 0, 4, 2, -1 };

  @Nested
  class WhenSortedByTheAlgorithm {

    private Algorithm testUnit;

    @BeforeEach
    void setup() {
      this.testUnit = new AlgorithmImpl();
    }

    @Test
    void itShouldBeTransformedIntoASortedIntArray() {
      final int[] expectedSorted = { -1, 0, 1, 2, 2, 3, 4 };
      Assertions.assertArrayEquals(
          expectedSorted, this.testUnit.sort(GivenAnUnsortedIntArray.UNSORTED_INT_ARRAY).getReturnedValue()
      );
    }
  }
}
