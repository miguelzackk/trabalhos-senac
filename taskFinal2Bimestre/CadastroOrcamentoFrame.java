package taskFinal2Bimestre;

import javax.swing.*;

public class CadastroOrcamentoFrame extends JFrame {
    private SistemaFinanceiro sistema;

    public CadastroOrcamentoFrame(SistemaFinanceiro sistema) {
        this.sistema = sistema;
        setTitle("Cadastro de Orçamento");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        ImageIcon icon = new ImageIcon(new ImageIcon("D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\img\\iconDespesas.png")
                .getImage().getScaledInstance(100, 50, java.awt.Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(10, 200, 100, 50);
        add(imageLabel);

        JLabel categoriaLabel = new JLabel("Categoria:");
        categoriaLabel.setBounds(10, 20, 80, 25);
        add(categoriaLabel);

        JComboBox<String> categoriaBox = new JComboBox<>();
        for (Categoria c : sistema.getCategorias()) {
            categoriaBox.addItem(c.getNome());
        }
        categoriaBox.setBounds(100, 20, 160, 25);
        add(categoriaBox);

        JLabel limiteLabel = new JLabel("Limite:");
        limiteLabel.setBounds(10, 60, 80, 25);
        add(limiteLabel);

        JTextField limiteField = new JTextField();
        limiteField.setBounds(100, 60, 160, 25);
        add(limiteField);

        JButton salvarBtn = new JButton("Salvar");
        salvarBtn.setBounds(100, 100, 80, 25);
        add(salvarBtn);

        salvarBtn.addActionListener(e -> {
            String categoriaNome = (String) categoriaBox.getSelectedItem();
            double limite = Double.parseDouble(limiteField.getText());

            Categoria categoria = sistema.getCategorias().stream()
                    .filter(c -> c.getNome().equals(categoriaNome))
                    .findFirst().orElse(null);

            if (categoria != null) {
                categoria.setLimite(limite);
                JOptionPane.showMessageDialog(null, "Limite atualizado!");
                dispose();
            }
        });

        setVisible(true);
    }
}
