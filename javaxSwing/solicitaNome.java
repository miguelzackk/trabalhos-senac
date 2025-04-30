package javaxSwing;

import javax.swing.JOptionPane;

public class solicitaNome 
{
	public static void main(String[] args) 
	{
		String nome = JOptionPane.showInputDialog("Qual o seu nome?");
		JOptionPane.showMessageDialog(null, "Olá, " + nome + "!");
	}
}