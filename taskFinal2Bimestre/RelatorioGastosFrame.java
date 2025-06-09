package taskFinal2Bimestre;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class RelatorioGastosFrame extends JFrame {
    private SistemaFinanceiro sistema;

    public RelatorioGastosFrame(SistemaFinanceiro sistema) {
        this.sistema = sistema;

        setTitle("Relatório de Gastos");
        setSize(520, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(Color.WHITE);

        // Colunas e modelo da tabela
        String[] colunas = { "Categoria", "Limite", "Gasto Real", "Status" };
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // tabela só leitura
            }
        };

        for (Categoria c : sistema.getCategorias()) {
            double gasto = sistema.getDespesas().stream()
                    .filter(d -> d.getCategoria().equals(c))
                    .mapToDouble(Despesa::getValor)
                    .sum();

            String status = (gasto > c.getLimite()) ? "Excedido" : "OK";

            Object[] linha = { c.getNome(), String.format("R$ %.2f", c.getLimite()), String.format("R$ %.2f", gasto), status };
            modelo.addRow(linha);
        }

        JTable tabela = new JTable(modelo);
        tabela.setFillsViewportHeight(true);
        tabela.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tabela.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tabela.setRowHeight(25);

        // Centralizar texto nas colunas numéricas e status
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tabela.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        tabela.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        tabela.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);

        JScrollPane scroll = new JScrollPane(tabela);
        mainPanel.add(scroll, BorderLayout.CENTER);

        // Imagem redimensionada centralizada abaixo da tabela
        ImageIcon originalIcon = new ImageIcon(
            "D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\img\\iconRelatorio.png");
        Image img = originalIcon.getImage();
        int maxW = 150, maxH = 100;
        double scale = Math.min((double) maxW / originalIcon.getIconWidth(), (double) maxH / originalIcon.getIconHeight());
        Image scaledImg = img.getScaledInstance((int)(originalIcon.getIconWidth()*scale), (int)(originalIcon.getIconHeight()*scale), Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImg));
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.WHITE);
        imagePanel.add(imageLabel);
        mainPanel.add(imagePanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }
}
