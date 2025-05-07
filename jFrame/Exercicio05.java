package jFrame;

import javax.swing.*;
import java.awt.event.*;

public class Exercicio05 extends JFrame 
{

    public Exercicio05() 
    {
        setTitle("Cadastro de Nome e Idade");
        setSize(350, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

  
        JLabel labelNome = new JLabel("Nome:");
        labelNome.setBounds(20, 20, 50, 25);
        JTextField campoNome = new JTextField();
        campoNome.setBounds(80, 20, 200, 25);

       
        JLabel labelIdade = new JLabel("Idade:");
        labelIdade.setBounds(20, 60, 50, 25);
        JTextField campoIdade = new JTextField();
        campoIdade.setBounds(80, 60, 200, 25);

     
        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBounds(100, 100, 120, 30);

        botaoCadastrar.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                String nome = campoNome.getText();
                String idade = campoIdade.getText();

                if (!nome.isEmpty() && !idade.isEmpty()) 
                {
                    JOptionPane.showMessageDialog(null,
                        "Cadastro realizado com sucesso para " + nome + ", idade " + idade + ".");
                } else 
                {
                    JOptionPane.showMessageDialog(null,
                        "Por favor, preencha todos os campos.", "Erro", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        add(labelNome);
        add(campoNome);
        add(labelIdade);
        add(campoIdade);
        add(botaoCadastrar);
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new Exercicio05().setVisible(true));
    }
}
