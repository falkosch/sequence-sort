package edu.schwabe.sequencesort.analysis.report;

public final class OperationMetric {

    private final long value;

    private final long n;

    public OperationMetric(final long value, final long n) {
	this.value = value;
	this.n = n;
    }

    private double doubleValue() {
	return this.value;
    }

    private double doubleN() {
	return this.n;
    }

    public Long value() {
	return Long.valueOf(this.value);
    }

    public Double divideByNLnN() {
	final var doubleN = this.doubleN();
	return Double.valueOf(this.doubleValue() / (doubleN * Math.log(doubleN)));
    }

    public Double divideByNSqrtN() {
	final var doubleN = this.doubleN();
	return Double.valueOf(this.doubleValue() / (doubleN * Math.sqrt(doubleN)));
    }

    public Double divideBySqrN() {
	final var doubleN = this.doubleN();
	return Double.valueOf(this.doubleValue() / (doubleN * doubleN));
    }

}
