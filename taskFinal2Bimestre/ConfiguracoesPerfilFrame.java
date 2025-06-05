package taskFinal2Bimestre;

import javax.swing.*;

public class ConfiguracoesPerfilFrame extends JFrame {
    public ConfiguracoesPerfilFrame() {
        setTitle("Configurações de Perfil");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        // Adicionando uma imagem obrigatória no JFrame
        ImageIcon icon = new ImageIcon(new ImageIcon("D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\img\\iconPerfil.png")
                .getImage().getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(10, 200, 100, 50);
        add(imageLabel);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 20, 80, 25);
        add(nomeLabel);

        JTextField nomeField = new JTextField();
        nomeField.setBounds(100, 20, 160, 25);
        add(nomeField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 60, 80, 25);
        add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds(100, 60, 160, 25);
        add(emailField);

        JButton salvarBtn = new JButton("Salvar");
        salvarBtn.setBounds(100, 100, 80, 25);
        add(salvarBtn);

        salvarBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Perfil atualizado!");
            dispose();
        });

        setVisible(true);
    }
}
