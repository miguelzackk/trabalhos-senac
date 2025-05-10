package jFrame;

import javax.swing.*;
import java.awt.event.*;

public class Exercicio08 extends JFrame 
{

    private JLabel labelImagem;
    private JButton btnAnterior, btnProxima;
    private String[] imagens = 
    	{
        "src/img/download.jpg",
        "src/img/dedofudido.jpg",
        "src/img/291.png"
    };
    private int indiceAtual = 0;

    public Exercicio08() 
    {
        setTitle("Galeria de Imagens");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

       
        labelImagem = new JLabel();
        labelImagem.setBounds(50, 20, 300, 180);
        labelImagem.setHorizontalAlignment(JLabel.CENTER);
        atualizarImagem();

      
        btnAnterior = new JButton("Anterior");
        btnAnterior.setBounds(50, 220, 120, 30);
        btnAnterior.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                indiceAtual = (indiceAtual - 1 + imagens.length) % imagens.length;
                atualizarImagem();
            }
        });

        btnProxima = new JButton("Próxima");
        btnProxima.setBounds(230, 220, 120, 30);
        btnProxima.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                indiceAtual = (indiceAtual + 1) % imagens.length;
                atualizarImagem();
            }
        });

        add(labelImagem);
        add(btnAnterior);
        add(btnProxima);
    }

    private void atualizarImagem() 
    {
        ImageIcon icone = new ImageIcon(imagens[indiceAtual]);
        labelImagem.setIcon(icone);
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> 
        {
            new Exercicio08().setVisible(true);
        });
    }
}

