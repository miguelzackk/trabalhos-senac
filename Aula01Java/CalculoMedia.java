package Aula01Java;

import java.util.Scanner;

public class CalculoMedia {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
			
		System.out.print("Digite o primeiro numero: ");
		double x = sc.nextDouble(); //recebendo a primeira variável
		System.out.print("Digite o segundo numero: ");
		double y = sc.nextDouble (); //recebendo a segunda variável
		System.out.print("Digite o terceiro numero: ");
		double z = sc.nextDouble (); //recebendo a terceira variável
		double 	media = (x + y + z) / 3; //processando os valores e calculando
		System.out.println ("Media = " + media); //envio do cálculo
		sc.close();
	}

}
