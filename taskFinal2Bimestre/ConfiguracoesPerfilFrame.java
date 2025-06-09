package taskFinal2Bimestre;

import javax.swing.*;
import java.awt.*;

public class ConfiguracoesPerfilFrame extends JFrame {
    public ConfiguracoesPerfilFrame() {
        setTitle("Configurações de Perfil");
        setSize(350, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(Color.WHITE);

        // Imagem no topo centralizada
        ImageIcon originalIcon = new ImageIcon(
                "D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\img\\iconPerfil.png");
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

        // Painel formulário
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Nome
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(nomeLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        JTextField nomeField = new JTextField();
        nomeField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        nomeField.setPreferredSize(new Dimension(200, 25));
        formPanel.add(nomeField, gbc);

        // Email
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        formPanel.add(emailLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1.0;
        JTextField emailField = new JTextField();
        emailField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        emailField.setPreferredSize(new Dimension(200, 25));
        formPanel.add(emailField, gbc);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Botão Salvar verde
        JButton salvarBtn = new JButton("Salvar");
        salvarBtn.setBackground(new Color(0, 153, 76));
        salvarBtn.setForeground(Color.WHITE);
        salvarBtn.setFocusPainted(false);
        salvarBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        salvarBtn.setPreferredSize(new Dimension(100, 30));

        salvarBtn.addActionListener(e -> {
            // Aqui você pode adicionar a lógica para salvar as configurações
            JOptionPane.showMessageDialog(this, "Perfil atualizado!");
            dispose();
        });

        JPanel btnPanel = new JPanel();
        btnPanel.setBackground(Color.WHITE);
        btnPanel.add(salvarBtn);
        mainPanel.add(btnPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }
}
