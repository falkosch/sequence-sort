package edu.schwabe.sequencesort.algorithm;

import org.eclipse.jdt.annotation.NonNull;

public final class OperationResult<T> {

    private long comparisons = 0;
    private long swaps = 0;

    @SuppressWarnings("null")
    private T returnedValue = null;

    public OperationResult() {
    }

    public OperationResult(final long comparisons, final long swaps, final T returnedValue) {
        this.comparisons = comparisons;
        this.swaps = swaps;
        this.returnedValue = returnedValue;
    }

    public long comparisons() {
        return this.comparisons;
    }

    public long swaps() {
        return this.swaps;
    }

    public T returnedValue() {
        return this.returnedValue;
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
