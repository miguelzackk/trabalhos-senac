package Task02;

import java.util.Scanner;

public class CalculadoraJava {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o primeiro número:");
		float num1 = sc.nextFloat();
		System.out.println("Digite o segundo número:");
		float num2 = sc.nextFloat();
		
		System.out.printf("A soma desses números é: %.2f.\n", (num1 + num2));
		System.out.printf("A subtração desses números é: %.2f.\n", (num1 - num2));
		System.out.printf("A multiplicação desses números é: %.2f.\n", (num1 * num2));
		System.out.printf("A divisão desses números é: %.2f.\n", (num1 / num2));

		
		sc.close();
	}

}
