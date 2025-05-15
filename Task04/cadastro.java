package Task04;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class cadastro extends JFrame
{
    private JTable table;
    private DefaultTableModel model;
    private JTextField nomeField, idadeField, emailField;
    private final String caminhoCSV = "cadastro.csv";

    public cadastro()
    {
        setTitle("Sistema de Cadastro");
        setSize(800, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(33, 150, 243));
        JLabel title = new JLabel("Cadastro de Pessoas");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setForeground(Color.WHITE);
        headerPanel.add(title);
        add(headerPanel, BorderLayout.NORTH);

        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setBackground(new Color(25, 118, 210));
        sidebarPanel.setPreferredSize(new Dimension(150, 0));
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
        sidebarPanel.add(Box.createVerticalGlue());
        JLabel logo = new JLabel("MENU");
        logo.setFont(new Font("Segoe UI", Font.BOLD, 16));
        logo.setForeground(Color.WHITE);
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        sidebarPanel.add(logo);
        sidebarPanel.add(Box.createVerticalGlue());
        add(sidebarPanel, BorderLayout.WEST);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(mainPanel, BorderLayout.CENTER);

        model = new DefaultTableModel(new String[] { "Nome", "Idade", "Email" }, 0);
        table = new JTable(model);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(24);
        table.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
        table.getTableHeader().setBackground(new Color(224, 242, 254));
        JScrollPane tableScroll = new JScrollPane(table);
        tableScroll.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200)));
        mainPanel.add(tableScroll, BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        nomeField = new JTextField(15);
        idadeField = new JTextField(5);
        emailField = new JTextField(15);
        JButton addButton = new JButton("Adicionar");
        addButton.setBackground(new Color(33, 150, 243));
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addButton.setFocusPainted(false);

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1;
        formPanel.add(nomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Idade:"), gbc);
        gbc.gridx = 1;
        formPanel.add(idadeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        formPanel.add(emailField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        formPanel.add(addButton, gbc);

        mainPanel.add(formPanel, BorderLayout.SOUTH);

        carregarCSV();
        addButton.addActionListener(e -> adicionarPessoa());
    }

    private void adicionarPessoa()
    {
        String nome = nomeField.getText();
        int idade;
        try
        {
            idade = Integer.parseInt(idadeField.getText());
        }
        catch (NumberFormatException e)
        {
            JOptionPane.showMessageDialog(this, "Idade deve ser número inteiro.");
            return;
        }
        String email = emailField.getText();

        variavelPessoas p = new variavelPessoas(nome, idade, email);
        model.addRow(new Object[] { p.getNome(), p.getIdade(), p.getEmail() });
        salvarCSV();

        nomeField.setText("");
        idadeField.setText("");
        emailField.setText("");
    }

    private void salvarCSV()
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(caminhoCSV)))
        {
            for (int i = 0; i < model.getRowCount(); i++)
            {
                writer.println(model.getValueAt(i, 0) + "," + model.getValueAt(i, 1) + "," + model.getValueAt(i, 2));
            }
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(this, "Erro ao salvar o arquivo.");
        }
    }

    private void carregarCSV()
    {
        File file = new File(caminhoCSV);
        if (!file.exists())
            return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file)))
        {
            String linha;
            while ((linha = reader.readLine()) != null)
            {
                String[] dados = linha.split(",");
                model.addRow(dados);
            }
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(this, "Erro ao carregar o arquivo.");
        }
    }
}