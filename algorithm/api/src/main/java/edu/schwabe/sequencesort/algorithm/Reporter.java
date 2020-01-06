package edu.schwabe.sequencesort.algorithm;

import java.util.stream.Stream;

public interface Reporter {

  void display(Class<? extends Algorithm> algorithmClass, Stream<OperationReport> reportsStream);
}
