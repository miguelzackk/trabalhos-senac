package taskFinal2Bimestre;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RelatorioGastosFrame extends JFrame {
    private SistemaFinanceiro sistema;

    public RelatorioGastosFrame(SistemaFinanceiro sistema) {
        this.sistema = sistema;

        setTitle("Relatório de Gastos");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

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
