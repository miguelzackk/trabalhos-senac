package javaxTask;

import javax.swing.JOptionPane;

public class Cenario03 
{

	public static void main(String[] args) {
		int idade;
		int dec = 0;
		boolean verif = false;

		JOptionPane.showInternalMessageDialog(null, "Bem-vindo(a) ao nosso verificador de idade.");

		do 
		{
			do 
			{
				idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a sua idade."));
				if (idade >= 1 && idade <= 12) 
				{
					JOptionPane.showMessageDialog(null, "Você é uma criança.");
				} else if (idade >= 13 && idade <= 17) 
				{
					JOptionPane.showMessageDialog(null, "Você é um adolescente.");
				} else if (idade >= 18 && idade <= 59) 
				{
					JOptionPane.showMessageDialog(null, "Você é um adulto.");
				} else if (idade >= 60) 
				{
					JOptionPane.showMessageDialog(null, "Você é um idoso.");
				} else 
				{
					JOptionPane.showMessageDialog(null, "O dado inserido é inválido. Tente novamente");
					verif = true;
				}
			} while (verif == true);
			int result = JOptionPane.showConfirmDialog(null, "Você deseja sair do contador?", "Contador",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) 
			{
				dec = 0;
			} else if (result == JOptionPane.NO_OPTION) {
				
				dec = 1;
			}
		} while (dec != 0);
	}

}
