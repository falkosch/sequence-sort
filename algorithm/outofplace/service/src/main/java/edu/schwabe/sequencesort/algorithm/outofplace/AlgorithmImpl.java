package edu.schwabe.sequencesort.algorithm.outofplace;

import edu.schwabe.sequencesort.algorithm.Algorithm;
import edu.schwabe.sequencesort.algorithm.OperationResult;
import edu.schwabe.sequencesort.algorithm.outofplace.algorithmic.IntQueue;

public final class AlgorithmImpl implements Algorithm {

  private static final int[] EMPTY_ARRAY = new int[0];

  @Override
  public OperationResult<int[]> sort(final int[] items) {
    final var operationResult = AlgorithmImpl.sortRecursive(new IntQueue(items));
    final var comparisons = operationResult.comparisons();
    final var swaps = operationResult.swaps();
    final var sortedIntQueue = operationResult.returnedValue();
    final var sortedItems = AlgorithmImpl.asArray(sortedIntQueue);
    return new OperationResult<>(comparisons, swaps, sortedItems);
  }

  private static int[] asArray(final IntQueue sortedItems) {
    if (sortedItems == null) {
      return AlgorithmImpl.EMPTY_ARRAY;
    }
    return sortedItems.toArray();
  }

  private static OperationResult<IntQueue> sortRecursive(final IntQueue items) {
    if (items.empty() || items.size() == 1) {
      return new OperationResult<>(0, 0, items);
    }

    /*
     * Split "items" in "sortedSequence" and "outOfOrder" so that
     * "#(items) >= #(sortedSequence) >= 1",
     * "all items in sortedSequence are ordered", and
     * "#(items) > #(outOfOrder) >= 0".
     */
    final IntQueue sortedSequence = new IntQueue();
    final IntQueue outOfOrder = new IntQueue();

    int pivot = items.dequeue();
    final var comparisonsAndSwaps = items.size();

    sortedSequence.queue(pivot);
    while (!items.empty()) {
      final int nextItem = items.dequeue();
      if (pivot <= nextItem) {
        pivot = nextItem;
        sortedSequence.queue(nextItem);
      } else {
        outOfOrder.queue(nextItem);
      }
    }

    final var outOfOrderOperationResult = AlgorithmImpl.sortRecursive(outOfOrder);
    final var sortedOutOfOrderQueue = outOfOrderOperationResult.returnedValue();
    final var mergedSortedQueues =
      AlgorithmImpl.mergeSortedQueues(sortedSequence, sortedOutOfOrderQueue);

    return new OperationResult<>(comparisonsAndSwaps, comparisonsAndSwaps, sortedSequence)
      .add(outOfOrderOperationResult).add(mergedSortedQueues);
  }

  private static OperationResult<IntQueue> mergeSortedQueues(
    final IntQueue sortedSequence, final IntQueue remainingSorted
  ) {

    final var mergeSize = Math.min(sortedSequence.size(), remainingSorted.size());

    final var merge = new IntQueue();
    while ((!sortedSequence.empty() && !remainingSorted.empty())) {
      final var sortedSequenceIsNext = sortedSequence.top() <= remainingSorted.top();
      final var nextInSequence =
        sortedSequenceIsNext ? sortedSequence.dequeue() : remainingSorted.dequeue();
      merge.queue(nextInSequence);
    }

    // one of both queues is already empty by now
    final var remainingSwaps = merge.consume(sortedSequence) + merge.consume(remainingSorted);
    return new OperationResult<>(mergeSize, (long) mergeSize + (long) remainingSwaps, merge);
  }

}
