package edu.schwabe.sequencesort.algorithm.inplace;

import edu.schwabe.sequencesort.algorithm.Algorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ScenarioSortingAlreadySortedArrays {

  @Nested
  public class GivenAlgorithmInstance {

    private Algorithm testUnit;

    @BeforeEach
    public void setup() {
      this.testUnit = new AlgorithmImpl();
    }

    @Nested
    public class GivenSortedArrayWithTwoUniqueValues {

      private int[] values;

      @BeforeEach
      public void setup() {
        this.values = new int[] { 0, 1 };
      }

      @Nested
      public class WhenSortedByTheAlgorithm {

        private int[] actual;

        @BeforeEach
        public void setup() {
          this.actual = GivenAlgorithmInstance.this.testUnit
              .sort(GivenSortedArrayWithTwoUniqueValues.this.values).getReturnedValue();
        }

        @Test
        public void thenItShouldRemainSorted() {
          Assertions
              .assertArrayEquals(GivenSortedArrayWithTwoUniqueValues.this.values, this.actual);
        }
      }
    }

    @Nested
    public class GivenSortedArrayWithMultipleUniqueValues {

      private int[] values;

      @BeforeEach
      public void setup() {
        this.values = new int[] { 0, 1, 2, 3, 4 };
      }

      @Nested
      public class WhenSortedByTheAlgorithm {

        private int[] actual;

        @BeforeEach
        public void setup() {
          this.actual = GivenAlgorithmInstance.this.testUnit
              .sort(GivenSortedArrayWithMultipleUniqueValues.this.values).getReturnedValue();
        }

        @Test
        public void thenItShouldRemainSorted() {
          Assertions
              .assertArrayEquals(GivenSortedArrayWithMultipleUniqueValues.this.values, this.actual);
        }
      }
    }

    @Nested
    public class GivenSortedArrayWithDuplicates {

      private int[] values;

      @BeforeEach
      public void setup() {
        this.values = new int[] { 0, 1, 1, 3, 4 };
      }

      @Nested
      public class WhenSortedByTheAlgorithm {

        private int[] actual;

        @BeforeEach
        public void setup() {
          this.actual = GivenAlgorithmInstance.this.testUnit
              .sort(GivenSortedArrayWithDuplicates.this.values).getReturnedValue();
        }

        @Test
        public void thenItShouldRemainSorted() {
          Assertions.assertArrayEquals(GivenSortedArrayWithDuplicates.this.values, this.actual);
        }
      }
    }
  }
}