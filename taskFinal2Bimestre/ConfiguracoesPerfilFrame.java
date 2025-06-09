package taskFinal2Bimestre;

import java.awt.Image;

import javax.swing.*;

public class ConfiguracoesPerfilFrame extends JFrame {
    public ConfiguracoesPerfilFrame() {
        setTitle("Configurações de Perfil");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        // Adicionando uma imagem obrigatória no JFrame
        ImageIcon originalIcon = new ImageIcon(
				"D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\img\\iconPerfil.png");
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
