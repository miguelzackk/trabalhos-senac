	package taskFinal2Bimestre;

	import javax.swing.*;
	import javax.swing.table.DefaultTableModel;

	public class ListagemOrcamentoFrame extends JFrame {
	    private SistemaFinanceiro sistema;

	    public ListagemOrcamentoFrame(SistemaFinanceiro sistema) {
	        this.sistema = sistema;

	        setTitle("Listagem de Orçamentos");
	        setSize(400, 300);
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setLayout(null);

	        String[] colunas = {"Categoria", "Limite"};
	        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

	        for (Categoria c : sistema.getCategorias()) {
	            Object[] linha = {c.getNome(), c.getLimite()};
	            modelo.addRow(linha);
	        }

	        JTable tabela = new JTable(modelo);
	        JScrollPane scroll = new JScrollPane(tabela);
	        scroll.setBounds(20, 20, 350, 200);
	        add(scroll);

	        setVisible(true);
	    }
	}


