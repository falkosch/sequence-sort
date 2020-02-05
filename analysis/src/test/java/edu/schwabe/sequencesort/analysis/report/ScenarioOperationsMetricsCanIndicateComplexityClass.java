package edu.schwabe.sequencesort.analysis.report;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ScenarioOperationsMetricsCanIndicateComplexityClass {

  @Nested
  public class GivenNLnNComplexityClassMetrics {

    private static final long metricValue = 460;
    private static final long itemsCount = 100;

    @Nested
    public class WhenOperationMetricsIsCollected {

      private OperationMetric testUnit;

      @BeforeEach
      public void setup() {
        this.testUnit = new OperationMetric(
            GivenNLnNComplexityClassMetrics.metricValue, GivenNLnNComplexityClassMetrics.itemsCount
        );
      }

      @Test
      public void thenItShouldKeepTheMetricValueAsLongObject() {
        Assertions.assertEquals(
            Long.valueOf(GivenNLnNComplexityClassMetrics.metricValue), this.testUnit.getValueAsBoxedLong()
        );
      }

      @Test
      public void thenItShouldIndicateTheNLnNComplexityClass() {
        Assertions.assertEquals(1.0, this.testUnit.divideValueByNLnN().doubleValue(), 0.05);
      }

      @Test
      public void thenItShouldNotIndicateTheNSqrtNComplexityClass() {
        Assertions.assertNotEquals(1.0, this.testUnit.divideValueByNSqrtN().doubleValue(), 0.05);
      }

      @Test
      public void thenItShouldNotIndicateTheSqrNComplexityClass() {
        Assertions.assertNotEquals(1.0, this.testUnit.divideValueBySqrN().doubleValue(), 0.05);
      }
    }
  }

  @Nested
  public class GivenNSqrtNComplexityClassMetrics {

    private static final long metricValue = 1000;
    private static final long itemsCount = 100;

    @Nested
    public class WhenOperationMetricsIsCollected {

      private OperationMetric testUnit;

      @BeforeEach
      public void setup() {
        this.testUnit = new OperationMetric(
            GivenNSqrtNComplexityClassMetrics.metricValue,
            GivenNSqrtNComplexityClassMetrics.itemsCount
        );
      }

      @Test
      public void thenItShouldKeepTheMetricValueAsLongObject() {
        Assertions
            .assertEquals(Long.valueOf(GivenNSqrtNComplexityClassMetrics.metricValue), this.testUnit.getValueAsBoxedLong());
      }

      @Test
      public void thenItShouldNotIndicateTheNLnNComplexityClass() {
        Assertions.assertNotEquals(1.0, this.testUnit.divideValueByNLnN().doubleValue(), 0.05);
      }

      @Test
      public void thenItShouldIndicateTheNSqrtNComplexityClass() {
        Assertions.assertEquals(1.0, this.testUnit.divideValueByNSqrtN().doubleValue(), 0.05);
      }

      @Test
      public void thenItShouldNotIndicateTheSqrNComplexityClass() {
        Assertions.assertNotEquals(1.0, this.testUnit.divideValueBySqrN().doubleValue(), 0.05);
      }
    }
  }

  @Nested
  public class GivenSqrNComplexityClassMetrics {

    private static final long metricValue = 10000;
    private static final long itemsCount = 100;

    @Nested
    public class WhenOperationMetricsIsCollected {

      private OperationMetric testUnit;

      @BeforeEach
      public void setup() {
        this.testUnit = new OperationMetric(
            GivenSqrNComplexityClassMetrics.metricValue, GivenSqrNComplexityClassMetrics.itemsCount
        );
      }

      @Test
      public void thenItShouldKeepTheMetricValueAsLongObject() {
        Assertions.assertEquals(
            Long.valueOf(GivenSqrNComplexityClassMetrics.metricValue), this.testUnit.getValueAsBoxedLong()
        );
      }

      @Test
      public void thenItShouldNotIndicateTheNLnNComplexityClass() {
        Assertions.assertNotEquals(1.0, this.testUnit.divideValueByNLnN().doubleValue(), 0.05);
      }

      @Test
      public void thenItShouldNotIndicateTheNSqrtNComplexityClass() {
        Assertions.assertNotEquals(1.0, this.testUnit.divideValueByNSqrtN().doubleValue(), 0.05);
      }

      @Test
      public void thenItShouldIndicateTheSqrNComplexityClass() {
        Assertions.assertEquals(1.0, this.testUnit.divideValueBySqrN().doubleValue(), 0.05);
      }
    }
  }
}
