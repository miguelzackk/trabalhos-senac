package jFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercicio10 extends JFrame 
{

    public Exercicio10() 
    {
        setTitle("Sistema de Cadastro");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        JButton botaoCadastro = new JButton("Novo Cadastro");
        botaoCadastro.addActionListener(e -> 
        {
            new JanelaCadastro().setVisible(true);
        });

        add(botaoCadastro);
    }

    public void mostrarMensagemSucesso(String nome) 
    {
        JOptionPane.showMessageDialog(this, "Cadastro de " + nome + " realizado com sucesso!");
    }


    private class JanelaCadastro extends JFrame 
    {
        private JTextField campoNome;
        private JTextField campoIdade;
        private JRadioButton generoMasc, generoFem, generoOutro;

        public JanelaCadastro() {
            setTitle("Cadastro");
            setSize(300, 300);
            setLocationRelativeTo(null);
            setLayout(new GridLayout(8, 1));

            campoNome = new JTextField();
            campoIdade = new JTextField();

            generoMasc = new JRadioButton("Masculino");
            generoFem = new JRadioButton("Feminino");
            generoOutro = new JRadioButton("Outro");

            ButtonGroup grupoGenero = new ButtonGroup();
            grupoGenero.add(generoMasc);
            grupoGenero.add(generoFem);
            grupoGenero.add(generoOutro);

            JButton botaoSalvar = new JButton("Salvar");
            botaoSalvar.addActionListener(e -> {
                String nome = campoNome.getText();
                String idade = campoIdade.getText();

                if (nome.isEmpty() || idade.isEmpty()) 
                {
                    JOptionPane.showMessageDialog(this, "Preencha todos os campos.");
                } else 
                {
                    mostrarMensagemSucesso(nome);
                    dispose(); 
                }
            });

            add(new JLabel("Nome:"));
            add(campoNome);
            add(new JLabel("Idade:"));
            add(campoIdade);
            add(generoMasc);
            add(generoFem);
            add(generoOutro);
            add(botaoSalvar);
        }
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new Exercicio10().setVisible(true));
    }
}

