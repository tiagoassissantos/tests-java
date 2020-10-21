package br.com.tiagosantos.factorial;

public class Factorial {

	public long calculate(long value) {
		long result = factorial(value);
		return result;
	}

	protected long factorial(long value) {
		if (value == 0) return 1;
		return value * factorial(value - 1);
	}

}
