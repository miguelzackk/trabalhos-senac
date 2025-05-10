package jframee;

import javax.swing.*;
import java.awt.event.*;

public class Exercicio05 extends JFrame {

    public Exercicio05() {
        setTitle("Cadastro");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null); // Centraliza a janela

        // Rótulo e campo para o nome
        JLabel textoNome = new JLabel("Nome:");
        textoNome.setBounds(20, 20, 50, 25);
        JTextField campoNome = new JTextField();
        campoNome.setBounds(80, 20, 200, 25);

        // Rótulo e campo para a idade
        JLabel textoIdade = new JLabel("Idade:");
        textoIdade.setBounds(20, 60, 50, 25);
        JTextField campoIdade = new JTextField();
        campoIdade.setBounds(80, 60, 200, 25);

        // Botão de cadastro
        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBounds(100, 100, 120, 30);

        // Ação do botão
        botaoCadastrar.addActionListener(e -> {
            String nome = campoNome.getText();
            String idade = campoIdade.getText();

            if (!nome.isEmpty() && !idade.isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "Cadastro feito!\nNome: " + nome + "\nIdade: " + idade);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Por favor, preencha todos os campos.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });

        // Adicionando componentes à janela
        add(textoNome);
        add(campoNome);
        add(textoIdade);
        add(campoIdade);
        add(botaoCadastrar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Exercicio05().setVisible(true));
    }
}
