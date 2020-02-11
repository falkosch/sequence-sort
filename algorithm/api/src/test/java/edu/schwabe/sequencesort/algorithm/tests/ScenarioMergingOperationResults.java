package edu.schwabe.sequencesort.algorithm.tests;

import edu.schwabe.sequencesort.algorithm.OperationResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ScenarioMergingOperationResults {

  @Nested
  public class GivenResultValues {

    private static final int COMPARISONS_COUNT = 1;
    private static final int SWAPS_COUNT = 3;

    private int[] returnedValue;

    @BeforeEach
    public void setup() {
      this.returnedValue = new int[] { 0, 1 };
    }

    @Nested
    public class GivenAnEmptyOperationResult {

      private OperationResult<int[]> testUnit;

      @BeforeEach
      public void setup() {
        this.testUnit = new OperationResult<>();
      }

      @Nested
      public class GivenAnotherOperationResultWithValues {

        private OperationResult<int[]> otherTestUnit;

        @BeforeEach
        public void setup() {
          this.otherTestUnit = new OperationResult<>(
              GivenResultValues.COMPARISONS_COUNT, GivenResultValues.SWAPS_COUNT,
              GivenResultValues.this.returnedValue
          );
        }

        @Nested
        public class WhenMergingTheTwoOperationResults {

          private OperationResult<int[]> actual;

          @BeforeEach
          public void setup() {
            this.actual = GivenAnEmptyOperationResult.this.testUnit
                .mergeWith(GivenAnotherOperationResultWithValues.this.otherTestUnit);
          }

          @Test
          public void thenItShouldReturnANewOperationResult() {
            Assertions.assertNotSame(GivenAnEmptyOperationResult.this.testUnit, this.actual);
            Assertions.assertNotSame(
                GivenAnotherOperationResultWithValues.this.otherTestUnit, this.actual
            );
          }

          @Test
          public void thenTheNewOperationResultShouldHaveTheCountOfAddedComparisons() {
            Assertions
                .assertEquals(GivenResultValues.COMPARISONS_COUNT, this.actual.getComparisons());
          }

          @Test
          public void thenTheNewOperationResultShouldHaveTheCountOfAddedSwaps() {
            Assertions.assertEquals(GivenResultValues.SWAPS_COUNT, this.actual.getSwaps());
          }

          @Test
          public void thenTheNewOperationResultShouldHaveTheReturnedValue() {
            Assertions.assertArrayEquals(
                GivenResultValues.this.returnedValue, this.actual.getReturnedValue()
            );
          }
        }
      }
    }
  }
}
