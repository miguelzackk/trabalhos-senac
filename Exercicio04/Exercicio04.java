package Exercicio04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercicio04 {

	public static void main(String[] args) 
	{

		JFrame frame = new JFrame("Menu Simples");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();

		JMenu arquivoMenu = new JMenu("Arquivo");
		JMenuItem novoMenuItem = new JMenuItem("Novo");
		JMenuItem sairMenuItem = new JMenuItem("Sair");

		arquivoMenu.add(novoMenuItem);
		arquivoMenu.add(sairMenuItem);

		JMenu ajudaMenu = new JMenu("Ajuda");
		JMenuItem sobreMenuItem = new JMenuItem("Sobre");

		ajudaMenu.add(sobreMenuItem);

		menuBar.add(arquivoMenu);
		menuBar.add(ajudaMenu);

		frame.setJMenuBar(menuBar);

		novoMenuItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				JFrame novaJanela = new JFrame("Nova Janela");
				novaJanela.setSize(300, 200);
				novaJanela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				novaJanela.setVisible(true);
			}
		});

		sairMenuItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		sobreMenuItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Autor: Miguel", "Sobre", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		frame.setVisible(true);
	}
}
