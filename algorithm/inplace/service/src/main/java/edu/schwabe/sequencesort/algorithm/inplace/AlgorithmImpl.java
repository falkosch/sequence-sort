package edu.schwabe.sequencesort.algorithm.inplace;

import edu.schwabe.sequencesort.algorithm.Algorithm;
import edu.schwabe.sequencesort.algorithm.OperationResult;

public final class AlgorithmImpl implements Algorithm {

  @Override
  public OperationResult<int[]> sort(final int... items) {
    return AlgorithmImpl.sortRecursive(items, 0, items.length).replaceReturnedValue(items);
  }

  private static OperationResult<int[]> sortRecursive(
      final int[] items, final int leftBound, final int rightBound
  ) {
    if (leftBound >= rightBound - 1) {
      return new OperationResult<>(0, 0, items);
    }

    var operationResult = new OperationResult<>((long) rightBound - (long) leftBound - 1, 0, items);

    var pivot = leftBound;
    for (var i = leftBound + 1; i < rightBound; i++) {

      if (items[i] >= items[pivot]) {
        pivot++;

        if (pivot < i) {
          final int swap = items[pivot];
          items[pivot] = items[i];
          items[i] = swap;

          operationResult = operationResult.addSwaps(1);
        }
      }
    }

    pivot++;

    // sort remaining sequence "items[pivot to rightBound]"
    operationResult =
        operationResult.mergeWith(AlgorithmImpl.sortRecursive(items, pivot, rightBound));

    // merge sorted sequence and now sorted remaining sequence
    var fromLeftBoundApproachingPivot = leftBound;
    var fromPivotApproachingRightBound = pivot;
    while (fromLeftBoundApproachingPivot < pivot && fromPivotApproachingRightBound < rightBound) {
      operationResult = operationResult.addComparisons(1);

      if (items[fromLeftBoundApproachingPivot] <= items[fromPivotApproachingRightBound]) {
        fromLeftBoundApproachingPivot++;

      } else {

        operationResult = operationResult
            .addSwaps((long) fromPivotApproachingRightBound - (long) fromLeftBoundApproachingPivot);

        final int rightItem = items[fromPivotApproachingRightBound];

        for (int i = fromPivotApproachingRightBound; i > fromLeftBoundApproachingPivot; i--) {
          items[i] = items[i - 1];
        }
        items[fromLeftBoundApproachingPivot] = rightItem;

        pivot++;
        fromLeftBoundApproachingPivot++;
        fromPivotApproachingRightBound++;
      }
    }

    return operationResult;
  }
}
