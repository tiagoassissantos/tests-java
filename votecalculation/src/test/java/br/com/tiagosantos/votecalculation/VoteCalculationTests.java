package br.com.tiagosantos.votecalculation;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VoteCalculationTests {
	private VoteCalculation votesCalculation = new VoteCalculation();

	@Test
	void should_return_valid_percentage() {
		float percentage = votesCalculation.calculatePercentage(100, 80);
		assertEquals(80.00, percentage);
	}

	@Test
	void should_return_valid_percentage_in_fraction() {
		Float percentage = votesCalculation.calculatePercentage(1000, 8);
		assertEquals(0.8f, percentage);
	}

	@Test
	void should_return_valid_votes_percentage() {
		Float validParcentage = votesCalculation.calculateValidPercentage();
		assertEquals(80, validParcentage);
	}

	@Test
	void should_return_blank_votes_percentage() {
		Float blankPercentage = votesCalculation.calculateBlankPercentage();
		assertEquals(15, blankPercentage);
	}

	@Test
	void should_return_null_votes_percentage() {
		Float nullPercentage = votesCalculation.calculateNullPercentage();
		assertEquals(5, nullPercentage);
	}

}
