package taskFinal2Bimestre;

import java.awt.Image;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InsightsRecomendacoesFrame extends JFrame {
    private SistemaFinanceiro sistema;

    public InsightsRecomendacoesFrame(SistemaFinanceiro sistema) {
        this.sistema = sistema;

        setTitle("Insights e Recomendações");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon originalIcon = new ImageIcon(
				"D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\img\\iconInsight.png");
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

        String[] colunas = {"Insight", "Sugestão"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        for (Insight i : sistema.getInsights()) {
            Object[] linha = {i.getMensagem(), i.getSugestao()};
            modelo.addRow(linha);
        }

        JTable tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll);

        setVisible(true);
    }
}

