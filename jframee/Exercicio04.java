package jframee;

import javax.swing.*;
import java.awt.event.*;

public class Exercicio04 extends JFrame {

    public Exercicio04() {
        setTitle("Exemplo de Menu");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela

        // Criando a barra de menu
        JMenuBar barraDeMenu = new JMenuBar();

        // Menu "Arquivo"
        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem itemNovo = new JMenuItem("Novo");
        JMenuItem itemSair = new JMenuItem("Sair");

        // Ação do item "Novo"
        itemNovo.addActionListener(e -> {
            JFrame novaJanela = new JFrame("Nova Janela");
            novaJanela.setSize(300, 200);
            novaJanela.setLocationRelativeTo(null);
            novaJanela.setVisible(true);
        });

        // Ação do item "Sair"
        itemSair.addActionListener(e -> System.exit(0));

        // Adicionando itens ao menu "Arquivo"
        menuArquivo.add(itemNovo);
        menuArquivo.add(itemSair);

        // Menu "Ajuda"
        JMenu menuAjuda = new JMenu("Ajuda");
        JMenuItem itemSobre = new JMenuItem("Sobre");

        // Ação do item "Sobre"
        itemSobre.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                "Autor: Vivyane\nProjeto: Menu Básico em Java",
                "Sobre", JOptionPane.INFORMATION_MESSAGE);
        });

        // Adicionando item ao menu "Ajuda"
        menuAjuda.add(itemSobre);

        // Adicionando menus à barra de menu
        barraDeMenu.add(menuArquivo);
        barraDeMenu.add(menuAjuda);

        // Definindo a barra de menu na janela
        setJMenuBar(barraDeMenu);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Exercicio04().setVisible(true); // Cria e mostra a janela
        });
    }
}
