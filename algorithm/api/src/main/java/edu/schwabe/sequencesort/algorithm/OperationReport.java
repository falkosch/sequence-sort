package edu.schwabe.sequencesort.algorithm;

public final class OperationReport {

  private final OperationResult<int[]> mOperationResult;

  private final int mTrial;

  private final long mDuration;

  public OperationReport(
    final OperationResult<int[]> operationResult, final int trial, final long duration
  ) {
    this.mOperationResult = operationResult;
    this.mTrial = trial;
    this.mDuration = duration;
  }

  public OperationResult<int[]> operationResult() {
    return this.mOperationResult;
  }

  public int trial() {
    return this.mTrial;
  }

  public long duration() {
    return this.mDuration;
  }

}
