package edu.schwabe.sequencesort.algorithm;

public final class OperationResult<T> {

  private long mComparisons = 0;
  private long mSwaps = 0;

  private T mReturnedValue = null;

  public OperationResult() {
  }

  public OperationResult(final long comparisons, final long swaps, final T returnedValue) {
    this.mComparisons = comparisons;
    this.mSwaps = swaps;
    this.mReturnedValue = returnedValue;
  }

  public long comparisons() {
    return this.mComparisons;
  }

  public long swaps() {
    return this.mSwaps;
  }

  public T returnedValue() {
    return this.mReturnedValue;
  }

  public OperationResult<T> returnedValue(final T newReturnedValue) {
    return new OperationResult<>(this.comparisons(), this.swaps(), newReturnedValue);
  }

  public OperationResult<T> addComparisons(final long addCount) {
    return this.add(addCount, 0, this.returnedValue());
  }

  public OperationResult<T> addSwaps(final long addCount) {
    return this.add(0, addCount, this.returnedValue());
  }

  public OperationResult<T> add(final OperationResult<T> other) {
    return this.add(other.comparisons(), other.swaps(), other.returnedValue());
  }

  public OperationResult<T> add(
    final long addComparisons, final long addSwaps, final T newReturnedValue
  ) {
    return new OperationResult<>(
      this.comparisons() + addComparisons, this.swaps() + addSwaps, newReturnedValue
    );
  }
}
