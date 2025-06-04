package taskFinal2Bimestre;

import javax.swing.*;

public class DashboardFrame extends JFrame {
	private SistemaFinanceiro sistema;

	public DashboardFrame(SistemaFinanceiro sistema) {
		this.sistema = sistema;

		setTitle("Dashboard - Sistema Financeiro");
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		int y = 20;

	
		JButton addCategoriaBtn = new JButton("Adicionar Categoria");
		addCategoriaBtn.setBounds(50, y, 200, 30);
		add(addCategoriaBtn);
		addCategoriaBtn.addActionListener(e -> new CadastroCategoriaFrame(sistema));

		JButton listCategoriaBtn = new JButton("Listar Categorias");
		listCategoriaBtn.setBounds(300, y, 200, 30);
		add(listCategoriaBtn);
		listCategoriaBtn.addActionListener(e -> new ListagemCategoriaFrame(sistema));

		y += 50;

	
		JButton addDespesaBtn = new JButton("Adicionar Despesa");
		addDespesaBtn.setBounds(50, y, 200, 30);
		add(addDespesaBtn);
		addDespesaBtn.addActionListener(e -> new CadastroDespesaFrame(sistema));

		JButton listDespesaBtn = new JButton("Listar Despesas");
		listDespesaBtn.setBounds(300, y, 200, 30);
		add(listDespesaBtn);
		listDespesaBtn.addActionListener(e -> new ListagemDespesaFrame(sistema));

		y += 50;

		
		JButton addOrcamentoBtn = new JButton("Adicionar Orçamento");
		addOrcamentoBtn.setBounds(50, y, 200, 30);
		add(addOrcamentoBtn);
		addOrcamentoBtn.addActionListener(e -> new CadastroOrcamentoFrame(sistema));

		JButton listOrcamentoBtn = new JButton("Listar Orçamentos");
		listOrcamentoBtn.setBounds(300, y, 200, 30);
		add(listOrcamentoBtn);
		listOrcamentoBtn.addActionListener(e -> new ListagemOrcamentoFrame(sistema));

		y += 50;

		
		JButton relatorioBtn = new JButton("Ver Relatório de Gastos");
		relatorioBtn.setBounds(50, y, 450, 30);
		add(relatorioBtn);
		relatorioBtn.addActionListener(e -> new RelatorioGastosFrame(sistema));

		y += 50;

		
		JButton insightsBtn = new JButton("Ver Insights e Recomendações");
		insightsBtn.setBounds(50, y, 450, 30);
		add(insightsBtn);
		insightsBtn.addActionListener(e -> new InsightsRecomendacoesFrame(sistema));

		y += 50;

		
		JButton configBtn = new JButton("Configurações de Perfil");
		configBtn.setBounds(50, y, 450, 30);
		add(configBtn);
		configBtn.addActionListener(e -> new ConfiguracoesPerfilFrame());

		y += 50;

		
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(50, y, 450, 30);
		add(logoutBtn);
		logoutBtn.addActionListener(e -> {
			new LoginFrame(sistema);
			dispose();
		});

		setVisible(true);
	}
}
