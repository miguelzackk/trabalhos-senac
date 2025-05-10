package jframee;

import javax.swing.*;

public class Exercicio03 extends JFrame {

    public Exercicio03() {
        setTitle("Exibindo Imagem");
        setSize(800, 600); // Tamanho mais comum para testes
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // Layout manual (posição livre)

        // Carrega a imagem
        ImageIcon imagem = new ImageIcon("src/img/1.png");

        // Cria o rótulo que vai mostrar a imagem
        JLabel imagemLabel = new JLabel(imagem);
        imagemLabel.setBounds(50, 50, imagem.getIconWidth(), imagem.getIconHeight());
        add(imagemLabel);
    }

    public static void main(String[] args) {
        Exercicio03 janela = new Exercicio03();
        janela.setVisible(true); // Exibe a janela
    }
}
