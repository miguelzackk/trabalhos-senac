package taskFinal2Bimestre;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {
    private SistemaFinanceiro sistema;

    public DashboardFrame(SistemaFinanceiro sistema) {
        this.sistema = sistema;

        setTitle("Dashboard - Sistema Financeiro");
        setSize(600, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(Color.WHITE);


        ImageIcon originalIcon = new ImageIcon(
                "D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\img\\iconHome.jpg");
        Image img = originalIcon.getImage();

        int maxW = 150;
        int maxH = 100;

        double scale = Math.min((double) maxW / originalIcon.getIconWidth(),
                (double) maxH / originalIcon.getIconHeight());
        Image scaledImg = img.getScaledInstance((int) (originalIcon.getIconWidth() * scale),
                (int) (originalIcon.getIconHeight() * scale), Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(scaledImg));
        JPanel imagePanel = new JPanel();
        imagePanel.setBackground(Color.WHITE);
        imagePanel.add(imageLabel);
        mainPanel.add(imagePanel, BorderLayout.NORTH);

        // Painel central para botões - GridBag para flexibilidade
        JPanel buttonsPanel = new JPanel(new GridBagLayout());
        buttonsPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.gridx = 0;

        Font btnFont = new Font("Segoe UI", Font.BOLD, 14);

        int row = 0;

        JButton addCategoriaBtn = createButton("Adicionar Categoria", btnFont);
        gbc.gridy = row++;
        buttonsPanel.add(addCategoriaBtn, gbc);
        addCategoriaBtn.addActionListener(e -> new CadastroCategoriaFrame(sistema));

        JButton listCategoriaBtn = createButton("Listar Categorias", btnFont);
        gbc.gridy = row++;
        buttonsPanel.add(listCategoriaBtn, gbc);
        listCategoriaBtn.addActionListener(e -> new ListagemCategoriaFrame(sistema));

        JButton addDespesaBtn = createButton("Adicionar Despesa", btnFont);
        gbc.gridy = row++;
        buttonsPanel.add(addDespesaBtn, gbc);
        addDespesaBtn.addActionListener(e -> new CadastroDespesaFrame(sistema));

        JButton listDespesaBtn = createButton("Listar Despesas", btnFont);
        gbc.gridy = row++;
        buttonsPanel.add(listDespesaBtn, gbc);
        listDespesaBtn.addActionListener(e -> new ListagemDespesaFrame(sistema));

        JButton addOrcamentoBtn = createButton("Adicionar Orçamento", btnFont);
        gbc.gridy = row++;
        buttonsPanel.add(addOrcamentoBtn, gbc);
        addOrcamentoBtn.addActionListener(e -> new CadastroOrcamentoFrame(sistema));

        JButton listOrcamentoBtn = createButton("Listar Orçamentos", btnFont);
        gbc.gridy = row++;
        buttonsPanel.add(listOrcamentoBtn, gbc);
        listOrcamentoBtn.addActionListener(e -> new ListagemOrcamentoFrame(sistema));

        JButton relatorioBtn = createButton("Ver Relatório de Gastos", btnFont);
        gbc.gridy = row++;
        buttonsPanel.add(relatorioBtn, gbc);
        relatorioBtn.addActionListener(e -> new RelatorioGastosFrame(sistema));

        JButton insightsBtn = createButton("Ver Insights e Recomendações", btnFont);
        gbc.gridy = row++;
        buttonsPanel.add(insightsBtn, gbc);
        insightsBtn.addActionListener(e -> new InsightsRecomendacoesFrame(sistema));

        JButton configBtn = createButton("Configurações de Perfil", btnFont);
        gbc.gridy = row++;
        buttonsPanel.add(configBtn, gbc);
        configBtn.addActionListener(e -> new ConfiguracoesPerfilFrame());

        JButton logoutBtn = createButton("Logout", btnFont);
        gbc.gridy = row++;
        buttonsPanel.add(logoutBtn, gbc);
        logoutBtn.addActionListener(e -> {
            new LoginFrame(sistema);
            dispose();
        });

        mainPanel.add(buttonsPanel, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    // Método separado para criar botões
    private JButton createButton(String text, Font font) {
        JButton btn = new JButton(text);
        btn.setBackground(new Color(0, 153, 76));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setFont(font);
        btn.setPreferredSize(new Dimension(450, 40));
        return btn;
    }
}
