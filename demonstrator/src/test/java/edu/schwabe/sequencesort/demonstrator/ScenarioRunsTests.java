package edu.schwabe.sequencesort.demonstrator;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ScenarioRunsTests {

  private PrintStream oldOut;

  @BeforeEach
  public void setup() {
    this.oldOut = System.out;
  }

  @AfterEach
  public void tearDown() {
    System.setOut(this.oldOut);
  }

  @Nested
  public class GivenTrialArgument {

    private String[] trialArgument;

    @BeforeEach
    public void setup() {
      this.trialArgument = new String[] { "1" };
    }

    @Nested
    public class WhenRunningBootstrapper {

      @Test
      public void thenItShouldNotFail() throws IOException {
        class VoidOutputStream extends OutputStream {

          @Override
          public void write(final int b) throws IOException {
            // NOOP
          }
        }

        try (var out = new VoidOutputStream(); var printStream = new PrintStream(out, true);) {
          System.setOut(printStream);

          Assertions.assertDoesNotThrow(() -> {
            Bootstrapper.main(GivenTrialArgument.this.trialArgument);
          });
        }
      }
    }
  }
}
