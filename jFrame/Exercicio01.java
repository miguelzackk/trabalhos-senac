package jFrame;

import javax.swing.JFrame;

public class Exercicio01 extends JFrame 
{

	public Exercicio01() 
	{
		setTitle("Bem-vindo");
		setSize(1920, 1080);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) 
	{
		new Exercicio01();
	}
}
