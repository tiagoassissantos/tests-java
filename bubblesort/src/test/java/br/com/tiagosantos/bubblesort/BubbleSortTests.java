package br.com.tiagosantos.bubblesort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class BubbleSortTests {
	private BubbleSort bubbleSort = new BubbleSort();

	@Test
	void should_order_array() {
		int[] arrayAssert = {0,1,2,3,4,5,6,7};
		int[] arrayOrdered = bubbleSort.sort();

		assertArrayEquals(arrayAssert, arrayOrdered);
	}

}
