package edu.schwabe.sequencesort.analysis;

import edu.schwabe.sequencesort.algorithm.OperationResult;
import edu.schwabe.sequencesort.algorithm.SortedProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ScenarioNotSortedArraysDoNotFulfillSortedProperty {

  @Nested
  public class GivenNotSortedArray {

    private OperationResult<int[]> toValidate;

    @BeforeEach
    public void setup() {
      this.toValidate = new OperationResult<>(0, 0, new int[] { 0, -1, 1 });
    }

    @Nested
    public class GivenReflectsMonotonicOrderSortedProperty {

      private SortedProperty testUnit;

      @BeforeEach
      public void setup() {
        this.testUnit = new ReflectsMonotonicOrderSortedProperty();
      }

      @Nested
      public class WhenValidatedBySortedProperty {

        private boolean actualValidationResult;

        @BeforeEach
        public void setup() {
          this.actualValidationResult = GivenReflectsMonotonicOrderSortedProperty.this.testUnit
              .fulfilledBy(GivenNotSortedArray.this.toValidate);
        }

        @Test
        public void thenItShouldFail() {
          Assertions.assertFalse(this.actualValidationResult);
        }
      }
    }
  }

}
