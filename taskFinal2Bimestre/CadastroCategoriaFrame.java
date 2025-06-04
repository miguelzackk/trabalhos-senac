package taskFinal2Bimestre;
import javax.swing.*;

public class CadastroCategoriaFrame extends JFrame {
    private SistemaFinanceiro sistema;

    public CadastroCategoriaFrame(SistemaFinanceiro sistema) {
        this.sistema = sistema;

        setTitle("Cadastro de Categoria");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 10, 80, 25);
        add(nomeLabel);

        JTextField nomeField = new JTextField();
        nomeField.setBounds(100, 10, 160, 25);
        add(nomeField);

        JLabel limiteLabel = new JLabel("Limite:");
        limiteLabel.setBounds(10, 50, 80, 25);
        add(limiteLabel);

        JTextField limiteField = new JTextField();
        limiteField.setBounds(100, 50, 160, 25);
        add(limiteField);

        JButton salvarBtn = new JButton("Salvar");
        salvarBtn.setBounds(100, 100, 80, 25);
        add(salvarBtn);

        salvarBtn.addActionListener(e -> {
            try {
                String nome = nomeField.getText();
                double limite = Double.parseDouble(limiteField.getText());

                Categoria categoria = new Categoria(nome, limite);
                sistema.adicionarCategoria(categoria);

                JOptionPane.showMessageDialog(null, "Categoria adicionada com sucesso!");
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Digite um valor numérico válido para o limite.");
            }
        });

        setVisible(true);
    }
}
