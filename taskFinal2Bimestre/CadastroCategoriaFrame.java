package taskFinal2Bimestre;

import java.awt.Image;

import javax.swing.*;

public class CadastroCategoriaFrame extends JFrame {
    private SistemaFinanceiro sistema;

    public CadastroCategoriaFrame(SistemaFinanceiro sistema) {
        this.sistema = sistema;
        setTitle("Cadastro de Categoria");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);


        ImageIcon originalIcon = new ImageIcon("D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\img\\iconCategoria.png");
        Image img = originalIcon.getImage();

        // Dimensões originais
        int imgW = originalIcon.getIconWidth();
        int imgH = originalIcon.getIconHeight();

        // Limites máximos
        int maxW = 150;
        int maxH = 100;

        // Escala proporcional
        double scale = Math.min((double) maxW / imgW, (double) maxH / imgH);
        int newW = (int) (imgW * scale);
        int newH = (int) (imgH * scale);

        // Redimensiona imagem
        Image scaledImg = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        // Centralizar horizontalmente
        int x = (getWidth() - newW) / 2;

        // Posicionar imagem
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(x, 240, newW, newH); // Parte inferior
        add(imageLabel);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 10, 80, 25);
        add(nomeLabel);

        JTextField nomeField = new JTextField();
        nomeField.setBounds(100, 10, 160, 25);
        add(nomeField);

        JLabel limiteLabel = new JLabel("Limite:");
        limiteLabel.setBounds(10, 50, 80, 25);
        add(limiteLabel);

        JTextField limiteField = new JTextField();
        limiteField.setBounds(100, 50, 160, 25);
        add(limiteField);

        JButton salvarBtn = new JButton("Salvar");
        salvarBtn.setBounds(100, 100, 80, 25);
        add(salvarBtn);

        salvarBtn.addActionListener(e -> {
            try {
                String nome = nomeField.getText();
                double limite = Double.parseDouble(limiteField.getText());

                Categoria categoria = new Categoria(nome, limite);
                sistema.adicionarCategoria(categoria);

                JOptionPane.showMessageDialog(null, "Categoria adicionada com sucesso!");
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Digite um valor numérico válido para o limite.");
            }
        });

        setVisible(true);
    }
}
