package edu.schwabe.sequencesort.algorithm.outofplace.algorithmic;

public final class IntQueueItem {

  private final int mValue;

  private IntQueueItem mNext;

  public IntQueueItem(final int value) {
    this(value, null);
  }

  public IntQueueItem(final int value, final IntQueueItem next) {
    this.mValue = value;
    this.mNext = next;
  }

  public int value() {
    return this.mValue;
  }

  public IntQueueItem next() {
    return this.mNext;
  }

  public IntQueueItem next(final IntQueueItem newNext) {
    this.mNext = newNext;
    return this.mNext;
  }
}