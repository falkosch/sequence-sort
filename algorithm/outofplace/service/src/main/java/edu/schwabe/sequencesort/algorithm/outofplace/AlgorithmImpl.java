package edu.schwabe.sequencesort.algorithm.outofplace;

import edu.schwabe.sequencesort.algorithm.Algorithm;
import edu.schwabe.sequencesort.algorithm.OperationResult;
import edu.schwabe.sequencesort.algorithm.outofplace.algorithmic.IntQueue;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public final class AlgorithmImpl implements Algorithm {

  @Override
  @NonNull
  public OperationResult<int @NonNull []> sort(final int @NonNull [] items) {
    final var operationResult = AlgorithmImpl.sortRecursive(new IntQueue(items));
    final var comparisons = operationResult.comparisons();
    final var swaps = operationResult.swaps();
    final var sortedIntQueue = operationResult.returnedValue();
    final var sortedItems = AlgorithmImpl.asArray(sortedIntQueue);
    return new OperationResult<>(comparisons, swaps, sortedItems);
  }

  private static int @NonNull [] asArray(final @Nullable IntQueue sortedItems) {
    if (sortedItems == null) {
      return new int[0];
    }
    return sortedItems.toArray();
  }

  @NonNull
  private static OperationResult<@NonNull IntQueue> sortRecursive(final @NonNull IntQueue items) {
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

  @NonNull
  private static OperationResult<@NonNull IntQueue> mergeSortedQueues(
    final @NonNull IntQueue sortedSequence, final @NonNull IntQueue remainingSorted
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
    return new OperationResult<>(mergeSize, mergeSize + remainingSwaps, merge);
  }

}
