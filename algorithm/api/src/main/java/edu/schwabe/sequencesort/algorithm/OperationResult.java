package edu.schwabe.sequencesort.algorithm;

import org.eclipse.jdt.annotation.NonNull;

public final class OperationResult<T> {

  private long _comparisons = 0;
  private long _swaps = 0;

  @SuppressWarnings("null")
  private T _returnedValue = null;

  public OperationResult() {
  }

  public OperationResult(final long comparisons, final long swaps, final T returnedValue) {
    this._comparisons = comparisons;
    this._swaps = swaps;
    this._returnedValue = returnedValue;
  }

  public long comparisons() {
    return this._comparisons;
  }

  public long swaps() {
    return this._swaps;
  }

  public T returnedValue() {
    return this._returnedValue;
  }

  @NonNull
  public OperationResult<T> returnedValue(@NonNull final T newReturnedValue) {
    return new OperationResult<>(this.comparisons(), this.swaps(), newReturnedValue);
  }

  @NonNull
  public OperationResult<T> addComparisons(final long addCount) {
    return this.add(addCount, 0, this.returnedValue());
  }

  @NonNull
  public OperationResult<T> addSwaps(final long addCount) {
    return this.add(0, addCount, this.returnedValue());
  }

  @NonNull
  public OperationResult<T> add(final @NonNull OperationResult<T> other) {
    return this.add(other.comparisons(), other.swaps(), other.returnedValue());
  }

  @NonNull
  public OperationResult<T> add(
    final long addComparisons, final long addSwaps, final T newReturnedValue
  ) {
    return new OperationResult<>(
      this.comparisons() + addComparisons, this.swaps() + addSwaps, newReturnedValue
    );
  }
}
