package edu.schwabe.sequencesort.algorithm.tests;

import edu.schwabe.sequencesort.algorithm.OperationResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class GivenAnEmptyOperationResult {

  private OperationResult<int[]> testUnit;

  @BeforeEach
  public void setup() {
    this.testUnit = new OperationResult<>();
  }

  @Nested
  public class WhenAddingSwaps {

    private OperationResult<int[]> actual;

    @BeforeEach
    public void setup() {
      this.actual = GivenAnEmptyOperationResult.this.testUnit.addSwaps(10);
    }

    @Test
    public void thenItShouldReturnANewOperationResult() {
      Assertions.assertNotSame(GivenAnEmptyOperationResult.this.testUnit, this.actual);
    }

    @Test
    public void thenTheNewOperationResultShouldHaveTheCountOfAddedSwaps() {
      Assertions.assertEquals(10, this.actual.getSwaps());
    }
  }
}
