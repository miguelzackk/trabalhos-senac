package jFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercicio10 extends JFrame {

    public Exercicio10() {
        setTitle("Sistema de Cadastro");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Botão para abrir a janela de cadastro
        JButton botaoCadastro = new JButton("Novo Cadastro");
        botaoCadastro.addActionListener(e -> new JanelaCadastro().setVisible(true));

        add(botaoCadastro);
    }

    // Método para exibir a mensagem de sucesso
    public void mostrarSucesso(String nome) {
        JOptionPane.showMessageDialog(this, "Cadastro de " + nome + " realizado com sucesso!");
    }

    // Janela para cadastro de dados do usuário
    private class JanelaCadastro extends JFrame {
        private JTextField campoNome;
        private JTextField campoIdade;
        private JRadioButton generoMasculino, generoFeminino, generoOutro;

        public JanelaCadastro() {
            setTitle("Cadastro");
            setSize(300, 300);
            setLocationRelativeTo(null);
            setLayout(new GridLayout(8, 1));

            // Campos de entrada
            campoNome = new JTextField();
            campoIdade = new JTextField();

            // Opções de gênero
            generoMasculino = new JRadioButton("Masculino");
            generoFeminino = new JRadioButton("Feminino");
            generoOutro = new JRadioButton("Outro");

            // Grupo de botões de gênero
            ButtonGroup grupoGenero = new ButtonGroup();
            grupoGenero.add(generoMasculino);
            grupoGenero.add(generoFeminino);
            grupoGenero.add(generoOutro);

            // Botão de salvar
            JButton botaoSalvar = new JButton("Salvar");
            botaoSalvar.addActionListener(e -> {
                String nome = campoNome.getText();
                String idade = campoIdade.getText();

                // Validação de campos
                if (nome.isEmpty() || idade.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
                } else {
                    mostrarSucesso(nome);
                    dispose(); // Fecha a janela de cadastro
                }
            });

            // Adiciona componentes na janela de cadastro
            add(new JLabel("Nome:"));
            add(campoNome);
            add(new JLabel("Idade:"));
            add(campoIdade);
            add(generoMasculino);
            add(generoFeminino);
            add(generoOutro);
            add(botaoSalvar);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Exercicio10().setVisible(true));
    }
}
