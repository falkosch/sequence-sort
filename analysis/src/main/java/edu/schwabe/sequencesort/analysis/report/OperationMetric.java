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
    return this.mValue;
  }

  public Double divideByNLnN() {
    final var doubleN = this.doubleN();
    return this.doubleValue() / (doubleN * Math.log(doubleN));
  }

  public Double divideByNSqrtN() {
    final var doubleN = this.doubleN();
    return this.doubleValue() / (doubleN * Math.sqrt(doubleN));
  }

  public Double divideBySqrN() {
    final var doubleN = this.doubleN();
    return this.doubleValue() / (doubleN * doubleN);
  }

}
