package taskFinal2Bimestre;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InsightsRecomendacoesFrame extends JFrame {
    private SistemaFinanceiro sistema;

    public InsightsRecomendacoesFrame(SistemaFinanceiro sistema) {
        this.sistema = sistema;

        setTitle("Insights e Recomendações");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

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

