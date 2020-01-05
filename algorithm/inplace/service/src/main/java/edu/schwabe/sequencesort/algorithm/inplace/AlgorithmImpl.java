package edu.schwabe.sequencesort.algorithm.inplace;

import org.eclipse.jdt.annotation.NonNull;

import edu.schwabe.sequencesort.algorithm.Algorithm;
import edu.schwabe.sequencesort.algorithm.OperationResult;

public final class AlgorithmImpl implements Algorithm {

	@Override
	@NonNull
	public OperationResult<int @NonNull []> sort(final int @NonNull [] items) {
		return AlgorithmImpl.sortRecursive(items, 0, items.length).returnedValue(items);
	}

	private static @NonNull OperationResult<int @NonNull []> sortRecursive(
	    final int @NonNull [] items, final int leftBound, final int rightBound
	) {
		if (leftBound >= rightBound - 1) {
			return new OperationResult<>(0, 0, items);
		}

		var operationResult = new OperationResult<>(rightBound - leftBound - 1, 0, items);

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
		    operationResult.add(AlgorithmImpl.sortRecursive(items, pivot, rightBound));

		// merge sorted sequence and now sorted remaining sequence
		var fromLeftBoundApproachingPivot = leftBound;
		var fromPivotApproachingRightBound = pivot;
		while (
		    fromLeftBoundApproachingPivot < pivot && fromPivotApproachingRightBound < rightBound
		) {
			operationResult = operationResult.addComparisons(1);

			if (items[fromLeftBoundApproachingPivot] <= items[fromPivotApproachingRightBound]) {
				fromLeftBoundApproachingPivot++;

			} else {

				operationResult = operationResult
				    .addSwaps(fromPivotApproachingRightBound - fromLeftBoundApproachingPivot);

				final int rightItem = items[fromPivotApproachingRightBound];

				for (
				    int i = fromPivotApproachingRightBound; i > fromLeftBoundApproachingPivot; i--
				) {
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
