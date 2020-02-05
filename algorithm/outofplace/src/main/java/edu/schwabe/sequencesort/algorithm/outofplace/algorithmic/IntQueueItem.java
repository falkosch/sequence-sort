package edu.schwabe.sequencesort.algorithm.outofplace.algorithmic;

/**
 * Contains a number and has a reference to another {@link IntQueueItem}.
 */
public final class IntQueueItem {

  private final int value;

  private IntQueueItem next;

  /**
   * Creates a {@link IntQueueItem} for a given number.
   *
   * @param value the number
   */
  public IntQueueItem(final int value) {
    this(value, null);
  }

  /**
   * Creates a {@link IntQueueItem} for a given number and a reference to the next
   * {@link IntQueueItem}.
   *
   * @param value the number
   * @param next  the next {@link IntQueueItem}
   */
  public IntQueueItem(final int value, final IntQueueItem next) {
    this.value = value;
    this.next = next;
  }

  /**
   * Returns the number contained by this {@link IntQueueItem}.
   *
   * @return the number
   */
  public int getValue() {
    return this.value;
  }

  /**
   * Returns the next {@link IntQueueItem}.
   *
   * @return the next {@link IntQueueItem} if this {@link IntQueueItem} is not the
   *         tail part of the queue, otherwise <code>null</code>
   */
  public IntQueueItem getNext() {
    return this.next;
  }

  /**
   * Replaces the reference to the next {@link IntQueueItem} by a reference to
   * another {@link IntQueueItem}.
   *
   * @param newNext the other {@link IntQueueItem}
   * @return the other {@link IntQueueItem}
   */
  public IntQueueItem replaceNext(final IntQueueItem newNext) {
    this.next = newNext;
    return this.next;
  }
}