package jFrame;

import javax.swing.*;
import java.awt.event.*;

public class Exercicio07 extends JFrame 
{

    public Exercicio07() 
    {
        setTitle("Tela de Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

      
        JLabel labelUsuario = new JLabel("Usuário:");
        labelUsuario.setBounds(30, 30, 80, 25);
        JTextField campoUsuario = new JTextField();
        campoUsuario.setBounds(100, 30, 150, 25);

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(30, 70, 80, 25);
        JPasswordField campoSenha = new JPasswordField();
        campoSenha.setBounds(100, 70, 150, 25);

     
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(100, 110, 90, 30);

      
        btnEntrar.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                String usuario = campoUsuario.getText();
                String senha = new String(campoSenha.getPassword());

                if (usuario.equals("admin") && senha.equals("123")) 
                {
                    JOptionPane.showMessageDialog(null, "Acesso autorizado!");
                    
               
                    JFrame novaJanela = new JFrame("Bem-vindo!");
                    novaJanela.setSize(250, 150);
                    novaJanela.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    JLabel texto = new JLabel("Você entrou no sistema!", SwingConstants.CENTER);
                    novaJanela.add(texto);
                    novaJanela.setLocationRelativeTo(null);
                    novaJanela.setVisible(true);

                } else 
                {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

      
        add(labelUsuario);
        add(campoUsuario);
        add(labelSenha);
        add(campoSenha);
        add(btnEntrar);
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new Exercicio07().setVisible(true));
    }
}

