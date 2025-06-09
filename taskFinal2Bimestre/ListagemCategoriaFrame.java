package taskFinal2Bimestre;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ListagemCategoriaFrame extends JFrame {
    private SistemaFinanceiro sistema;
    private DefaultTableModel modelo;
    private JTable tabela;

    public ListagemCategoriaFrame(SistemaFinanceiro sistema) {
        this.sistema = sistema;

        setTitle("Listagem de Categorias");
        setSize(500, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(Color.WHITE);

        // Colunas e modelo
        String[] colunas = { "Nome", "Limite" };
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
        mainPanel.add(scroll, BorderLayout.NORTH);

        // Imagem centralizada abaixo da tabela
        ImageIcon originalIcon = new ImageIcon("D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\img\\iconCategoria.png");
        Image img = originalIcon.getImage();
        int maxW = 150, maxH = 100;
        double scale = Math.min((double) maxW / originalIcon.getIconWidth(), (double) maxH / originalIcon.getIconHeight());
        Image scaledImg = img.getScaledInstance((int)(originalIcon.getIconWidth()*scale), (int)(originalIcon.getIconHeight()*scale), Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImg));
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.WHITE);
        imagePanel.add(imageLabel);
        mainPanel.add(imagePanel, BorderLayout.CENTER);

        // Painel de botões abaixo da imagem
        JPanel botoesPanel = new JPanel();
        botoesPanel.setBackground(Color.WHITE);
        botoesPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        JButton editarBtn = new JButton("Editar");
        JButton excluirBtn = new JButton("Excluir");

        // Botão editar verde (igual despesas)
        editarBtn.setBackground(new Color(0, 153, 51)); // verde escuro
        editarBtn.setForeground(Color.WHITE);
        editarBtn.setFocusPainted(false);
        editarBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));

        // Botão excluir vermelho
        excluirBtn.setBackground(new Color(220, 20, 60)); // vermelho
        excluirBtn.setForeground(Color.WHITE);
        excluirBtn.setFocusPainted(false);
        excluirBtn.setFont(new Font("Segoe UI", Font.BOLD, 14));

        botoesPanel.add(editarBtn);
        botoesPanel.add(excluirBtn);

        mainPanel.add(botoesPanel, BorderLayout.SOUTH);

        // Ações dos botões
        editarBtn.addActionListener(e -> {
            int row = tabela.getSelectedRow();
            if (row >= 0) {
                String nome = (String) modelo.getValueAt(row, 0);
                Categoria categoria = sistema.getCategorias().stream()
                        .filter(c -> c.getNome().equals(nome))
                        .findFirst().orElse(null);

                if (categoria != null) {
                    String novoNome = JOptionPane.showInputDialog(this, "Novo nome:", categoria.getNome());
                    if (novoNome != null && !novoNome.trim().isEmpty()) {
                        String novoLimiteStr = JOptionPane.showInputDialog(this, "Novo limite:", categoria.getLimite());
                        try {
                            double novoLimite = Double.parseDouble(novoLimiteStr);
                            categoria.setNome(novoNome);
                            categoria.setLimite(novoLimite);

                            modelo.setValueAt(novoNome, row, 0);
                            modelo.setValueAt(String.format("R$ %.2f", novoLimite), row, 1);
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(this, "Limite inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma categoria para editar.", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        });

        excluirBtn.addActionListener(e -> {
            int row = tabela.getSelectedRow();
            if (row >= 0) {
                String nome = (String) modelo.getValueAt(row, 0);
                int confirm = JOptionPane.showConfirmDialog(this, "Confirma exclusão da categoria \"" + nome + "\"?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    sistema.getCategorias().removeIf(c -> c.getNome().equals(nome));
                    modelo.removeRow(row);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione uma categoria para excluir.", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        });

        add(mainPanel);
        setVisible(true);
    }

    private void carregarDados() {
        modelo.setRowCount(0);
        for (Categoria c : sistema.getCategorias()) {
            modelo.addRow(new Object[] { c.getNome(), String.format("R$ %.2f", c.getLimite()) });
        }
    }
}
