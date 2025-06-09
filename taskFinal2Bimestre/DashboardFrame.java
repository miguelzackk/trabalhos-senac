package taskFinal2Bimestre;

import java.awt.Image;

import javax.swing.*;

public class DashboardFrame extends JFrame {
	private SistemaFinanceiro sistema;

	public DashboardFrame(SistemaFinanceiro sistema) {
		this.sistema = sistema;

		setTitle("Dashboard - Sistema Financeiro");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
        // Adicionando uma imagem obrigatória no JFrame
		ImageIcon originalIcon = new ImageIcon("D:\\Senac\\3° Ano\\Documentos\\Eclipse\\trabalhosSenac\\src\\img\\iconHome.jpg");
		Image img = originalIcon.getImage();

		int imgW = originalIcon.getIconWidth();
		int imgH = originalIcon.getIconHeight();

		int maxW = 150;
		int maxH = 100;

		double scale = Math.min((double) maxW / imgW, (double) maxH / imgH);
		int newW = (int) (imgW * scale);
		int newH = (int) (imgH * scale);

		Image scaledImg = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);

		int x = (600 - newW) / 2;  // centraliza horizontalmente com tamanho fixo do JFrame
		int y = 600 - newH - 50;   // desce para quase o final da janela

		JLabel imageLabel = new JLabel(scaledIcon);
		imageLabel.setBounds(x, y, newW, newH);
		add(imageLabel);


		int y1 = 20;

	
		JButton addCategoriaBtn = new JButton("Adicionar Categoria");
		addCategoriaBtn.setBounds(50, y1, 200, 30);
		add(addCategoriaBtn);
		addCategoriaBtn.addActionListener(e -> new CadastroCategoriaFrame(sistema));

		JButton listCategoriaBtn = new JButton("Listar Categorias");
		listCategoriaBtn.setBounds(300, y1, 200, 30);
		add(listCategoriaBtn);
		listCategoriaBtn.addActionListener(e -> new ListagemCategoriaFrame(sistema));

		y1 += 50;

	
		JButton addDespesaBtn = new JButton("Adicionar Despesa");
		addDespesaBtn.setBounds(50, y1, 200, 30);
		add(addDespesaBtn);
		addDespesaBtn.addActionListener(e -> new CadastroDespesaFrame(sistema));

		JButton listDespesaBtn = new JButton("Listar Despesas");
		listDespesaBtn.setBounds(300, y1, 200, 30);
		add(listDespesaBtn);
		listDespesaBtn.addActionListener(e -> new ListagemDespesaFrame(sistema));

		y1 += 50;

		
		JButton addOrcamentoBtn = new JButton("Adicionar Orçamento");
		addOrcamentoBtn.setBounds(50, y1, 200, 30);
		add(addOrcamentoBtn);
		addOrcamentoBtn.addActionListener(e -> new CadastroOrcamentoFrame(sistema));

		JButton listOrcamentoBtn = new JButton("Listar Orçamentos");
		listOrcamentoBtn.setBounds(300, y1, 200, 30);
		add(listOrcamentoBtn);
		listOrcamentoBtn.addActionListener(e -> new ListagemOrcamentoFrame(sistema));

		y1 += 50;

		
		JButton relatorioBtn = new JButton("Ver Relatório de Gastos");
		relatorioBtn.setBounds(50, y1, 450, 30);
		add(relatorioBtn);
		relatorioBtn.addActionListener(e -> new RelatorioGastosFrame(sistema));

		y1 += 50;

		
		JButton insightsBtn = new JButton("Ver Insights e Recomendações");
		insightsBtn.setBounds(50, y1, 450, 30);
		add(insightsBtn);
		insightsBtn.addActionListener(e -> new InsightsRecomendacoesFrame(sistema));

		y1 += 50;

		
		JButton configBtn = new JButton("Configurações de Perfil");
		configBtn.setBounds(50, y1, 450, 30);
		add(configBtn);
		configBtn.addActionListener(e -> new ConfiguracoesPerfilFrame());

		y1 += 50;

		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(50, y1, 450, 30);
		add(logoutBtn);
		logoutBtn.addActionListener(e -> {
			new LoginFrame(sistema);
			dispose();
		});

		setVisible(true);
	}
}
