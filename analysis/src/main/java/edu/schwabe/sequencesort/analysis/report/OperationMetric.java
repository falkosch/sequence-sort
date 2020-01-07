package edu.schwabe.sequencesort.analysis.report;

public final class OperationMetric {

  private final long value;

  private final long itemsCount;

  /**
   * Creates a new {@link OperationMetric} with the given metric {@code value} and
   * an {@code itemsCount} as scaling parameter.
   *
   * @param value      the metric value
   * @param itemsCount the scale parameter
   */
  public OperationMetric(final long value, final long itemsCount) {
    this.value = value;
    this.itemsCount = itemsCount;
  }

  private double getValueAsRawDouble() {
    return this.value;
  }

  private double getItemsCountAsRawDouble() {
    return this.itemsCount;
  }

  public Long getValueAsBoxedLong() {
    return Long.valueOf(this.value);
  }

  /**
   * Returns the metric value scaled by the term <code>N * ln(N)</code>, whereby
   * {@code N} is the {@link #itemsCount}.
   *
   * @return the result of the division
   */
  public Double divideValueByNLnN() {
    final var doubleN = this.getItemsCountAsRawDouble();
    final var result = this.getValueAsRawDouble() / (doubleN * Math.log(doubleN));
    return Double.valueOf(result);
  }

  /**
   * Returns the metric value scaled by the term <code>N * sqrt(N)</code>, whereby
   * {@code N} is the {@link #itemsCount}.
   *
   * @return the result of the division
   */
  public Double divideByNSqrtN() {
    final var doubleN = this.getItemsCountAsRawDouble();
    final var result = this.getValueAsRawDouble() / (doubleN * Math.sqrt(doubleN));
    return Double.valueOf(result);
  }

  /**
   * Returns the metric value scaled by the term <code>N * N</code>, whereby
   * {@code N} is the {@link #itemsCount}.
   *
   * @return the result of the division
   */
  public Double divideBySqrN() {
    final var doubleN = this.getItemsCountAsRawDouble();
    final var result = this.getValueAsRawDouble() / (doubleN * doubleN);
    return Double.valueOf(result);
  }
}
