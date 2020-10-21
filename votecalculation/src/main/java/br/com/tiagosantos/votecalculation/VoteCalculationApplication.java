package br.com.tiagosantos.votecalculation;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VoteCalculationApplication {
	public static void main(String[] args) {
		VoteCalculation voteCalculation = new VoteCalculation();
		System.out.println("Valid Votes Percentage: " + voteCalculation.calculateValidPercentage());
		System.out.println("Blank Votes Percentage: " + voteCalculation.calculateBlankPercentage());
		System.out.println("Null Votes Percentage : " + voteCalculation.calculateNullPercentage());
	}
}
