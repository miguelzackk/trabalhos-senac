package taskFinal2Bimestre;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {
    public LoginFrame(SistemaFinanceiro sistema) {
        setTitle("Login");
        setSize(300, 400); // Altura aumentada para caber imagem original
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Carregar imagem sem redimensionamento manual
     // Carregar imagem com redimensionamento proporcional
        ImageIcon originalIcon = new ImageIcon("D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\img\\iconLogin.jpg");
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


        JLabel userLabel = new JLabel("Usuário:");
        userLabel.setBounds(10, 10, 80, 25);
        add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(100, 10, 160, 25);
        add(userField);

        JLabel passLabel = new JLabel("Senha:");
        passLabel.setBounds(10, 50, 80, 25);
        add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(100, 50, 160, 25);
        add(passField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(100, 90, 80, 25);
        add(loginBtn);

        loginBtn.addActionListener(e -> {
            String usuario = userField.getText();
            String senha = new String(passField.getPassword());

            if (usuario.equals("123") && senha.equals("123")) {
                new DashboardFrame(sistema);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos.");
            }
        });

        setVisible(true);
    }
}
