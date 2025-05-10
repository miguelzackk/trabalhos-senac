package jframee;

import javax.swing.*;
import java.awt.event.*;

public class Exercicio06 extends JFrame {

    public Exercicio06() {
        setTitle("Escolha uma Opção");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null); // Centraliza a janela

        // Título
        JLabel textoTitulo = new JLabel("Selecione uma das opções:");
        textoTitulo.setBounds(100, 10, 250, 30);
        add(textoTitulo);
        // Botões de opção (radio buttons)
        JRadioButton botaoOpcao1 = new JRadioButton("Opção 1");
        botaoOpcao1.setBounds(50, 50, 150, 25);
        JRadioButton botaoOpcao2 = new JRadioButton("Opção 2");
        botaoOpcao2.setBounds(50, 80, 150, 25);
        JRadioButton botaoOpcao3 = new JRadioButton("Opção 3");
        botaoOpcao3.setBounds(50, 110, 150, 25);

        // Agrupando os radio buttons (só um pode ser selecionado)
        ButtonGroup grupoOpcoes = new ButtonGroup();
        grupoOpcoes.add(botaoOpcao1);
        grupoOpcoes.add(botaoOpcao2);
        grupoOpcoes.add(botaoOpcao3);

        // Botão de confirmar
        JButton botaoConfirmar = new JButton("Confirmar");
        botaoConfirmar.setBounds(220, 80, 120, 30);

        // Área de texto para mostrar o resultado
        JTextArea areaResultado = new JTextArea();
        areaResultado.setBounds(50, 160, 290, 70);
        areaResultado.setLineWrap(true);
        areaResultado.setWrapStyleWord(true);
        areaResultado.setEditable(false);

        // Ação ao clicar no botão "Confirmar"
        botaoConfirmar.addActionListener(e -> {
            if (botaoOpcao1.isSelected()) {
                areaResultado.setText("Você selecionou a Opção 1.");
            } else if (botaoOpcao2.isSelected()) {
                areaResultado.setText("Você selecionou a Opção 2.");
            } else if (botaoOpcao3.isSelected()) {
                areaResultado.setText("Você selecionou a Opção 3.");
            } else {
                areaResultado.setText("Por favor, selecione uma opção.");
            }
        });

        // Adicionando os componentes na janela
        add(botaoOpcao1);
        add(botaoOpcao2);
        add(botaoOpcao3);
        add(botaoConfirmar);
        add(areaResultado);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Exercicio06().setVisible(true));
    }
}
