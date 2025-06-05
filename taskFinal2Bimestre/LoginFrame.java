package taskFinal2Bimestre;

import java.awt.Image;

import javax.swing.*;

public class LoginFrame extends JFrame {
    public LoginFrame(SistemaFinanceiro sistema) {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon iconOriginal = new ImageIcon("D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\img\\1.png");
        Image img = iconOriginal.getImage();
        Image imgRedimensionada = img.getScaledInstance(120, 60, Image.SCALE_SMOOTH);
        ImageIcon iconRedimensionado = new ImageIcon(imgRedimensionada);

        JLabel imageLabel = new JLabel(iconRedimensionado);
        imageLabel.setBounds(10, 150, 120, 60); 
        add(imageLabel);


        JLabel userLabel = new JLabel("Usuário:");
        userLabel.setBounds(10, 10, 80, 25);
        add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(100, 10, 160, 25);
        add(userField);

        JLabel passLabel = new JLabel("Senha:");
        passLabel.setBounds(10, 40, 80, 25);
        add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(100, 40, 160, 25);
        add(passField);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(100, 80, 80, 25);
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
