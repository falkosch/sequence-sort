package edu.schwabe.sequencesort.algorithm;

/**
 * Collects data of a sort trial run.
 */
public final class OperationReport {

  private final OperationResult<int[]> operationResult;

  private final int trial;

  private final long duration;

  /**
   * Creates an {@link OperationReport}.
   *
   * @param operationResult metrics of the trial returned by the {@link Algorithm}
   * @param trial           identifies the trial
   * @param duration        benchmark time of the trial in ns
   */
  public OperationReport(
      final OperationResult<int[]> operationResult, final int trial, final long duration
  ) {
    this.operationResult = operationResult;
    this.trial = trial;
    this.duration = duration;
  }

  /**
   * Returns the collected metrics of the trial returned by the {@link Algorithm}.
   *
   * @return the metrics
   */
  public OperationResult<int[]> getOperationResult() {
    return this.operationResult;
  }

  public int getTrial() {
    return this.trial;
  }

  public long getDuration() {
    return this.duration;
  }

}
