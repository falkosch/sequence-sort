package edu.schwabe.sequencesort.algorithm.outofplace;

import edu.schwabe.sequencesort.algorithm.Algorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ScenarioSortingNotSortedArrays {

  @Nested
  public class GivenAlgorithm {

    private Algorithm testUnit;

    @BeforeEach
    public void setup() {
      this.testUnit = new AlgorithmImpl();
    }

    @Nested
    public class GivenUnsortedArrayWithTwoValues {

      private int[] values;

      @BeforeEach
      public void setup() {
        this.values = new int[] { 2, 1 };
      }

      @Nested
      public class WhenSortedByTheAlgorithm {

        private int[] actual;

        @BeforeEach
        public void setup() {
          this.actual = GivenAlgorithm.this.testUnit
              .sort(GivenUnsortedArrayWithTwoValues.this.values).getReturnedValue();
        }

        @Test
        public void thenItShouldBeTransformedIntoASortedIntArray() {
          Assertions.assertArrayEquals(new int[] { 1, 2 }, this.actual);
        }
      }
    }

    @Nested
    public class GivenReverseSortedArrayWithMultipleUniqueValues {

      private int[] values;

      @BeforeEach
      public void setup() {
        this.values = new int[] { 4, 3, 2, 1, 0 };
      }

      @Nested
      public class WhenSortedByTheAlgorithm {

        private int[] actual;

        @BeforeEach
        public void setup() {
          this.actual = GivenAlgorithm.this.testUnit
              .sort(GivenReverseSortedArrayWithMultipleUniqueValues.this.values).getReturnedValue();
        }

        @Test
        public void thenItShouldBeTransformedIntoASortedIntArray() {
          Assertions.assertArrayEquals(new int[] { 0, 1, 2, 3, 4 }, this.actual);
        }
      }
    }

    @Nested
    public class GivenUnsortedArrayWithRepeatingSequences {

      private int[] values;

      @BeforeEach
      public void setup() {
        this.values = new int[] { 2, 1, 2, 1 };
      }

      @Nested
      public class WhenSortedByTheAlgorithm {

        private int[] actual;

        @BeforeEach
        public void setup() {
          this.actual = GivenAlgorithm.this.testUnit
              .sort(GivenUnsortedArrayWithRepeatingSequences.this.values).getReturnedValue();
        }

        @Test
        public void thenItShouldBeTransformedIntoASortedIntArray() {
          Assertions.assertArrayEquals(new int[] { 1, 1, 2, 2 }, this.actual);
        }
      }
    }

    @Nested
    public class GivenUnsortedArrayWithOrderedSequencesAtFront {

      private int[] values;

      @BeforeEach
      public void setup() {
        this.values = new int[] { 1, 2, 1 };
      }

      @Nested
      public class WhenSortedByTheAlgorithm {

        private int[] actual;

        @BeforeEach
        public void setup() {
          this.actual = GivenAlgorithm.this.testUnit
              .sort(GivenUnsortedArrayWithOrderedSequencesAtFront.this.values).getReturnedValue();
        }

        @Test
        public void thenItShouldBeTransformedIntoASortedIntArray() {
          Assertions.assertArrayEquals(new int[] { 1, 1, 2 }, this.actual);
        }
      }
    }

    @Nested
    public class GivenUnsortedArrayWithOrderedSequencesAtTail {

      private int[] values;

      @BeforeEach
      public void setup() {
        this.values = new int[] { 2, 1, 2 };
      }

      @Nested
      public class WhenSortedByTheAlgorithm {

        private int[] actual;

        @BeforeEach
        public void setup() {
          this.actual = GivenAlgorithm.this.testUnit
              .sort(GivenUnsortedArrayWithOrderedSequencesAtTail.this.values).getReturnedValue();
        }

        @Test
        public void thenItShouldBeTransformedIntoASortedIntArray() {
          Assertions.assertArrayEquals(new int[] { 1, 2, 2 }, this.actual);
        }
      }
    }

    @Nested
    public class GivenArbitraryUnsortedArray {

      private int[] values;

      @BeforeEach
      public void setup() {
        this.values = new int[] { -1, 0, -1, -2, -2, -3, 4, 5, 4, 6, 7, 0 };
      }

      @Nested
      public class WhenSortedByTheAlgorithm {

        private int[] actual;

        @BeforeEach
        public void setup() {
          this.actual = GivenAlgorithm.this.testUnit.sort(GivenArbitraryUnsortedArray.this.values)
              .getReturnedValue();
        }

        @Test
        public void thenItShouldBeTransformedIntoASortedIntArray() {
          Assertions.assertArrayEquals(
              new int[] { -3, -2, -2, -1, -1, 0, 0, 4, 4, 5, 6, 7 }, this.actual
          );
        }
      }
    }
  }
}