package jFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercicio09 extends JFrame 
{

    private JTextArea areaTexto;

    public Exercicio09() 
    {
        setTitle("Editor de Texto");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

   
        areaTexto = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaTexto);
        add(scroll, BorderLayout.CENTER);

   
        JMenuBar barraMenu = new JMenuBar();
        JMenu menuArquivo = new JMenu("Arquivo");

        JMenuItem itemNovo = new JMenuItem("Novo");
        itemNovo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        itemNovo.addActionListener(e -> areaTexto.setText(""));

        JMenuItem itemSalvar = new JMenuItem("Salvar");
        itemSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        itemSalvar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Texto salvo com sucesso!"));

        JMenuItem itemSair = new JMenuItem("Sair");
        itemSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
        itemSair.addActionListener(e -> System.exit(0));

        menuArquivo.add(itemNovo);
        menuArquivo.add(itemSalvar);
        menuArquivo.addSeparator();
        menuArquivo.add(itemSair);
        barraMenu.add(menuArquivo);

        setJMenuBar(barraMenu);
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(() -> new Exercicio09().setVisible(true));
    }
}

