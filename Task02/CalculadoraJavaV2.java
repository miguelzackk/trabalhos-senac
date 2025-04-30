package Task02;

import java.util.Scanner;

public class CalculadoraJavaV2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o primeiro número:");
		float num1 = sc.nextFloat();
		System.out.println("Digite o segundo número:");
		float num2 = sc.nextFloat();
		System.out.println("Digite a operação desejada(+, -, *, /):");
		char ope = sc.next().charAt(0);

		if (ope == '+') {
			System.out.printf("A operação escolhida foi soma. \nA soma do primeiro número com segundo número é %.2f.\n",
					(num1 + num2));
		} else if (ope == '-') {
			System.out.printf(
					"A operação escolhida foi subtração. \nA suntração do primeiro número com segundo número é %.2f.\n",
					(num1 - num2));
		} else if (ope == '*') {
			System.out.printf(
					"A operação escolhida foi multiplicação. \nA multiplicação do primeiro número com segundo número é %.2f.\n",
					(num1 * num2));
		} else if (ope == '/') {
			System.out.printf(
					"A operação escolhida foi divisão. \nA divisão do primeiro número com segundo número é %.2f.\n",
					(num1 / num2));
		}
		else {
			System.out.println("A operação escolhida é inválida.");
		}

		sc.close();

	}

}
