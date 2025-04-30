package javaxSwing;

import javax.swing.JOptionPane;

public class nomeIdade 
{
	public static void main(String[] args) 
	{
		Pessoa p = new Pessoa();
		
		p.nome = JOptionPane.showInputDialog("Digite seu nome:");
		p.idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a sua idade:"));
		
		JOptionPane.showMessageDialog(null, "Nome: " + p.nome + "." + "\nIdade: " + p.idade + ".");
	}
}
