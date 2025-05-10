package jframee;

import javax.swing.*;

public class Exercicio08 extends JFrame {

    private JLabel caixaImagem;
    private JButton botaoVoltar, botaoAvancar;
    private String[] imagens = {
        "src/img/3.jpeg",
        "src/img/2.jpeg",
        "src/img/1.png"
    };
    private int indice = 0;

    public Exercicio08() {
        setTitle("Galeria");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null); // Centraliza

        // Label para mostrar a imagem
        caixaImagem = new JLabel();
        caixaImagem.setBounds(50, 20, 300, 180);
        caixaImagem.setHorizontalAlignment(JLabel.CENTER);
        mostrarImagem();

        // Botão para imagem anterior
        botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(50, 220, 120, 30);
        botaoVoltar.addActionListener(e -> {
            indice = (indice - 1 + imagens.length) % imagens.length;
            mostrarImagem();
        });

        // Botão para próxima imagem
        botaoAvancar = new JButton("Avançar");
        botaoAvancar.setBounds(230, 220, 120, 30);
        botaoAvancar.addActionListener(e -> {
            indice = (indice + 1) % imagens.length;
            mostrarImagem();
        });

        add(caixaImagem);
        add(botaoVoltar);
        add(botaoAvancar);
    }

    private void mostrarImagem() {
        caixaImagem.setIcon(new ImageIcon(imagens[indice]));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Exercicio08().setVisible(true));
    }
}
