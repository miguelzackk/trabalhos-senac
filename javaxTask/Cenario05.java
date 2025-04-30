package javaxTask;

import javax.swing.JOptionPane;

public class Cenario05 
{

	public static void main(String[] args) 
	{
		double num;
		int dec = 0;

		JOptionPane.showMessageDialog(null, "Bem-vindo(a) a nossa calculadora de tabuada.");

		do 
		{
			num = Double.parseDouble(JOptionPane.showInputDialog("Insira o número que deseja calcular a tabuada:"));
			
			JOptionPane.showMessageDialog(null, 
				    "O resultado é:\n" +
				    num + " * 1 = " + (num * 1) + "\n" +
				    num + " * 2 = " + (num * 2) + "\n" +
				    num + " * 3 = " + (num * 3) + "\n" +
				    num + " * 4 = " + (num * 4) + "\n" +
				    num + " * 5 = " + (num * 5) + "\n" +
				    num + " * 6 = " + (num * 6) + "\n" +
				    num + " * 7 = " + (num * 7) + "\n" +
				    num + " * 8 = " + (num * 8) + "\n" +
				    num + " * 9 = " + (num * 9) + "\n" +
				    num + " * 10 = " + (num * 10)
				);
			
			int result = JOptionPane.showConfirmDialog(null, "Você deseja sair da calculadora?", "Calculadora",
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
