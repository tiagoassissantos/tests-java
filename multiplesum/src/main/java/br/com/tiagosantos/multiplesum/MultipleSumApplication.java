package br.com.tiagosantos.multiplesum;

import java.util.Scanner;

public class MultipleSumApplication {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);

			System.out.println("Informe um número para somar os múltiplos de 3 e 5 entre 1 e o número informado:");
			int value = scanner.nextInt();

			MultipleSum factorial = new MultipleSum();
			long calculated = factorial.sum(value);
			System.out.println(calculated);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
