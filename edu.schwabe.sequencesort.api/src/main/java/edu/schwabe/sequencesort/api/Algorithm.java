package edu.schwabe.sequencesort.api;

import org.eclipse.jdt.annotation.NonNull;

public interface Algorithm {

    @NonNull
    OperationResult<int @NonNull []> sort(int @NonNull [] items);
}
