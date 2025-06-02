package taskFinal2Bimestre;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class ListagemDespesaFrame extends JFrame {
    private SistemaFinanceiro sistema;
    private DefaultTableModel modelo;
    private JTable tabela;

    public ListagemDespesaFrame(SistemaFinanceiro sistema) {
        this.sistema = sistema;

        setTitle("Listagem de Despesas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        String[] colunas = {"Categoria", "Valor", "Data"};
        modelo = new DefaultTableModel(colunas, 0);
        carregarDados();

        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);
        scroll.setBounds(20, 20, 450, 200);
        add(scroll);

        JButton editarBtn = new JButton("Editar");
        editarBtn.setBounds(100, 250, 100, 30);
        add(editarBtn);

        JButton excluirBtn = new JButton("Excluir");
        excluirBtn.setBounds(250, 250, 100, 30);
        add(excluirBtn);

        editarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = tabela.getSelectedRow();
                if (row >= 0) {
                    String nomeCategoria = (String) modelo.getValueAt(row, 0);
                    double valor = (double) modelo.getValueAt(row, 1);

                    Despesa despesa = sistema.getDespesas().stream()
                            .filter(d -> d.getCategoria().getNome().equals(nomeCategoria) && d.getValor() == valor)
                            .findFirst().orElse(null);

                    if (despesa != null) {
                        String novoValor = JOptionPane.showInputDialog("Novo valor:", despesa.getValor());
                        despesa.setValor(Double.parseDouble(novoValor));
                        modelo.setValueAt(Double.parseDouble(novoValor), row, 1);
                    }
                }
            }
        });

        excluirBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = tabela.getSelectedRow();
                if (row >= 0) {
                    String nomeCategoria = (String) modelo.getValueAt(row, 0);
                    double valor = (double) modelo.getValueAt(row, 1);

                    sistema.getDespesas().removeIf(d -> d.getCategoria().getNome().equals(nomeCategoria) && d.getValor() == valor);
                    modelo.removeRow(row);
                }
            }
        });

        setVisible(true);
    }

    private void carregarDados() {
        modelo.setRowCount(0);
        for (Despesa d : sistema.getDespesas()) {
            Object[] linha = {d.getCategoria().getNome(), d.getValor(), d.getData()};
            modelo.addRow(linha);
        }
    }
}

