package taskFinal2Bimestre;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListagemOrcamentoFrame extends JFrame {
    private SistemaFinanceiro sistema;

    public ListagemOrcamentoFrame(SistemaFinanceiro sistema) {
        this.sistema = sistema;

        setTitle("Listagem de Orçamentos");
        setSize(420, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(Color.WHITE);

        String[] colunas = { "Categoria", "Limite" };
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (Categoria c : sistema.getCategorias()) {
            modelo.addRow(new Object[]{c.getNome(), String.format("R$ %.2f", c.getLimite())});
        }

        JTable tabela = new JTable(modelo);
        tabela.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tabela.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tabela.setRowHeight(25);
        JScrollPane scroll = new JScrollPane(tabela);

        mainPanel.add(scroll, BorderLayout.CENTER);

        // Imagem no rodapé
        ImageIcon originalIcon = new ImageIcon(
            "D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\img\\iconOrcamento.png");
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
