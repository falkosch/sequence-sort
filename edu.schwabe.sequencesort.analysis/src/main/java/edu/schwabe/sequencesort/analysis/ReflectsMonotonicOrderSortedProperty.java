package edu.schwabe.sequencesort.analysis;

import org.eclipse.jdt.annotation.NonNull;

import edu.schwabe.sequencesort.api.OperationResult;
import edu.schwabe.sequencesort.api.SortedProperty;

public final class ReflectsMonotonicOrderSortedProperty implements SortedProperty {

    @Override
    public boolean fulfilledBy(@NonNull final OperationResult<int @NonNull []> result) {
	final var array = result.returnedValue();
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
