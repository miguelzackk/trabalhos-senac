package taskFinal2Bimestre;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    public LoginFrame(SistemaFinanceiro sistema) {
        setTitle("Login");
        setSize(350, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // centralizar na tela

        // Painel principal com padding
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(245, 245, 250));

        // Painel do formulário
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(245, 245, 250));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel userLabel = new JLabel("Usuário:");
        userLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(userLabel, gbc);

        JTextField userField = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 0;
        formPanel.add(userField, gbc);

        JLabel passLabel = new JLabel("Senha:");
        passLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(passLabel, gbc);

        JPasswordField passField = new JPasswordField(15);
        gbc.gridx = 1; gbc.gridy = 1;
        formPanel.add(passField, gbc);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBackground(new Color(100, 149, 237));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFocusPainted(false);
        loginBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(loginBtn, gbc);

        mainPanel.add(formPanel, BorderLayout.CENTER);

        // Imagem no topo
        ImageIcon originalIcon = new ImageIcon(
            "D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\img\\iconLogin.jpg");
        Image img = originalIcon.getImage();
        int maxW = 150, maxH = 100;
        double scale = Math.min((double) maxW / originalIcon.getIconWidth(), (double) maxH / originalIcon.getIconHeight());
        Image scaledImg = img.getScaledInstance((int)(originalIcon.getIconWidth()*scale), (int)(originalIcon.getIconHeight()*scale), Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImg));
        imageLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(new Color(245, 245, 250));
        imagePanel.add(imageLabel);

        mainPanel.add(imagePanel, BorderLayout.NORTH);

        add(mainPanel);

        // Ação do botão login
        loginBtn.addActionListener(e -> {
            String usuario = userField.getText();
            String senha = new String(passField.getPassword());

            if (usuario.equals("123") && senha.equals("123")) {
                new DashboardFrame(sistema);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}
