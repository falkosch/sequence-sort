package edu.schwabe.sequencesort.algorithm;

import org.eclipse.jdt.annotation.NonNull;

public interface SortedProperty {

    boolean fulfilledBy(@NonNull OperationResult<int @NonNull []> result);
}
