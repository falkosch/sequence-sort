package edu.schwabe.sequencesort.analysis;

import edu.schwabe.sequencesort.algorithm.OperationResult;
import edu.schwabe.sequencesort.algorithm.SortedProperty;

public final class ReflectsMonotonicOrderSortedProperty implements SortedProperty {

  @Override
  public boolean fulfilledBy(final OperationResult<int[]> result) {
    final var array = result.getReturnedValue();
    if (array == null || array.length == 0) {
      return true;
    }

    var predecessor = array[0];

    for (final int element : array) {
      if (predecessor > element) {
        return false;
      }
      predecessor = element;
    }

    return true;
  }
}
