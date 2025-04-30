package Task02;

import java.util.Scanner;

public class CounterRepeater {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Estrutura de repetição: contagem regressiva");

		System.out.print("Digite um número para iniciar a contagem regressiva: ");
		int inicio = sc.nextInt();

		while (inicio >= 0) {
			System.out.println(inicio);
			inicio--;
		}

		System.out.println("Fim da contagem!");

		sc.close();

	}

}
