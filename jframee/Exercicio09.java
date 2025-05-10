package jframee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Exercicio09 extends JFrame {

    private JTextArea caixaTexto;

    public Exercicio09() {
        setTitle("Editor de Texto");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Área de texto com rolagem
        caixaTexto = new JTextArea();
        JScrollPane rolagem = new JScrollPane(caixaTexto);
        add(rolagem, BorderLayout.CENTER);

        // Barra de menu
        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Arquivo");

        // Item Novo
        JMenuItem botaoNovo = new JMenuItem("Novo");
        botaoNovo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
        botaoNovo.addActionListener(e -> caixaTexto.setText(""));

        // Item Salvar
        JMenuItem botaoSalvar = new JMenuItem("Salvar");
        botaoSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        botaoSalvar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Texto salvo com sucesso!"));

        // Item Sair
        JMenuItem botaoSair = new JMenuItem("Sair");
        botaoSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));
        botaoSair.addActionListener(e -> System.exit(0));

        // Monta o menu
        menu.add(botaoNovo);
        menu.add(botaoSalvar);
        menu.addSeparator();
        menu.add(botaoSair);
        barra.add(menu);

        setJMenuBar(barra);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Exercicio09().setVisible(true));
    }
}
