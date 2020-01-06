package edu.schwabe.sequencesort.algorithm.outofplace.algorithmic;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.eclipse.jdt.annotation.NonNull;

public final class IntQueue {

  private IntQueueItem top = null;
  private IntQueueItem tail = null;
  private int size = 0;

  public IntQueue() {
    this(new int[0]);
  }

  public IntQueue(final int item) {
    this(new int[] { item });
  }

  public IntQueue(final int @NonNull [] items) {
    Arrays.stream(items).forEach(x -> this.queue(x));
  }

  public boolean empty() {
    return this.size == 0;
  }

  public int size() {
    return this.size;
  }

  public void queue(final int value) {
    final var newNext = new IntQueueItem(value);
    if (this.size == 0) {
      this.top = this.tail = newNext;
    } else {
      this.tail = this.tail.next(newNext);
    }
    this.size++;
  }

  public int consume(final IntQueue other) {
    final var consumed = other.size();
    IntStream.range(0, consumed).forEach(x -> this.queue(other.dequeue()));
    return consumed;
  }

  public int top() {
    if (this.size == 0) {
      return 0;
    }

    return this.top.value();
  }

  public int dequeue() {
    if (this.size == 0) {
      return 0;
    }

    final var res = this.top.value();
    if (this.size == 1) {
      this.top = this.tail = null;
    } else {
      this.top = this.top.next();
    }

    this.size--;
    return res;
  }

  public int @NonNull [] toArray() {
    final var streamOfQueue = Stream.iterate(this.top, x -> x != null, x -> x.next());
    final var values = streamOfQueue.mapToInt(x -> x.value()).toArray();
    if (values != null) {
      return values;
    }
    return new int[0];
  }

}