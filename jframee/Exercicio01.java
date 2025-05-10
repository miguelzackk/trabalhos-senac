package jframee;

import javax.swing.JFrame;

public class Exercicio01 extends JFrame {

    public Exercicio01() {
        setTitle("Minha Janela");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Exercicio01();
    }
}
