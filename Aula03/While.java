package Aula03;

import java.util.Scanner;

public class While {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int random = (int) (Math.random() * 21);

		System.out.println("Tente adivinhar qual é o número! Ele é um número inteiro entre 0 e 20!");

		int tentativa = 0;
		int num = -1;

		while (num != random) {
			System.out.println("Qual é a sua aposta?");
			num = sc.nextInt();

			tentativa++;

			if (num < random) {
				System.out.println("O número é maior, tente novamente!");
			} else if (num > random) {
				System.out.println("O número é menor, tente novamente!");
			} else {
				System.out.println("Parabéns! Você acertou o número em " + tentativa + " tentativas!");
			}
		}

		sc.close();

	}

}
