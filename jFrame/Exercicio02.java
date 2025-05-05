package jFrame;

import javax.swing.*;
import java.awt.event.*;

public class Exercicio02 extends JFrame 
{

	private JLabel rotulo;
	private JTextField campoTexto;
	private JButton botaoEnviar;

	public Exercicio02() 
	{
		setTitle("Formulário Simples");
		setSize(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		rotulo = new JLabel("Digite seu nome:");
		rotulo.setBounds(30, 30, 150, 25);
		add(rotulo);

		campoTexto = new JTextField();
		campoTexto.setBounds(150, 30, 200, 25);
		add(campoTexto);

		botaoEnviar = new JButton("Enviar");
		botaoEnviar.setBounds(150, 70, 100, 30);
		add(botaoEnviar);

		botaoEnviar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String nome = campoTexto.getText();
				JOptionPane.showMessageDialog(null, "Olá, " + nome + "!");
			}
		});
	}

	public static void main(String[] args) 
	{
		Exercicio02 tela = new Exercicio02();
		tela.setVisible(true);
	}
}
