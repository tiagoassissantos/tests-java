package br.com.tiagosantos.votecalculation;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class VoteCalculation {
	private final Integer totalVoters = 1000;
	private final Integer validVotes = 800;
	private final Integer blankVotes = 150;
	private final Integer nullVotes = 50;

	public Float calculateValidPercentage() {
		return calculatePercentage(totalVoters, validVotes);
	}

	public Float calculateBlankPercentage() {
		return calculatePercentage(totalVoters, blankVotes);
	}

	public Float calculateNullPercentage() {
		return calculatePercentage(totalVoters, nullVotes);
	}

	protected Float calculatePercentage(Integer total, Integer fraction) {
		BigDecimal bigTotal = new BigDecimal(total);
		BigDecimal bigFraction = new BigDecimal(fraction);
		BigDecimal result = bigFraction.divide(bigTotal).multiply(new BigDecimal(100));
		Float roundedResult = result.setScale(2, RoundingMode.HALF_UP).floatValue();
		return roundedResult;
	}
}
