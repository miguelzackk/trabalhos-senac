package taskFinal2Bimestre;

import java.awt.Image;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RelatorioGastosFrame extends JFrame {
    private SistemaFinanceiro sistema;

    public RelatorioGastosFrame(SistemaFinanceiro sistema) {
        this.sistema = sistema;

        setTitle("Relatório de Gastos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        ImageIcon originalIcon = new ImageIcon(
				"D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\img\\iconRelatorio.png");
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

        String[] colunas = {"Categoria", "Limite", "Gasto Real", "Status"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        for (Categoria c : sistema.getCategorias()) {
            double gasto = sistema.getDespesas().stream()
                    .filter(d -> d.getCategoria().equals(c))
                    .mapToDouble(Despesa::getValor).sum();

            String status = (gasto > c.getLimite()) ? "Excedido" : "OK";

            Object[] linha = {c.getNome(), c.getLimite(), gasto, status};
            modelo.addRow(linha);
        }

        JTable tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(20, 20, 450, 200);
        add(scroll);

        setVisible(true);
    }
}
