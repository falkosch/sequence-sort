package edu.schwabe.sequencesort.analysis;

import edu.schwabe.sequencesort.algorithm.Algorithm;
import edu.schwabe.sequencesort.algorithm.OperationReport;
import edu.schwabe.sequencesort.algorithm.OperationResult;
import edu.schwabe.sequencesort.algorithm.Reporter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ScenarioTextReporterDisplaysResults {

  @Nested
  public class GivenTextReporter {

    private Reporter testUnit;

    @BeforeEach
    public void setup() {
      this.testUnit = new TextReporter();
    }

    @Nested
    public class GivenAlgorithmClass {

      private final Class<? extends Algorithm> algorithmClass = Algorithm.class;

      @Nested
      public class GivenOperationReport {

        private final OperationReport operationReport =
            new OperationReport(new OperationResult<>(1, 1, new int[] { 0 }), 2, 100);

        @Nested
        public class WhenOperationReportShouldBeDisplayed {

          private PrintStream oldOut;

          @BeforeEach
          public void setup() {
            this.oldOut = System.out;
          }

          @AfterEach
          public void tearDown() {
            System.setOut(this.oldOut);
          }

          @Test
          public void thenItShouldRenderToSystemOut() throws IOException {
            final var counter = new Object() {
              public int value = 0;
            };

            final class CountingStream extends OutputStream {

              @Override
              public void write(final int b) {
                counter.value += b;
              }
            }

            try (var out = new CountingStream(); var printStream = new PrintStream(out, true);) {
              System.setOut(printStream);

              GivenTextReporter.this.testUnit.display(
                  GivenAlgorithmClass.this.algorithmClass,
                  Stream.of(GivenOperationReport.this.operationReport)
              );

              printStream.flush();

              Assertions.assertTrue(counter.value > 0);
            }
          }
        }
      }
    }
  }
}
