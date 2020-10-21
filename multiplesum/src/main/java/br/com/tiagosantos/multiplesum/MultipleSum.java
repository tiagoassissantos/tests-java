package br.com.tiagosantos.multiplesum;

public class MultipleSum {

    public int sum(int value) {
        int total = 0;

        for (int i = 1; i < value; i++) {
            total += returnIfDivideForThreeOrFive(i);
        }

        return total;
    }

    protected int returnIfDivideForThreeOrFive(int value) {
        if (value % 3 == 0) return value;
        if (value % 5 == 0) return value;
        return 0;
    }

}
