package edu.schwabe.sequencesort.analysis.report;

public final class OperationMetric {

  private final long _value;

  private final long n;

  public OperationMetric(final long value, final long n) {
    this._value = value;
    this.n = n;
  }

  private double doubleValue() {
    return this._value;
  }

  private double doubleN() {
    return this.n;
  }

  public Long value() {
    return this._value;
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
