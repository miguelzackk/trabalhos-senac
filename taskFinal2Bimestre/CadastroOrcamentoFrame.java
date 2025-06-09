package taskFinal2Bimestre;

import javax.swing.*;
import java.awt.*;

public class CadastroOrcamentoFrame extends JFrame {
    private SistemaFinanceiro sistema;

    public CadastroOrcamentoFrame(SistemaFinanceiro sistema) {
        this.sistema = sistema;

        setTitle("Cadastro de Orçamento");
        setSize(350, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(Color.WHITE);

        // Painel formulário com GridBagLayout
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label Categoria
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        JLabel categoriaLabel = new JLabel("Categoria:");
        categoriaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(categoriaLabel, gbc);

        // ComboBox Categoria
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        JComboBox<String> categoriaBox = new JComboBox<>();
        for (Categoria c : sistema.getCategorias()) {
            categoriaBox.addItem(c.getNome());
        }
        categoriaBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        categoriaBox.setPreferredSize(new Dimension(200, 25));
        formPanel.add(categoriaBox, gbc);

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

        // Botão salvar verde
        JButton salvarBtn = new JButton("Salvar");
        salvarBtn.setBackground(new Color(0, 153, 76));
        salvarBtn.setForeground(Color.WHITE);
        salvarBtn.setFocusPainted(false);
        salvarBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        salvarBtn.setPreferredSize(new Dimension(100, 30));

        salvarBtn.addActionListener(e -> {
            try {
                String categoriaNome = (String) categoriaBox.getSelectedItem();
                double limite = Double.parseDouble(limiteField.getText().trim());

                Categoria categoria = sistema.getCategorias().stream()
                        .filter(c -> c.getNome().equals(categoriaNome))
                        .findFirst().orElse(null);

                if (categoria != null) {
                    categoria.setLimite(limite);
                    JOptionPane.showMessageDialog(this, "Limite atualizado!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Categoria inválida.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Digite um valor numérico válido para o limite.");
            }
        });

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Color.WHITE);
        btnPanel.add(salvarBtn);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);

        // Imagem redimensionada no topo centralizada
        ImageIcon originalIcon = new ImageIcon(
                "D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\img\\iconOrcamento.png");
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
