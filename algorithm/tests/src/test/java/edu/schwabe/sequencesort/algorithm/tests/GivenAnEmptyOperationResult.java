package edu.schwabe.sequencesort.algorithm.tests;

import edu.schwabe.sequencesort.algorithm.OperationResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GivenAnEmptyOperationResult {

  private OperationResult<int[]> testUnit;

  @BeforeEach
  void setup() {
    this.testUnit = new OperationResult<>();
  }

  @Nested
  class WhenAddingSwaps {

    private OperationResult<int[]> actual;

    @BeforeEach
    void setup() {
      this.actual = GivenAnEmptyOperationResult.this.testUnit.addSwaps(10);
    }

    @Test
    void itShouldReturnANewOperationResult() {
      Assertions.assertNotSame(GivenAnEmptyOperationResult.this.testUnit, this.actual);
    }

    @Test
    void theNewOperationResultShouldHaveTheCountOfAddedSwaps() {
      Assertions.assertEquals(10, this.actual.swaps());
    }
  }
}
