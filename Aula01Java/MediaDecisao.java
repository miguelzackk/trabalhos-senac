package Aula01Java;

import java.util.Scanner;

public class MediaDecisao {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o primeira nota: ");
		double x = sc.nextDouble(); // recebendo a primeira variável
		System.out.print("Digite o segunda nota: ");
		double y = sc.nextDouble(); // recebendo a segunda variável
		System.out.print("Digite o terceira nota: ");
		double z = sc.nextDouble(); // recebendo a terceira variável
		double media = (x + y + z) / 3; // processando os valores e calculando
		System.out.println("Media = " + media); // envio do cálculo

		if (media >= 7.0) {
			System.out.println("Aluno Aprovado!");
		} else {
			System.out.println("Aluno Reprovado!");
		}

		sc.close();

	}

}
