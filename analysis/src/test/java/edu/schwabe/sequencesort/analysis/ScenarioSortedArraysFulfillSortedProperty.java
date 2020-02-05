package edu.schwabe.sequencesort.analysis;

import edu.schwabe.sequencesort.algorithm.OperationResult;
import edu.schwabe.sequencesort.algorithm.SortedProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ScenarioSortedArraysFulfillSortedProperty {

  @Nested
  public class GivenSortedArray {

    private OperationResult<int[]> toValidate;

    @BeforeEach
    public void setup() {
      this.toValidate = new OperationResult<>(0, 0, new int[] { -1, 0, 1 });
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
              .fulfilledBy(GivenSortedArray.this.toValidate);
        }

        @Test
        public void thenItShouldPass() {
          Assertions.assertTrue(this.actualValidationResult);
        }
      }
    }
  }

}
