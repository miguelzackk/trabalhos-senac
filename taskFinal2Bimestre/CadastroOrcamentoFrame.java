package taskFinal2Bimestre;

import java.awt.Image;

import javax.swing.*;

public class CadastroOrcamentoFrame extends JFrame {
	private SistemaFinanceiro sistema;

	public CadastroOrcamentoFrame(SistemaFinanceiro sistema) {
		this.sistema = sistema;
		setTitle("Cadastro de Orçamento");
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);

		ImageIcon originalIcon = new ImageIcon(
				"D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\img\\iconOrcamento.png");
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

		JLabel categoriaLabel = new JLabel("Categoria:");
		categoriaLabel.setBounds(10, 20, 80, 25);
		add(categoriaLabel);

		JComboBox<String> categoriaBox = new JComboBox<>();
		for (Categoria c : sistema.getCategorias()) {
			categoriaBox.addItem(c.getNome());
		}
		categoriaBox.setBounds(100, 20, 160, 25);
		add(categoriaBox);

		JLabel limiteLabel = new JLabel("Limite:");
		limiteLabel.setBounds(10, 60, 80, 25);
		add(limiteLabel);

		JTextField limiteField = new JTextField();
		limiteField.setBounds(100, 60, 160, 25);
		add(limiteField);

		JButton salvarBtn = new JButton("Salvar");
		salvarBtn.setBounds(100, 100, 80, 25);
		add(salvarBtn);

		salvarBtn.addActionListener(e -> {
			String categoriaNome = (String) categoriaBox.getSelectedItem();
			double limite = Double.parseDouble(limiteField.getText());

			Categoria categoria = sistema.getCategorias().stream().filter(c -> c.getNome().equals(categoriaNome))
					.findFirst().orElse(null);

			if (categoria != null) {
				categoria.setLimite(limite);
				JOptionPane.showMessageDialog(null, "Limite atualizado!");
				dispose();
			}
		});

		setVisible(true);
	}
}
