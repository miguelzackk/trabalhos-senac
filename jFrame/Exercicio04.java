package jFrame;

import javax.swing.*;
import java.awt.event.*;

public class Exercicio04 extends JFrame {

    public Exercicio04() {
        setTitle("Menu Exemplo");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

      
        JMenuBar menuBar = new JMenuBar();


        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem novoItem = new JMenuItem("Novo");
        JMenuItem sairItem = new JMenuItem("Sair");


        novoItem.addActionListener(e -> {
            JFrame novaJanela = new JFrame("Nova Janela");
            novaJanela.setSize(300, 200);
            novaJanela.setLocationRelativeTo(null);
            novaJanela.setVisible(true);
        });


        sairItem.addActionListener(e -> System.exit(0));

        menuArquivo.add(novoItem);
        menuArquivo.add(sairItem);

 
        JMenu menuAjuda = new JMenu("Ajuda");
        JMenuItem sobreItem = new JMenuItem("Sobre");

       
        sobreItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                "Autor: Miguel\nProjeto: Menu Simples em Java\nAno: 2025",
                "Sobre", JOptionPane.INFORMATION_MESSAGE);
        });

        menuAjuda.add(sobreItem);

       
        menuBar.add(menuArquivo);
        menuBar.add(menuAjuda);

   
        setJMenuBar(menuBar);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Exercicio04().setVisible(true);
        });
    }
}

