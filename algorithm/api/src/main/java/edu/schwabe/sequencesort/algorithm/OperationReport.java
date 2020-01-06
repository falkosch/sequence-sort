package edu.schwabe.sequencesort.algorithm;

import org.eclipse.jdt.annotation.NonNull;

public final class OperationReport {

  @NonNull
  private final OperationResult<int @NonNull []> operationResult;

  private final int trial;

  private final long duration;

  public OperationReport(
    @NonNull final OperationResult<int @NonNull []> operationResult, final int trial,
    final long duration
  ) {
    this.operationResult = operationResult;
    this.trial = trial;
    this.duration = duration;
  }

  @NonNull
  public OperationResult<int @NonNull []> operationResult() {
    return this.operationResult;
  }

  public int trial() {
    return this.trial;
  }

  public long duration() {
    return this.duration;
  }

}
