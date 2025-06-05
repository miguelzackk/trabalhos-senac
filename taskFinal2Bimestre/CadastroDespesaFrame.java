package taskFinal2Bimestre;

import javax.swing.*;
import java.awt.event.*;
import java.util.Date;

public class CadastroDespesaFrame extends JFrame {
    private JComboBox<String> categoriaBox;
    private JTextField valorField;
    private SistemaFinanceiro sistema;

    public CadastroDespesaFrame(SistemaFinanceiro sistema) {
        this.sistema = sistema;
        setTitle("Cadastro de Despesa");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        ImageIcon icon = new ImageIcon(new ImageIcon("D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\img\\iconDespesas.png")
                .getImage().getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(10, 200, 100, 50);
        add(imageLabel);

        JLabel categoriaLabel = new JLabel("Categoria:");
        categoriaLabel.setBounds(10, 10, 80, 25);
        add(categoriaLabel);

        categoriaBox = new JComboBox<>();
        for (Categoria cat : sistema.getCategorias()) {
            categoriaBox.addItem(cat.getNome());
        }
        categoriaBox.setBounds(100, 10, 160, 25);
        add(categoriaBox);

        JLabel valorLabel = new JLabel("Valor:");
        valorLabel.setBounds(10, 50, 80, 25);
        add(valorLabel);

        valorField = new JTextField();
        valorField.setBounds(100, 50, 160, 25);
        add(valorField);

        JButton salvarBtn = new JButton("Salvar");
        salvarBtn.setBounds(100, 90, 80, 25);
        add(salvarBtn);

        salvarBtn.addActionListener(e -> {
            String categoriaNome = (String) categoriaBox.getSelectedItem();
            Categoria categoria = sistema.getCategorias().stream()
                    .filter(c -> c.getNome().equals(categoriaNome))
                    .findFirst().orElse(null);

            double valor = Double.parseDouble(valorField.getText());
            sistema.adicionarDespesa(new Despesa(categoria, valor, new Date()));

            JOptionPane.showMessageDialog(null, "Despesa adicionada com sucesso!");
            dispose();
        });

        setVisible(true);
    }
}
