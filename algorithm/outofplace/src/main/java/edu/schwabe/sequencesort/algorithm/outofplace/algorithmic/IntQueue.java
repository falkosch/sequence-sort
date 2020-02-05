package edu.schwabe.sequencesort.algorithm.outofplace.algorithmic;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Organizes the remaining unsorted part of an array of numbers as a linked list
 * FIFO-like queue of numbers.
 */
public final class IntQueue {

  private static final int[] EMPTY_ARRAY = {};

  private IntQueueItem top = null;
  private IntQueueItem tail = null;
  private int size = 0;

  /**
   * Creates an {@link IntQueue} from a given array of numbers.
   *
   * @param items the numbers
   */
  public IntQueue(final int... items) {
    Arrays.stream(items).forEach(this::queue);
  }

  /**
   * Indicates whether the queue is empty or not.
   *
   * @return <code>true</code> if there is no element in the queue yet, otherwise
   *         <code>false</code>
   */
  public boolean isEmpty() {
    return this.size == 0;
  }

  /**
   * Returns the count of numbers in the queue.
   *
   * @return the count
   */
  public int getSize() {
    return this.size;
  }

  /**
   * Adds a number to the queue.
   *
   * @param value the number
   */
  public void queue(final int value) {
    final var newNext = new IntQueueItem(value);
    if (this.size == 0) {
      this.top = this.tail = newNext;
    } else {
      this.tail = this.tail.replaceNext(newNext);
    }
    this.size++;
  }

  /**
   * Consumes another queue and adds all numbers to this queue.
   *
   * @param other the other queue to consume
   * @return the count of consumed numbers
   */
  public int consume(final IntQueue other) {
    final var consumed = other.getSize();
    IntStream.range(0, consumed).forEach(x -> this.queue(other.dequeue()));
    return consumed;
  }

  /**
   * Returns the top element of the queue. Does not mutate the queue.
   *
   * @return the top element of the queue if the queue is not empty, otherwise
   *         {@code 0}
   */
  public int getTop() {
    if (this.size == 0) {
      return 0;
    }

    return this.top.getValue();
  }

  /**
   * Removes the top element of the queue and returns it. Mutates the queue if the
   * queue is not empty.
   *
   * @return the top element of the queue if the queue is not empty, otherwise
   *         {@code 0}
   */
  public int dequeue() {
    if (this.size == 0) {
      return 0;
    }

    final var res = this.top.getValue();
    if (this.size == 1) {
      this.top = this.tail = null;
    } else {
      this.top = this.top.getNext();
    }

    this.size--;
    return res;
  }

  /**
   * Returns all contained numbers as an array.
   *
   * @return the array representation of the queue
   */
  public int[] toArray() {
    final var streamOfQueue = Stream.iterate(this.top, Objects::nonNull, IntQueueItem::getNext);
    final var values = streamOfQueue.mapToInt(IntQueueItem::getValue).toArray();
    if (values != null) {
      return values;
    }
    return IntQueue.EMPTY_ARRAY;
  }

}