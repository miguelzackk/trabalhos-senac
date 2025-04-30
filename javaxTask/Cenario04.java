package javaxTask;

import javax.swing.JOptionPane;

public class Cenario04 
{

	public static void main(String[] args) 
	{
		int num;
		int dec = 0;

		JOptionPane.showMessageDialog(null, "Bem-Vindo(a) ao nosso contador.");

		do 
		{

			num = Integer
					.parseInt(JOptionPane.showInputDialog("Digite o número inteiro que deseja contar de um até ele."));

			while (num <= 0) 
			{
				JOptionPane.showMessageDialog(null, "Valor Inválido. Tente Novamente.");
				num = Integer.parseInt(
						JOptionPane.showInputDialog("Digite o número inteiro que deseja contar de um até ele."));
			}

			for (int i = 1; i <= num; i++) 
			{
				JOptionPane.showMessageDialog(null, i);
			}
			int result = JOptionPane.showConfirmDialog(null, "Você deseja sair do contador?", "Contador",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) 
			{
				dec = 0;
			} else if (result == JOptionPane.NO_OPTION) 
			{
				dec = 1;
			}

		} while (dec != 0);
	}

}
