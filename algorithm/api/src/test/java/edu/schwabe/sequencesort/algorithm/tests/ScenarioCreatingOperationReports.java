package edu.schwabe.sequencesort.algorithm.tests;

import edu.schwabe.sequencesort.algorithm.OperationReport;
import edu.schwabe.sequencesort.algorithm.OperationResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ScenarioCreatingOperationReports {

  @Nested
  public class GivenOperationReportData {

    private static final int TRIAL = 3;
    private static final long DURATION = 5;
    private OperationResult<int[]> operationResult;

    @BeforeEach
    public void setup() {
      this.operationResult = new OperationResult<>();
    }

    @Nested
    public class WhenCreatingAnOperationReport {

      @Test
      public void thenItShouldNotThrow() {
        Assertions.assertDoesNotThrow(() -> {
          return new OperationReport(
              GivenOperationReportData.this.operationResult, GivenOperationReportData.TRIAL,
              GivenOperationReportData.DURATION
          );
        });
      }
    }

    @Nested
    public class GivenAnOperationReport {

      private OperationReport testUnit;

      @BeforeEach
      public void setup() {
        this.testUnit = new OperationReport(
            GivenOperationReportData.this.operationResult, GivenOperationReportData.TRIAL,
            GivenOperationReportData.DURATION
        );
      }

      @Nested
      public class WhenGettingTheOperationResult {

        @Test
        public void thenItShouldReturnTheOperationResultWhichTheReportWasCreatedWith() {
          Assertions.assertSame(
              GivenOperationReportData.this.operationResult,
              GivenAnOperationReport.this.testUnit.getOperationResult()
          );
        }
      }

      @Nested
      public class WhenGettingTheTrialNumber {

        @Test
        public void thenItShouldReturnTheTrialNumberWhichTheReportWasCreatedWith() {
          Assertions.assertEquals(
              GivenOperationReportData.TRIAL, GivenAnOperationReport.this.testUnit.getTrial()
          );
        }
      }

      @Nested
      public class WhenGettingTheDuration {

        @Test
        public void thenItShouldReturnTheDurationWhichTheReportWasCreatedWith() {
          Assertions.assertEquals(
              GivenOperationReportData.DURATION, GivenAnOperationReport.this.testUnit.getDuration()
          );
        }
      }
    }
  }
}
