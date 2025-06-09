package taskFinal2Bimestre;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class ListagemDespesaFrame extends JFrame {
    private SistemaFinanceiro sistema;
    private DefaultTableModel modelo;
    private JTable tabela;

    public ListagemDespesaFrame(SistemaFinanceiro sistema) {
        this.sistema = sistema;

        setTitle("Listagem de Despesas");
        setSize(520, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(Color.WHITE);

        String[] colunas = { "Categoria", "Valor", "Data" };
        modelo = new DefaultTableModel(colunas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        carregarDados();

        tabela = new JTable(modelo);
        tabela.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tabela.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tabela.setRowHeight(25);
        JScrollPane scroll = new JScrollPane(tabela);

        mainPanel.add(scroll, BorderLayout.CENTER);

        // Painel dos botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setBackground(Color.WHITE);

        JButton editarBtn = new JButton("Editar");
        editarBtn.setBackground(new Color(60, 179, 113));
        editarBtn.setForeground(Color.WHITE);
        editarBtn.setFocusPainted(false);
        editarBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JButton excluirBtn = new JButton("Excluir");
        excluirBtn.setBackground(new Color(220, 20, 60));
        excluirBtn.setForeground(Color.WHITE);
        excluirBtn.setFocusPainted(false);
        excluirBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));

        buttonPanel.add(editarBtn);
        buttonPanel.add(excluirBtn);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Imagem no rodapé, acima dos botões
        ImageIcon originalIcon = new ImageIcon(
            "D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\img\\iconDespesas.png");
        Image img = originalIcon.getImage();
        int maxW = 150, maxH = 100;
        double scale = Math.min((double) maxW / originalIcon.getIconWidth(), (double) maxH / originalIcon.getIconHeight());
        Image scaledImg = img.getScaledInstance((int)(originalIcon.getIconWidth()*scale), (int)(originalIcon.getIconHeight()*scale), Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImg));
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.WHITE);
        imagePanel.add(imageLabel);

        // Criar painel que contém a imagem e os botões para alinhar verticalmente
        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.setBackground(Color.WHITE);
        southPanel.add(imagePanel, BorderLayout.NORTH);
        southPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainPanel.add(southPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Ações dos botões
        editarBtn.addActionListener(e -> {
            int row = tabela.getSelectedRow();
            if (row >= 0) {
                String nomeCategoria = (String) modelo.getValueAt(row, 0);
                double valor = (double) modelo.getValueAt(row, 1);

                Despesa despesa = sistema.getDespesas().stream()
                        .filter(d -> d.getCategoria().getNome().equals(nomeCategoria) && d.getValor() == valor)
                        .findFirst().orElse(null);

                if (despesa != null) {
                    String novoValor = JOptionPane.showInputDialog(this, "Novo valor:", despesa.getValor());
                    try {
                        double val = Double.parseDouble(novoValor);
                        despesa.setValor(val);
                        modelo.setValueAt(val, row, 1);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Valor inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma despesa para editar.", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        });

        excluirBtn.addActionListener(e -> {
            int row = tabela.getSelectedRow();
            if (row >= 0) {
                String nomeCategoria = (String) modelo.getValueAt(row, 0);
                double valor = (double) modelo.getValueAt(row, 1);

                sistema.getDespesas()
                        .removeIf(d -> d.getCategoria().getNome().equals(nomeCategoria) && d.getValor() == valor);
                modelo.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma despesa para excluir.", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        });

        setVisible(true);
    }

    private void carregarDados() {
        modelo.setRowCount(0);
        for (Despesa d : sistema.getDespesas()) {
            modelo.addRow(new Object[]{d.getCategoria().getNome(), d.getValor(), d.getData()});
        }
    }
}
