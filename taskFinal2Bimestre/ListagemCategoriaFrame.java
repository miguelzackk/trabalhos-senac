package taskFinal2Bimestre;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class ListagemCategoriaFrame extends JFrame {
    private SistemaFinanceiro sistema;
    private DefaultTableModel modelo;
    private JTable tabela;

    public ListagemCategoriaFrame(SistemaFinanceiro sistema) {
        this.sistema = sistema;

        setTitle("Listagem de Categorias");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        String[] colunas = {"Nome", "Limite"};
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
                    String nome = (String) modelo.getValueAt(row, 0);
                    Categoria categoria = sistema.getCategorias().stream()
                            .filter(c -> c.getNome().equals(nome))
                            .findFirst().orElse(null);

                    if (categoria != null) {
                        String novoNome = JOptionPane.showInputDialog("Novo nome:", categoria.getNome());
                        String novoLimite = JOptionPane.showInputDialog("Novo limite:", categoria.getLimite());

                        categoria.setNome(novoNome);
                        categoria.setLimite(Double.parseDouble(novoLimite));

                        modelo.setValueAt(novoNome, row, 0);
                        modelo.setValueAt(novoLimite, row, 1);
                    }
                }
            }
        });

        excluirBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int row = tabela.getSelectedRow();
                if (row >= 0) {
                    String nome = (String) modelo.getValueAt(row, 0);
                    sistema.getCategorias().removeIf(c -> c.getNome().equals(nome));
                    modelo.removeRow(row);
                }
            }
        });

        setVisible(true);
    }

    private void carregarDados() {
        modelo.setRowCount(0);
        for (Categoria c : sistema.getCategorias()) {
            Object[] linha = {c.getNome(), c.getLimite()};
            modelo.addRow(linha);
        }
    }
}

