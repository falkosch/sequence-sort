package edu.schwabe.sequencesort.algorithm;

import org.eclipse.jdt.annotation.NonNull;

public final class OperationReport {

  @NonNull
  private final OperationResult<int @NonNull []> _operationResult;

  private final int _trial;

  private final long _duration;

  public OperationReport(
    @NonNull final OperationResult<int @NonNull []> operationResult, final int trial,
    final long duration
  ) {
    this._operationResult = operationResult;
    this._trial = trial;
    this._duration = duration;
  }

  @NonNull
  public OperationResult<int @NonNull []> operationResult() {
    return this._operationResult;
  }

  public int trial() {
    return this._trial;
  }

  public long duration() {
    return this._duration;
  }

}
