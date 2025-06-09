package taskFinal2Bimestre;

import javax.swing.*;
import java.awt.*;

public class CadastroCategoriaFrame extends JFrame {
    private SistemaFinanceiro sistema;

    public CadastroCategoriaFrame(SistemaFinanceiro sistema) {
        this.sistema = sistema;

        setTitle("Cadastro de Categoria");
        setSize(350, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(Color.WHITE);

        // Painel do formulário com GridBagLayout
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label Nome
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(nomeLabel, gbc);

        // Campo Nome
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        JTextField nomeField = new JTextField();
        nomeField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        nomeField.setPreferredSize(new Dimension(200, 25));
        formPanel.add(nomeField, gbc);

        // Label Limite
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        JLabel limiteLabel = new JLabel("Limite:");
        limiteLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(limiteLabel, gbc);

        // Campo Limite
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        JTextField limiteField = new JTextField();
        limiteField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        limiteField.setPreferredSize(new Dimension(200, 25));
        formPanel.add(limiteField, gbc);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Botão Salvar com cor verde (semelhante aos botões de editar)
        JButton salvarBtn = new JButton("Salvar");
        salvarBtn.setBackground(new Color(0, 153, 76));
        salvarBtn.setForeground(Color.WHITE);
        salvarBtn.setFocusPainted(false);
        salvarBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        salvarBtn.setPreferredSize(new Dimension(100, 30));
        salvarBtn.addActionListener(e -> {
            try {
                String nome = nomeField.getText().trim();
                double limite = Double.parseDouble(limiteField.getText().trim());

                if (nome.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "O nome da categoria não pode estar vazio.");
                    return;
                }

                Categoria categoria = new Categoria(nome, limite);
                sistema.adicionarCategoria(categoria);

                JOptionPane.showMessageDialog(null, "Categoria adicionada com sucesso!");
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Digite um valor numérico válido para o limite.");
            }
        });

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Color.WHITE);
        btnPanel.add(salvarBtn);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);

        // Imagem redimensionada e centralizada acima do botão
        ImageIcon originalIcon = new ImageIcon(
                "D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\img\\iconCategoria.png");
        Image img = originalIcon.getImage();
        int maxW = 150, maxH = 100;
        double scale = Math.min((double) maxW / originalIcon.getIconWidth(),
                (double) maxH / originalIcon.getIconHeight());
        Image scaledImg = img.getScaledInstance((int) (originalIcon.getIconWidth() * scale),
                (int) (originalIcon.getIconHeight() * scale), Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImg));
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.WHITE);
        imagePanel.add(imageLabel);

        mainPanel.add(imagePanel, BorderLayout.NORTH);

        add(mainPanel);
        setVisible(true);
    }
}
