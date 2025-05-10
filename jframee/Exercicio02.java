package jframee;

import javax.swing.*;
import java.awt.event.*;

public class Exercicio02 extends JFrame {

    private JLabel textoLabel;
    private JTextField campoNome;
    private JButton botaoOk;

    public Exercicio02() {
        setTitle("Minha Primeira Janela");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Usado para posicionamento manual

        // Rótulo
        textoLabel = new JLabel("Seu nome:");
        textoLabel.setBounds(30, 30, 100, 25);
        add(textoLabel);

        // Campo de texto
        campoNome = new JTextField();
        campoNome.setBounds(120, 30, 200, 25);
        add(campoNome);

        // Botão
        botaoOk = new JButton("OK");
        botaoOk.setBounds(120, 70, 100, 30);
        add(botaoOk);

        // Ação do botão
        botaoOk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nomeDigitado = campoNome.getText();
                JOptionPane.showMessageDialog(null, "Olá, " + nomeDigitado + "!");
            }
        });
    }

    public static void main(String[] args) {
        Exercicio02 janela = new Exercicio02();
        janela.setVisible(true);
    }
}
