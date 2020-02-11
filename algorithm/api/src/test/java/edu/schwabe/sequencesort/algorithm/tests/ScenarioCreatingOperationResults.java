package edu.schwabe.sequencesort.algorithm.tests;

import edu.schwabe.sequencesort.algorithm.OperationResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ScenarioCreatingOperationResults {

  @Nested
  public class WhenCreatingAnEmptyOperationResult {

    private OperationResult<int[]> testUnit;

    @BeforeEach
    public void setup() {
      this.testUnit = new OperationResult<>();
    }

    @Test
    public void thenItShouldHaveZeroCountOfComparisons() {
      Assertions.assertEquals(0, this.testUnit.getComparisons());
    }

    @Test
    public void thenItShouldHaveZeroCountOfSwaps() {
      Assertions.assertEquals(0, this.testUnit.getSwaps());
    }

    @Test
    public void thenItShouldHaveNoReturnedValue() {
      Assertions.assertNull(this.testUnit.getReturnedValue());
    }
  }

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
    public class WhenCreatingAnOperationResultWithValues {

      private OperationResult<int[]> testUnit;

      @BeforeEach
      public void setup() {
        this.testUnit = new OperationResult<>(
            GivenResultValues.COMPARISONS_COUNT, GivenResultValues.SWAPS_COUNT,
            GivenResultValues.this.returnedValue
        );
      }

      @Test
      public void thenItShouldHaveTheCountOfComparisons() {
        Assertions
            .assertEquals(GivenResultValues.COMPARISONS_COUNT, this.testUnit.getComparisons());
      }

      @Test
      public void thenItShouldHaveTheCountOfSwaps() {
        Assertions.assertEquals(GivenResultValues.SWAPS_COUNT, this.testUnit.getSwaps());
      }

      @Test
      public void thenItShouldHaveTheReturnedValue() {
        Assertions.assertArrayEquals(
            GivenResultValues.this.returnedValue, this.testUnit.getReturnedValue()
        );
      }
    }
  }
}
