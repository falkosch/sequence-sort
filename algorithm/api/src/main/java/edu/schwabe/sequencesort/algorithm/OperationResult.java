package edu.schwabe.sequencesort.algorithm;

/**
 * Contains the results and metrics of sorting an array of numbers.
 *
 * @param <T> array type of numbers, e.g. <code>int[]</code>
 */
public final class OperationResult<T> {

  private long comparisons = 0;
  private long swaps = 0;

  private T returnedValue = null;

  /**
   * Creates an {@link OperationResult} with default values.
   */
  public OperationResult() {
  }

  /**
   * Creates an {@link OperationResult} with the given values.
   *
   * @param comparisons   number of comparisons required to sort an array
   * @param swaps         number of swaps required to sort an array
   * @param returnedValue the sorted array
   */
  public OperationResult(final long comparisons, final long swaps, final T returnedValue) {
    this.comparisons = comparisons;
    this.swaps = swaps;
    this.returnedValue = returnedValue;
  }

  /**
   * Returns the number of comparisons required to sort an array.
   *
   * @return number of comparisons
   */
  public long getComparisons() {
    return this.comparisons;
  }

  /**
   * Returns the number of swaps required to sort an array.
   *
   * @return number of swaps
   */
  public long getSwaps() {
    return this.swaps;
  }

  /**
   * Returns the result of sorting an array.
   *
   * @return the sorted array
   */
  public T getReturnedValue() {
    return this.returnedValue;
  }

  /**
   * Replaces the returned value and returns that as a new
   * {@link OperationResult}. Does not mutate this object.
   *
   * @param newReturnedValue the returned value to set
   * @return the new {@link OperationResult}
   */
  public OperationResult<T> replaceReturnedValue(final T newReturnedValue) {
    return new OperationResult<>(this.getComparisons(), this.getSwaps(), newReturnedValue);
  }

  /**
   * Adds a number of comparisons and returns that as a new
   * {@link OperationResult}. Does not mutate this object.
   *
   * @param value the number to add
   * @return the new {@link OperationResult}
   */
  public OperationResult<T> addComparisons(final long value) {
    return this.addValues(value, 0, this.getReturnedValue());
  }

  /**
   * Adds a number of swaps and returns that as a new {@link OperationResult}.
   * Does not mutate this object.
   *
   * @param value the number to add
   * @return the new {@link OperationResult}
   */
  public OperationResult<T> addSwaps(final long value) {
    return this.addValues(0, value, this.getReturnedValue());
  }

  /**
   * Merges this and another given {@link OperationResult} into a new one.
   *
   * @param other another {@link OperationResult}
   * @return the merged {@link OperationResult} having the sorted array
   *         {@link #returnedValue} set at the other object.
   */
  public OperationResult<T> mergeWith(final OperationResult<T> other) {
    return this.addValues(other.getComparisons(), other.getSwaps(), other.getReturnedValue());
  }

  /**
   * Adds number of comparisons and swaps, replaces the returned value, and
   * returns that as a new {@link OperationResult}. Does not mutate this object.
   *
   * @param comparisonsToAdd the number of comparisons to add
   * @param swapsToAdd       the number of swaps to add
   * @param newReturnedValue the returned value to replace
   * @return the new {@link OperationResult}
   */
  public OperationResult<T> addValues(
      final long comparisonsToAdd, final long swapsToAdd, final T newReturnedValue
  ) {
    return new OperationResult<>(
        this.getComparisons() + comparisonsToAdd, this.getSwaps() + swapsToAdd, newReturnedValue
    );
  }
}
