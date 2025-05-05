package jFrame;

import java.awt.event.*;
import javax.swing.*;

public class telaEvento extends JFrame {

	public telaEvento() {
		setTitle("Exemplo de Evento com Botão");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		JButton botaoMensagem = new JButton("Mostrar Mensagem");
		botaoMensagem.setBounds(170, 150, 160, 40);

		botaoMensagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Você clicou no botão!");
			}
		});

		add(botaoMensagem);
	}

	public static void main(String[] args) {
		telaEvento janela = new telaEvento();
		janela.setVisible(true);
	}
}