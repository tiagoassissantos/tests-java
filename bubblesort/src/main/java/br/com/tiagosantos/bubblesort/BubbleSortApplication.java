package br.com.tiagosantos.bubblesort;

import java.util.Arrays;

public class BubbleSortApplication {

	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		int[] array = bubbleSort.sort();

		System.out.println(Arrays.toString(array));
	}

}
