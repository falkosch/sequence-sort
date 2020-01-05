package edu.schwabe.sequencesort.algorithm;

import org.eclipse.jdt.annotation.NonNull;

public interface Algorithm {

    @NonNull
    OperationResult<int @NonNull []> sort(int @NonNull [] items);
}
