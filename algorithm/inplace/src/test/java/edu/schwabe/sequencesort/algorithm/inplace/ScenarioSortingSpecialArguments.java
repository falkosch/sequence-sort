package edu.schwabe.sequencesort.algorithm.inplace;

import edu.schwabe.sequencesort.algorithm.Algorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ScenarioSortingSpecialArguments {

  @Nested
  public class GivenAlgorithmInstance {

    private Algorithm testUnit;

    @BeforeEach
    public void setup() {
      this.testUnit = new AlgorithmImpl();
    }

    @Nested
    public class GivenNoArguments {

      @Nested
      public class WhenSortedByTheAlgorithm {

        private int[] actual;

        @BeforeEach
        public void setup() {
          this.actual = GivenAlgorithmInstance.this.testUnit.sort().getReturnedValue();
        }

        @Test
        public void thenItShouldReturnEmptyArray() {
          Assertions.assertArrayEquals(new int[] {}, this.actual);
        }
      }
    }

    @Nested
    public class GivenEmptyArray {

      private int[] values;

      @BeforeEach
      public void setup() {
        this.values = new int[] {};
      }

      @Nested
      public class WhenSortedByTheAlgorithm {

        private int[] actual;

        @BeforeEach
        public void setup() {
          this.actual = GivenAlgorithmInstance.this.testUnit.sort(GivenEmptyArray.this.values)
              .getReturnedValue();
        }

        @Test
        public void thenItShouldRemainEmpty() {
          Assertions.assertArrayEquals(GivenEmptyArray.this.values, this.actual);
        }
      }
    }

    @Nested
    public class GivenArrayWithOnlyOneValue {

      private int[] values;

      @BeforeEach
      public void setup() {
        this.values = new int[] { 1 };
      }

      @Nested
      public class WhenSortedByTheAlgorithm {

        private int[] actual;

        @BeforeEach
        public void setup() {
          this.actual = GivenAlgorithmInstance.this.testUnit
              .sort(GivenArrayWithOnlyOneValue.this.values).getReturnedValue();
        }

        @Test
        public void thenItShouldRemainArrayWithThatOneValue() {
          Assertions.assertArrayEquals(GivenArrayWithOnlyOneValue.this.values, this.actual);
        }
      }
    }
  }
}