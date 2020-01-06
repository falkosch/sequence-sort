package edu.schwabe.sequencesort.algorithm.outofplace.algorithmic;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public final class IntQueueItem {

    private final int value;

    @Nullable
    private IntQueueItem next;

    public IntQueueItem(final int value) {
        this(value, null);
    }

    public IntQueueItem(final int value, @Nullable final IntQueueItem next) {
        this.value = value;
        this.next = next;
    }

    public int value() {
        return this.value;
    }

    @Nullable
    public IntQueueItem next() {
        return this.next;
    }

    @NonNull
    public IntQueueItem next(final @NonNull IntQueueItem newNext) {
        return this.next = newNext;
    }
}