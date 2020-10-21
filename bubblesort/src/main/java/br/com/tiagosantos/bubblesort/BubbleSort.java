package br.com.tiagosantos.bubblesort;

public class BubbleSort {
    private int[] array = {5,3,2,4,7,1,0,6};

    public int[] sort() {
        int[] sortedArray = runSort(array);
        return sortedArray;
    }

    protected int[] runSort( int[] arrayToSort ) {
        int arrayLength = arrayToSort.length;

        int iterations = 1;
        while (iterations < arrayLength-1) {
            iterateArray(arrayToSort, arrayLength, iterations);
            iterations++;
        }

        return array;
    }

    protected void iterateArray(int[] arrayToSort, int arrayLength, int iterations) {
        for (int i = 0; i < arrayLength-iterations; i++) {
            compareNumbers(arrayToSort, i);
        }
    }

    protected void compareNumbers(int[] arrayToSort, int index) {
        int val1 = arrayToSort[index];
        int val2 = arrayToSort[index+1];

        if (val1 > val2) {
            arrayToSort[index] = val2;
            arrayToSort[index+1] = val1;
        }
    }
}
