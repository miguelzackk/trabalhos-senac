	package taskFinal2Bimestre;

	import java.awt.Image;

import javax.swing.*;
	import javax.swing.table.DefaultTableModel;

	public class ListagemOrcamentoFrame extends JFrame {
	    private SistemaFinanceiro sistema;

	    public ListagemOrcamentoFrame(SistemaFinanceiro sistema) {
	        this.sistema = sistema;

	        setTitle("Listagem de Orçamentos");
	        setSize(400, 600);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setLayout(null);
	        // Adicionando uma imagem obrigatória no JFrame
	        ImageIcon originalIcon = new ImageIcon("D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\img\\iconOrcamento.png");
	        Image img = originalIcon.getImage();

	        int imgW = originalIcon.getIconWidth();
	        int imgH = originalIcon.getIconHeight();

	        int maxW = 150;
	        int maxH = 100;

	        double scale = Math.min((double) maxW / imgW, (double) maxH / imgH);
	        int newW = (int) (imgW * scale);
	        int newH = (int) (imgH * scale);

	        Image scaledImg = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
	        ImageIcon scaledIcon = new ImageIcon(scaledImg);

	        int x = (600 - newW) / 2;  // centraliza horizontalmente com tamanho fixo do JFrame
	        int y = 600 - newH - 50;   // desce para quase o final da janela

	        JLabel imageLabel = new JLabel(scaledIcon);
	        imageLabel.setBounds(x, y, newW, newH);
	        add(imageLabel);

	        String[] colunas = {"Categoria", "Limite"};
	        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

	        for (Categoria c : sistema.getCategorias()) {
	            Object[] linha = {c.getNome(), c.getLimite()};
	            modelo.addRow(linha);
	        }

	        JTable tabela = new JTable(modelo);
	        JScrollPane scroll = new JScrollPane(tabela);
	        scroll.setBounds(20, 20, 350, 200);
	        add(scroll);

	        setVisible(true);
	    }
	}


