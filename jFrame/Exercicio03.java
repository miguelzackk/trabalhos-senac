package jFrame;

import javax.swing.*;

public class Exercicio03 extends JFrame 
{

	public Exercicio03() 
	{
		setTitle("Imagem na Janela");
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		ImageIcon icone = new ImageIcon("src/img/download.jpg");

		JLabel labelImagem = new JLabel(icone);
		labelImagem.setBounds(50, 50, icone.getIconWidth(), icone.getIconHeight());

		add(labelImagem);
	}

	public static void main(String[] args) 
	{
		Exercicio03 janela = new Exercicio03();
		janela.setVisible(true);
	}
}
