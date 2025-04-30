package javaxTask;

import javax.swing.JOptionPane;

public class Cenario01 
{

	public static void main(String[] args) 
	{
		JOptionPane.showMessageDialog(null, "Bem-Vindo(a) a nossa calculadora.");

		valoresCen01 val = new valoresCen01();
		do 
		{
			val.num1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro número."));

			val.ope = JOptionPane.showInputDialog("Digite a operação que deseja executar (+, -, *, /)");

			val.num2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo número."));

			switch (val.ope) {
			case "+":
				val.resul = val.num1 + val.num2;
				break;
			case "-":
				val.resul = val.num1 - val.num2;
				break;
			case "*":
				val.resul = val.num1 * val.num2;
				break;
			case "/":
				val.resul = val.num1 / val.num2;
				break;
			default:
				JOptionPane.showMessageDialog(null, "A operação escolhida é inválida.");
				val.defalt = true;
			}

			if (val.defalt == true) 
			{
				while (val.defalt == true) 
				{
					val.num1 = Double.parseDouble(JOptionPane.showInputDialog("Digite o primeiro número."));

					val.ope = JOptionPane.showInputDialog("Digite a operação que deseja executar (+, -, *, /)");

					val.num2 = Double.parseDouble(JOptionPane.showInputDialog("Digite o segundo número."));

					switch (val.ope) 
					{
					case "+":
						val.resul = val.num1 + val.num2;
						val.defalt = false;
						break;
					case "-":
						val.resul = val.num1 - val.num2;
						val.defalt = false;
						break;
					case "*":
						val.resul = val.num1 * val.num2;
						val.defalt = false;
						break;
					case "/":
						val.resul = val.num1 / val.num2;
						val.defalt = false;
						break;
					default:
						JOptionPane.showMessageDialog(null, "A operação escolhida é inválida.");
		
					}
				}
			}

			JOptionPane.showMessageDialog(null, "O resutado da operação é: " + val.resul + ".");

			int result = JOptionPane.showConfirmDialog(null, "Você deseja sair da calculadora?", "Calculadora",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) 
			{
				val.dec = 0;
			} else if (result == JOptionPane.NO_OPTION) 
			{
				val.dec = 1;
			}
		} while (val.dec != 0);

	}
}