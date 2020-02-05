package edu.schwabe.sequencesort.analysis;

import edu.schwabe.sequencesort.algorithm.OperationResult;
import edu.schwabe.sequencesort.algorithm.SortedProperty;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ScenarioSpecialArgumentsThatFulfillSortedProperty {

  @Nested
  public class GivenReflectsMonotonicOrderSortedProperty {

    private SortedProperty testUnit;

    @BeforeEach
    public void setup() {
      this.testUnit = new ReflectsMonotonicOrderSortedProperty();
    }

    @Nested
    public class GivenNull {

      private OperationResult<int[]> toValidate;

      @BeforeEach
      public void setup() {
        this.toValidate = new OperationResult<>(0, 0, null);
      }

      @Nested
      public class WhenValidatedBySortedProperty {

        private boolean actualValidationResult;

        @BeforeEach
        public void setup() {
          this.actualValidationResult = GivenReflectsMonotonicOrderSortedProperty.this.testUnit
              .fulfilledBy(GivenNull.this.toValidate);
        }

        @Test
        public void thenItShouldPass() {
          Assertions.assertTrue(this.actualValidationResult);
        }
      }
    }

    @Nested
    public class GivenEmptyArray {

      private OperationResult<int[]> toValidate;

      @BeforeEach
      public void setup() {
        this.toValidate = new OperationResult<>(0, 0, new int[] {});
      }

      @Nested
      public class WhenValidatedBySortedProperty {

        private boolean actualValidationResult;

        @BeforeEach
        public void setup() {
          this.actualValidationResult = GivenReflectsMonotonicOrderSortedProperty.this.testUnit
              .fulfilledBy(GivenEmptyArray.this.toValidate);
        }

        @Test
        public void thenItShouldPass() {
          Assertions.assertTrue(this.actualValidationResult);
        }
      }
    }

    @Nested
    public class GivenOneValueArray {

      private OperationResult<int[]> toValidate;

      @BeforeEach
      public void setup() {
        this.toValidate = new OperationResult<>(0, 0, new int[] { 1 });
      }

      @Nested
      public class WhenValidatedBySortedProperty {

        private boolean actualValidationResult;

        @BeforeEach
        public void setup() {
          this.actualValidationResult = GivenReflectsMonotonicOrderSortedProperty.this.testUnit
              .fulfilledBy(GivenOneValueArray.this.toValidate);
        }

        @Test
        public void thenItShouldPass() {
          Assertions.assertTrue(this.actualValidationResult);
        }
      }
    }
  }
}
