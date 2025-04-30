package javaxTask;

import javax.swing.JOptionPane;

public class Cenario06 
{

	public static void main(String[] args) 
	{
		double nota1, nota2, nota3, nota4, media;
		int dec = 0;

		JOptionPane.showMessageDialog(null, "Bem-vindo(a) à nossa calculadora de notas.");

		do 
		{
			do 
			{
				nota1 = Double.parseDouble(JOptionPane.showInputDialog("Insira a primeira nota (0 a 10):"));
				if (nota1 < 0 && nota1 > 10) 
				{
					JOptionPane.showMessageDialog(null, "Nota inválida! Insira um valor entre 0 e 10.");
				}
			} while (nota1 < 0 && nota1 > 10);

			do 
			{
				nota2 = Double.parseDouble(JOptionPane.showInputDialog("Insira a segunda nota (0 a 10):"));
				if (nota2 < 0 && nota2 > 10) 
				{
					JOptionPane.showMessageDialog(null, "Nota inválida! Insira um valor entre 0 e 10.");
				}
			} while (nota2 < 0 && nota2 > 10);

			do 
			{
				nota3 = Double.parseDouble(JOptionPane.showInputDialog("Insira a terceira nota (0 a 10):"));
				if (nota3 < 0 && nota3 > 10) 
				{
					JOptionPane.showMessageDialog(null, "Nota inválida! Insira um valor entre 0 e 10.");
				}
			} while (nota3 < 0 && nota3 > 10);

			do 
			{
				nota4 = Double.parseDouble(JOptionPane.showInputDialog("Insira a quarta nota (0 a 10):"));
				if (nota4 < 0 && nota4 > 10) 
				{
					JOptionPane.showMessageDialog(null, "Nota inválida! Insira um valor entre 0 e 10.");
				}
			} while (nota4 < 0 && nota4 > 10);

			media = (nota1 + nota2 + nota3 + nota4) / 4;

			String situacao;
			if (media >= 7) 
			{
				situacao = "Aprovado(a)";
			} else if (media >= 5) 
			{
				situacao = "Em recuperação";
			} else 
			{
				situacao = "Reprovado(a)";
			}

			JOptionPane.showMessageDialog(null,
					"Sua média foi: " + String.format("%.2f", media) + "\n" + "Situação: " + situacao);

			int result = JOptionPane.showConfirmDialog(null, "Deseja calcular a média de outro aluno?", "Calculadora",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) 
			{
				dec = 1;
			} else if (result == JOptionPane.NO_OPTION) 
			{
				dec = 0;
			}
		} while (dec != 0);

	}

}
