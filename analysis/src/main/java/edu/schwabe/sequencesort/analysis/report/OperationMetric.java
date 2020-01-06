package edu.schwabe.sequencesort.analysis.report;

public final class OperationMetric {

  private final long mValue;

  private final long mItemCount;

  public OperationMetric(final long value, final long itemCount) {
    this.mValue = value;
    this.mItemCount = itemCount;
  }

  private double doubleValue() {
    return this.mValue;
  }

  private double doubleN() {
    return this.mItemCount;
  }

  public Long value() {
    return Long.valueOf(this.mValue);
  }

  public Double divideByNLnN() {
    final var doubleN = this.doubleN();
    final var result = this.doubleValue() / (doubleN * Math.log(doubleN));
    return Double.valueOf(result);
  }

  public Double divideByNSqrtN() {
    final var doubleN = this.doubleN();
    final var result = this.doubleValue() / (doubleN * Math.sqrt(doubleN));
    return Double.valueOf(result);
  }

  public Double divideBySqrN() {
    final var doubleN = this.doubleN();
    final var result = this.doubleValue() / (doubleN * doubleN);
    return Double.valueOf(result);
  }

}
