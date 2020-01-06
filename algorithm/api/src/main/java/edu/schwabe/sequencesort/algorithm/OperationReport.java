package edu.schwabe.sequencesort.algorithm;

import org.eclipse.jdt.annotation.NonNull;

public final class OperationReport {

  @NonNull
  private final OperationResult<int @NonNull []> mOperationResult;

  private final int mTrial;

  private final long mDuration;

  public OperationReport(
    @NonNull final OperationResult<int @NonNull []> operationResult, final int trial,
    final long duration
  ) {
    this.mOperationResult = operationResult;
    this.mTrial = trial;
    this.mDuration = duration;
  }

  @NonNull
  public OperationResult<int @NonNull []> operationResult() {
    return this.mOperationResult;
  }

  public int trial() {
    return this.mTrial;
  }

  public long duration() {
    return this.mDuration;
  }

}
