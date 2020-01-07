package edu.schwabe.sequencesort.algorithm;

/**
 * Inspects an array of numbers in {@link OperationResult#getReturnedValue()}
 * whether it fulfills the sorted property. Criteria for the sorter property
 * are:
 * <ul>
 * <li><code>null</code> fulfills the sorted property</li>
 * <li>an empty array fulfills the sorted property</li>
 * <li>a one element array fulfills the sorted property</li>
 * <li>a multiple elements array fulfills the sorted property, if and only if
 * there is no bigger number as predecessor for all numbers in the array</li>
 * </ul>
 */
public interface SortedProperty {

  /**
   * Determines whether an array of numbers fulfills the sorted property.
   *
   * @param result contains the array of numbers
   * @return <code>true</code> if the array is sorted, otherwise
   *         <code>false</code>
   */
  boolean fulfilledBy(OperationResult<int[]> result);
}
