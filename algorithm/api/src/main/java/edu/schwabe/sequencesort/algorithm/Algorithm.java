package edu.schwabe.sequencesort.algorithm;

/**
 * Represents a variation of sequence sort.
 */
public interface Algorithm {

  /**
   * Sorts an array of numbers.
   *
   * @param items the numbers
   * @return sorted array of the given numbers
   */
  OperationResult<int[]> sort(int... items);
}
