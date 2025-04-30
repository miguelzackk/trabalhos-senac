package Task02;

import java.util.Scanner;

public class Verificator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite um número inteiro: ");
		int numero = sc.nextInt();

		if (numero > 0) {
			System.out.println("O número " + numero + " é Positivo.");
		} else if (numero < 0) {
			System.out.println("O número " + numero + " é Negativo.");
		} else {
			System.out.println("O número é Neutro (Zero).");
		}

		sc.close();

	}

}
