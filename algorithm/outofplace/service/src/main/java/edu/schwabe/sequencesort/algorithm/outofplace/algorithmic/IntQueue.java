package edu.schwabe.sequencesort.algorithm.outofplace.algorithmic;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class IntQueue {

  private static final int[] EMPTY_ARRAY = new int[0];

  private IntQueueItem mTop = null;
  private IntQueueItem mTail = null;
  private int mSize = 0;

  public IntQueue() {
    this(new int[0]);
  }

  public IntQueue(final int item) {
    this(new int[] { item });
  }

  public IntQueue(final int[] items) {
    Arrays.stream(items).forEach(this::queue);
  }

  public boolean empty() {
    return this.mSize == 0;
  }

  public int size() {
    return this.mSize;
  }

  public void queue(final int value) {
    final var newNext = new IntQueueItem(value);
    if (this.mSize == 0) {
      this.mTop = this.mTail = newNext;
    } else {
      this.mTail = this.mTail.next(newNext);
    }
    this.mSize++;
  }

  public int consume(final IntQueue other) {
    final var consumed = other.size();
    IntStream.range(0, consumed).forEach(x -> this.queue(other.dequeue()));
    return consumed;
  }

  public int top() {
    if (this.mSize == 0) {
      return 0;
    }

    return this.mTop.value();
  }

  public int dequeue() {
    if (this.mSize == 0) {
      return 0;
    }

    final var res = this.mTop.value();
    if (this.mSize == 1) {
      this.mTop = this.mTail = null;
    } else {
      this.mTop = this.mTop.next();
    }

    this.mSize--;
    return res;
  }

  public int[] toArray() {
    final var streamOfQueue = Stream.iterate(this.mTop, Objects::nonNull, IntQueueItem::next);
    final var values = streamOfQueue.mapToInt(IntQueueItem::value).toArray();
    if (values != null) {
      return values;
    }
    return IntQueue.EMPTY_ARRAY;
  }

}