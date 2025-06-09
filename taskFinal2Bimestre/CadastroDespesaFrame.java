package taskFinal2Bimestre;

import javax.swing.*;

import java.awt.Image;
import java.awt.event.*;
import java.util.Date;

public class CadastroDespesaFrame extends JFrame {
    private JComboBox<String> categoriaBox;
    private JTextField valorField;
    private SistemaFinanceiro sistema;

    public CadastroDespesaFrame(SistemaFinanceiro sistema) {
        this.sistema = sistema;
        setTitle("Cadastro de Despesa");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        ImageIcon originalIcon = new ImageIcon("D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\img\\iconDespesas.png");
        Image img = originalIcon.getImage();

        // Dimensões originais
        int imgW = originalIcon.getIconWidth();
        int imgH = originalIcon.getIconHeight();

        // Limites máximos
        int maxW = 150;
        int maxH = 100;

        // Escala proporcional
        double scale = Math.min((double) maxW / imgW, (double) maxH / imgH);
        int newW = (int) (imgW * scale);
        int newH = (int) (imgH * scale);

        // Redimensiona imagem
        Image scaledImg = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        // Centralizar horizontalmente
        int x = (getWidth() - newW) / 2;

        // Posicionar imagem
        JLabel imageLabel = new JLabel(scaledIcon);
        imageLabel.setBounds(x, 240, newW, newH); // Parte inferior
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
