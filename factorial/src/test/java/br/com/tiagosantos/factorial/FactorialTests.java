package br.com.tiagosantos.factorial;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTests {
	private Factorial factorial = new Factorial();

	@Test
	void factorial_of_zero() {
		long factorial = this.factorial.calculate(0);
		assertEquals( 1, factorial );
	}

	@Test
	void factorial_of_one() {
		long factorial = this.factorial.calculate(1);
		assertEquals( 1, factorial );
	}

	@Test
	void factorial_of_two() {
		long factorial = this.factorial.calculate(2);
		assertEquals( 2, factorial );
	}

	@Test
	void factorial_of_three() {
		long factorial = this.factorial.calculate(3);
		assertEquals( 6, factorial );
	}

	@Test
	void factorial_of_four() {
		long factorial = this.factorial.calculate(4);
		assertEquals( 24, factorial );
	}

	@Test
	void factorial_of_five() {
		long factorial = this.factorial.calculate(5);
		assertEquals( 120, factorial );
	}

	@Test
	void factorial_of_six() {
		long factorial = this.factorial.calculate(6);
		assertEquals( 720, factorial );
	}
}
