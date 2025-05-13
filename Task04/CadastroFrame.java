package Task04;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class CadastroFrame extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JTextField nomeField, idadeField, emailField;
    private final String caminhoCSV = "cadastro.csv";

    public CadastroFrame() {
        setTitle("Sistema de Cadastro");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        model = new DefaultTableModel(new String[]{"Nome", "Idade", "Email"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        nomeField = new JTextField();
        idadeField = new JTextField();
        emailField = new JTextField();
        JButton addButton = new JButton("Adicionar");

        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(nomeField);
        inputPanel.add(new JLabel("Idade:"));
        inputPanel.add(idadeField);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);
        inputPanel.add(addButton);

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        carregarCSV();

        addButton.addActionListener(e -> adicionarPessoa());
    }

    private void adicionarPessoa() {
        String nome = nomeField.getText();
        int idade = Integer.parseInt(idadeField.getText());
        String email = emailField.getText();
        Pessoa p = new Pessoa(nome, idade, email);

        model.addRow(new Object[]{p.getNome(), p.getIdade(), p.getEmail()});
        salvarCSV();
        nomeField.setText(""); idadeField.setText(""); emailField.setText("");
    }

    private void salvarCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(caminhoCSV))) {
            for (int i = 0; i < model.getRowCount(); i++) {
                writer.println(model.getValueAt(i, 0) + "," + model.getValueAt(i, 1) + "," + model.getValueAt(i, 2));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar o arquivo.");
        }
    }

    private void carregarCSV() {
        File file = new File(caminhoCSV);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                model.addRow(dados);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar o arquivo.");
        }
    }
}
