package edu.schwabe.sequencesort.algorithm;

import java.util.stream.Stream;

/**
 * Properly presents the results of multiple trials of running a variation of
 * sequence sort on arrays of numbers.
 */
public interface Reporter {

  /**
   * Presents the results.
   *
   * @param algorithmClass the class of the variation of sequence sort
   * @param reportsStream  the streamed results of the trials
   */
  void display(Class<? extends Algorithm> algorithmClass, Stream<OperationReport> reportsStream);
}
