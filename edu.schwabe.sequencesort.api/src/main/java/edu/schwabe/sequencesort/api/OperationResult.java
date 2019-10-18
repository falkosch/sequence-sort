package edu.schwabe.sequencesort.api;

import org.eclipse.jdt.annotation.NonNull;

public class OperationResult<T> {

    private int comparisons = 0;
    private int swaps = 0;

    @SuppressWarnings("null")
    private T returnedValue = null;

    public OperationResult() {
    }

    public OperationResult(final int comparisons, final int swaps, final T returnedValue) {
	this.comparisons = comparisons;
	this.swaps = swaps;
	this.returnedValue = returnedValue;
    }

    public T returnedValue() {
	return this.returnedValue;
    }

    @NonNull
    public OperationResult<T> returnedValue(@NonNull final T newReturnedValue) {
	return new OperationResult<>(this.comparisons, this.swaps, newReturnedValue);
    }

    public int comparisons() {
	return this.comparisons;
    }

    @NonNull
    public OperationResult<T> addComparisons(final int addCount) {
	return new OperationResult<>(this.comparisons + addCount, this.swaps, this.returnedValue);
    }

    public int swaps() {
	return this.swaps;
    }

    @NonNull
    public OperationResult<T> addSwaps(final int addCount) {
	return new OperationResult<>(this.comparisons, this.swaps + addCount, this.returnedValue);
    }

    @NonNull
    public OperationResult<T> add(final @NonNull OperationResult<T> other) {
	return this.add(other.comparisons(), other.swaps(), other.returnedValue());
    }

    @NonNull
    public OperationResult<T> add(final int addComparisons, final int addSwaps, final T newReturnedValue) {
	return new OperationResult<>(this.comparisons + addComparisons, this.swaps + addSwaps, newReturnedValue);
    }
}
