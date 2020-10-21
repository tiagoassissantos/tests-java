package br.com.tiagosantos.factorial;

import java.io.IOException;
import java.util.Scanner;

public class FactorialApplication {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);

			System.out.println("Informe um número para calcular o fatorial:");
			int value = scanner.nextInt();

			Factorial factorial = new Factorial();
			long calculated = factorial.calculate(value);
			System.out.println(calculated);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
