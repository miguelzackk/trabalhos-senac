package jFrame;

import javax.swing.JFrame;

public class estruturaBasica 
{

	public static void main(String[] args) 
	{
		JFrame janela = new JFrame ("Minha primeira janela.");
		janela.setSize(1920, 1080); //Tamanho inicial da janela
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Assim que a janela for fechada, encerrar a execução
		janela.setVisible(true);
	}

}
