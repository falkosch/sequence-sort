package edu.schwabe.sequencesort.demonstrator;

/**
 * Parses the trial argument from {@code String[]} arrays or {@link String}
 * values.
 */
public final class TrialArgumentParser {

  public static final int MINIMUM_TRIAL_COUNT = 1;
  public static final int MAXIMUM_TRIAL_COUNT = 7;
  public static final int DEFAULT_TRIAL_COUNT = 6;

  /**
   * Parses the given {@code arguments} for a trial argument and returns its
   * corresponding {@code int} value. If trial argument is not present, cannot be
   * parsed or is out of range, then a default value will be returned instead. The
   * returned value is always in range
   * {@code [MINIMUM_TRIAL_COUNT, MAXIMUM_TRIAL_COUNT]}
   *
   * @param arguments can contain the trial argument
   * @return the parsed value for the trial argument or the default value
   */
  public static int parseTrialArgument(final String[] arguments) {
    if (TrialArgumentParser.isEmpty(arguments)) {
      return TrialArgumentParser.DEFAULT_TRIAL_COUNT;
    }

    return TrialArgumentParser.parseTrialArgument(arguments[0]);
  }

  /**
   * Parses the given {@code trialArgument} and returns its corresponding
   * {@code int} value. If the argument is <code>null</code>, cannot be parsed or
   * is out of range, then a default value will be returned instead. The returned
   * value is always in range {@code [MINIMUM_TRIAL_COUNT, MAXIMUM_TRIAL_COUNT]}
   *
   * @param trialArgument string value of the trial argument
   * @return the parsed value for the trial argument or the default value
   */
  public static int parseTrialArgument(final String trialArgument) {
    int trialCount =
        TrialArgumentParser.tryParse(trialArgument, TrialArgumentParser.DEFAULT_TRIAL_COUNT);

    trialCount = Math.max(
        TrialArgumentParser.MINIMUM_TRIAL_COUNT,
        Math.min(TrialArgumentParser.MAXIMUM_TRIAL_COUNT, trialCount)
    );

    return trialCount;
  }

  /**
   * Indicates whether the given {@code String[]} value is <code>null</code> or an
   * empty array.
   *
   * @param args the value to check
   * @return <code>true</code> if the value is <code>null</code> or an empty
   *         array, otherwise <code>false</code>
   */
  public static boolean isEmpty(final String[] args) {
    return args == null || args.length == 0;
  }

  /**
   * Tries parsing the given {@code argument} as an {@code int} and returns the
   * parsed value. If it cannot be parsed, it returns the given
   * {@code defaultValue} instead.
   *
   * @param argument     the number to be parsed
   * @param defaultValue alternative return
   * @return parsed value or default value (if {@code argument} cannot be parsed)
   */
  public static int tryParse(final String argument, final int defaultValue) {
    try {
      return Integer.parseInt(argument);
    } catch (@SuppressWarnings("unused") final NumberFormatException e) {
      return defaultValue;
    }
  }
}
