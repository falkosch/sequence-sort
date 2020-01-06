package edu.schwabe.sequencesort.algorithm;

import java.util.stream.Stream;
import org.eclipse.jdt.annotation.NonNull;

public interface Reporter {

  void display(
    @NonNull Class<? extends Algorithm> algorithmUnderTestClass,
    @NonNull Stream<OperationReport> operationReportStream
  );
}
