package taskFinal2Bimestre;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class CadastroDespesaFrame extends JFrame {
    private JComboBox<String> categoriaBox;
    private JTextField valorField;
    private SistemaFinanceiro sistema;

    public CadastroDespesaFrame(SistemaFinanceiro sistema) {
        this.sistema = sistema;

        setTitle("Cadastro de Despesa");
        setSize(350, 400);
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
        categoriaBox = new JComboBox<>();
        for (Categoria cat : sistema.getCategorias()) {
            categoriaBox.addItem(cat.getNome());
        }
        categoriaBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        categoriaBox.setPreferredSize(new Dimension(200, 25));
        formPanel.add(categoriaBox, gbc);

        // Label Valor
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        JLabel valorLabel = new JLabel("Valor:");
        valorLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(valorLabel, gbc);

        // Campo Valor
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        valorField = new JTextField();
        valorField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        valorField.setPreferredSize(new Dimension(200, 25));
        formPanel.add(valorField, gbc);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Botão Salvar verde, com fonte em negrito
        JButton salvarBtn = new JButton("Salvar");
        salvarBtn.setBackground(new Color(0, 153, 76));
        salvarBtn.setForeground(Color.WHITE);
        salvarBtn.setFocusPainted(false);
        salvarBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        salvarBtn.setPreferredSize(new Dimension(100, 30));

        salvarBtn.addActionListener(e -> {
            try {
                String categoriaNome = (String) categoriaBox.getSelectedItem();
                Categoria categoria = sistema.getCategorias().stream()
                        .filter(c -> c.getNome().equals(categoriaNome))
                        .findFirst().orElse(null);

                if (categoria == null) {
                    JOptionPane.showMessageDialog(this, "Categoria inválida.");
                    return;
                }

                double valor = Double.parseDouble(valorField.getText().trim());
                if (valor <= 0) {
                    JOptionPane.showMessageDialog(this, "Digite um valor positivo para a despesa.");
                    return;
                }

                sistema.adicionarDespesa(new Despesa(categoria, valor, new Date()));
                JOptionPane.showMessageDialog(this, "Despesa adicionada com sucesso!");
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Digite um valor numérico válido para o valor.");
            }
        });

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Color.WHITE);
        btnPanel.add(salvarBtn);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);

        // Imagem redimensionada no topo, centralizada
        ImageIcon originalIcon = new ImageIcon(
                "D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\img\\iconDespesas.png");
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
