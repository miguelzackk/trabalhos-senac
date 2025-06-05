package taskFinal2Bimestre;

import javax.swing.*;

public class CadastroUsuarioFrame extends JFrame {
    public CadastroUsuarioFrame() {
        setTitle("Cadastro de Usuário");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        // Adicionando uma imagem obrigatória no JFrame
        ImageIcon icon = new ImageIcon("D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\iconDespesas"); // Caminho da imagem
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(10, 130, 100, 50); // Ajuste o tamanho e posição conforme necessário
        add(imageLabel);
        
        JLabel userLabel = new JLabel("Usuário:");
        userLabel.setBounds(10, 20, 80, 25);
        add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(100, 20, 160, 25);
        add(userField);

        JLabel passLabel = new JLabel("Senha:");
        passLabel.setBounds(10, 60, 80, 25);
        add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(100, 60, 160, 25);
        add(passField);

        JButton salvarBtn = new JButton("Salvar");
        salvarBtn.setBounds(100, 100, 80, 25);
        add(salvarBtn);

        salvarBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            dispose();
        });

        setVisible(true);
    }
}
