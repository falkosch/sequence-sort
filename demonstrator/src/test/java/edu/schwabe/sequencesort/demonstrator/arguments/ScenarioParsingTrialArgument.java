package edu.schwabe.sequencesort.demonstrator.arguments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class ScenarioParsingTrialArgument {

  @Nested
  public class GivenTrialInRange {

    private static final int TRIAL_IN_RANGE = 2;

    @Nested
    public class GivenTrialArgumentInRange {

      private String trialArgumentInRange;

      @BeforeEach
      public void setup() {
        this.trialArgumentInRange = String.valueOf(GivenTrialInRange.TRIAL_IN_RANGE);
      }

      @Nested
      public class WhenParsingTrialArgumentInRange {

        @Test
        public void thenTheTrialInRangeValueIsReturned() {
          Assertions.assertEquals(
              GivenTrialInRange.TRIAL_IN_RANGE,
              TrialArgumentParser
                  .parseTrialArgument(GivenTrialArgumentInRange.this.trialArgumentInRange)
          );
        }
      }

      @Nested
      public class GivenArgumentsContainingTrialInRange {

        private String[] argumentsContainingTrialInRange;

        @BeforeEach
        public void setup() {
          this.argumentsContainingTrialInRange =
              new String[] { GivenTrialArgumentInRange.this.trialArgumentInRange };
        }

        @Nested
        public class WhenParsingArgumentsContainingTrialInRange {

          @Test
          public void thenTheTrialInRangeValueIsReturned() {
            Assertions.assertEquals(
                GivenTrialInRange.TRIAL_IN_RANGE,
                TrialArgumentParser.parseTrialArgument(
                    GivenArgumentsContainingTrialInRange.this.argumentsContainingTrialInRange
                )
            );
          }
        }
      }
    }
  }

  @Nested
  public class GivenTrialBelowMinimum {

    private static final int TRIAL_BELOW_MINIMUM = -1;

    @Nested
    public class GivenTrialArgumentBelowMinimum {

      private String trialArgumentBelowMinimum;

      @BeforeEach
      public void setup() {
        this.trialArgumentBelowMinimum = String.valueOf(GivenTrialBelowMinimum.TRIAL_BELOW_MINIMUM);
      }

      @Nested
      public class WhenParsingTrialArgumentBelowMinimum {

        @Test
        public void thenTheMinimumValueIsReturned() {
          Assertions.assertEquals(
              TrialArgumentParser.MINIMUM_TRIAL_COUNT,
              TrialArgumentParser
                  .parseTrialArgument(GivenTrialArgumentBelowMinimum.this.trialArgumentBelowMinimum)
          );
        }
      }

      @Nested
      public class GivenArgumentsContainingTrialBelowMinimum {

        private String[] arguments;

        @BeforeEach
        public void setup() {
          this.arguments =
              new String[] { GivenTrialArgumentBelowMinimum.this.trialArgumentBelowMinimum };
        }

        @Nested
        public class WhenParsingArgumentsContainingTrialBelowMinimum {

          @Test
          public void thenTheMinimumValueIsReturned() {
            Assertions.assertEquals(
                TrialArgumentParser.MINIMUM_TRIAL_COUNT,
                TrialArgumentParser
                    .parseTrialArgument(GivenArgumentsContainingTrialBelowMinimum.this.arguments)
            );
          }
        }
      }
    }
  }

  @Nested
  public class GivenInvalidTrialArgument {

    private static final String INVALID_TRIAL_ARGUMENT = "invalid";

    @Nested
    public class WhenParsingInvalidTrialArgument {

      @Test
      public void thenTheDefaultValueIsReturned() {
        Assertions.assertEquals(
            TrialArgumentParser.DEFAULT_TRIAL_COUNT,
            TrialArgumentParser.parseTrialArgument(GivenInvalidTrialArgument.INVALID_TRIAL_ARGUMENT)
        );
      }
    }
  }

  @Nested
  public class GivenNullArguments {

    private String[] nullArguments;

    @BeforeEach
    public void setup() {
      this.nullArguments = null;
    }

    @Nested
    public class WhenParsingNullArguments {

      @Test
      public void thenTheDefaultValueIsReturned() {
        Assertions.assertEquals(
            TrialArgumentParser.DEFAULT_TRIAL_COUNT,
            TrialArgumentParser.parseTrialArgument(GivenNullArguments.this.nullArguments)
        );
      }
    }
  }

  @Nested
  public class GivenEmptyArguments {

    private String[] emptyArguments;

    @BeforeEach
    public void setup() {
      this.emptyArguments = new String[] {};
    }

    @Nested
    public class WhenParsingEmptyArguments {

      @Test
      public void thenTheDefaultValueIsReturned() {
        Assertions.assertEquals(
            TrialArgumentParser.DEFAULT_TRIAL_COUNT,
            TrialArgumentParser.parseTrialArgument(GivenEmptyArguments.this.emptyArguments)
        );
      }
    }
  }
}