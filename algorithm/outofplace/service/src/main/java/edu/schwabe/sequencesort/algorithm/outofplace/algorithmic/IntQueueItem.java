package edu.schwabe.sequencesort.algorithm.outofplace.algorithmic;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public final class IntQueueItem {

  private final int mValue;

  @Nullable
  private IntQueueItem mNext;

  public IntQueueItem(final int value) {
    this(value, null);
  }

  public IntQueueItem(final int value, @Nullable final IntQueueItem next) {
    this.mValue = value;
    this.mNext = next;
  }

  public int value() {
    return this.mValue;
  }

  @Nullable
  public IntQueueItem next() {
    return this.mNext;
  }

  @NonNull
  public IntQueueItem next(final @NonNull IntQueueItem newNext) {
    return this.mNext = newNext;
  }
}