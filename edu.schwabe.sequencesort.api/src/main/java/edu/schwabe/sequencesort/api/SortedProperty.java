package edu.schwabe.sequencesort.api;

import org.eclipse.jdt.annotation.NonNull;

public interface SortedProperty {

    boolean fulfilledBy(@NonNull OperationResult<int @NonNull []> result);
}
