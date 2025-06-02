package taskFinal2Bimestre;

import javax.swing.*;
import java.awt.event.*;

public class DashboardFrame extends JFrame {
    private SistemaFinanceiro sistema;

    public DashboardFrame(SistemaFinanceiro sistema) {
        this.sistema = sistema;

        setTitle("Dashboard Financeiro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton categoriasBtn = new JButton("Categorias");
        categoriasBtn.setBounds(50, 30, 120, 30);
        add(categoriasBtn);
        categoriasBtn.addActionListener(e -> new ListagemCategoriaFrame(sistema));

        JButton despesasBtn = new JButton("Despesas");
        despesasBtn.setBounds(200, 30, 120, 30);
        add(despesasBtn);
        despesasBtn.addActionListener(e -> new ListagemDespesaFrame(sistema));

        JButton insightsBtn = new JButton("Insights");
        insightsBtn.setBounds(125, 80, 120, 30);
        add(insightsBtn);
        insightsBtn.addActionListener(e -> new InsightsRecomendacoesFrame(sistema));

        setVisible(true);
    }
}

