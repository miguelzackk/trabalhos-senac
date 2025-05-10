package jframee;

import javax.swing.*;

public class Exercicio07 extends JFrame {

    public Exercicio07() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null); // Centraliza a janela

        // Campo de usuário
        JLabel textoUsuario = new JLabel("Usuário:");
        textoUsuario.setBounds(30, 30, 80, 25);
        JTextField entradaUsuario = new JTextField();
        entradaUsuario.setBounds(100, 30, 150, 25);

        // Campo de senha
        JLabel textoSenha = new JLabel("Senha:");
        textoSenha.setBounds(30, 70, 80, 25);
        JPasswordField entradaSenha = new JPasswordField();
        entradaSenha.setBounds(100, 70, 150, 25);

        // Botão para entrar
        JButton botaoEntrar = new JButton("Entrar");
        botaoEntrar.setBounds(100, 110, 90, 30);

        // Ação do botão
        botaoEntrar.addActionListener(e -> {
            String usuario = entradaUsuario.getText();
            String senha = new String(entradaSenha.getPassword());

            if (usuario.equals("oioioi") && senha.equals("12345")) {
                JOptionPane.showMessageDialog(null, "Acesso autorizado!");

                JFrame telaBemVindo = new JFrame("Bem-vindo!");
                telaBemVindo.setSize(250, 150);
                telaBemVindo.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                telaBemVindo.add(new JLabel("Você entrou no sistema!", SwingConstants.CENTER));
                telaBemVindo.setLocationRelativeTo(null);
                telaBemVindo.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Adiciona tudo na janela
        add(textoUsuario);
        add(entradaUsuario);
        add(textoSenha);
        add(entradaSenha);
        add(botaoEntrar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Exercicio07().setVisible(true));
    }
}
