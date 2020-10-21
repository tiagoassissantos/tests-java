package br.com.tiagosantos.multiplesum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MultipleSumTests {
	private MultipleSum multipleSum = new MultipleSum();

	@Test
	void should_sum_multiples_of_ten() {
		int result = multipleSum.sum(10);
		assertEquals( 23, result );
	}

	@Test
	void should_sum_multiples_of_27() {
		int result = multipleSum.sum(27);
		assertEquals( 168, result );
	}



	@Test
	void should_return_zero_if_not_divide_for_three() {
		int result = multipleSum.returnIfDivideForThreeOrFive(11);
		assertEquals( 0, result );
	}

	@Test
	void should_return_value_if_divide_for_three() {
		int result = multipleSum.returnIfDivideForThreeOrFive(9);
		assertEquals( 9, result );
	}

	@Test
	void should_return_zero_if_not_divide_for_five() {
		int result = multipleSum.returnIfDivideForThreeOrFive(17);
		assertEquals( 0, result );
	}

	@Test
	void should_return_value_if_divide_for_five() {
		int result = multipleSum.returnIfDivideForThreeOrFive(100);
		assertEquals( 100, result );
	}

}
