package jFrame;

import javax.swing.*;
import java.awt.event.*;

public class Exercicio06 extends JFrame 
{

	public Exercicio06() 
	{
		setTitle("Escolha uma Opção");
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);

		JLabel titulo = new JLabel("Selecione uma das opções");
		titulo.setBounds(100, 10, 250, 30);
		add(titulo);

		JRadioButton opcao1 = new JRadioButton("Opção 1");
		opcao1.setBounds(50, 50, 150, 25);

		JRadioButton opcao2 = new JRadioButton("Opção 2");
		opcao2.setBounds(50, 80, 150, 25);

		JRadioButton opcao3 = new JRadioButton("Opção 3");
		opcao3.setBounds(50, 110, 150, 25);

		ButtonGroup grupo = new ButtonGroup();
		grupo.add(opcao1);
		grupo.add(opcao2);
		grupo.add(opcao3);

		JButton confirmar = new JButton("Confirmar");
		confirmar.setBounds(220, 80, 120, 30);

		JTextArea resultado = new JTextArea();
		resultado.setBounds(50, 160, 290, 70);
		resultado.setLineWrap(true);
		resultado.setWrapStyleWord(true);
		resultado.setEditable(false);

		confirmar.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if (opcao1.isSelected()) 
				{
					resultado.setText("Você selecionou a Opção 1.");
				} else if (opcao2.isSelected()) 
				{
					resultado.setText("Você selecionou a Opção 2.");
				} else if (opcao3.isSelected()) 
				{
					resultado.setText("Você selecionou a Opção 3.");
				} else 
				{
					resultado.setText("Por favor, selecione uma opção.");
				}
			}
		});

		add(opcao1);
		add(opcao2);
		add(opcao3);
		add(confirmar);
		add(resultado);
	}

	public static void main(String[] args) 
	{
		SwingUtilities.invokeLater(() -> new Exercicio06().setVisible(true));
	}
}
