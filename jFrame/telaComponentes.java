package jFrame;

import javax.swing.*;

public class telaComponentes extends JFrame 
{
	public telaComponentes() 
	{
		setTitle("Tela componentes exemplo");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);

		JLabel lblNome = new JLabel("nome");
		lblNome.setBounds(30, 30, 100, 30);

		JTextField txtNome = new JTextField();
		txtNome.setBounds(100, 30, 200, 30);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(100, 80, 100, 30);

		add(lblNome);
		add(txtNome);
		add(btnEnviar);
	}

	public static void main(String[] args) 
	{
		telaComponentes tela = new telaComponentes();
		tela.setVisible(true);
	}

}
