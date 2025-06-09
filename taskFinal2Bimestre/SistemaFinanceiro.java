package taskFinal2Bimestre;

import java.util.ArrayList;

public class SistemaFinanceiro {
	private ArrayList<Categoria> categorias = new ArrayList<>();
	private ArrayList<Despesa> despesas = new ArrayList<>();
	private ArrayList<Insight> insights = new ArrayList<>();

	public void adicionarCategoria(Categoria categoria) {
		categorias.add(categoria);
	}

	public void adicionarDespesa(Despesa despesa) {
		despesas.add(despesa);
		verificarLimite(despesa.getCategoria());
	}

	private void verificarLimite(Categoria categoria) {
		double totalGasto = 0;
		double limite = categoria.getLimite();

		for (Despesa d : despesas) {
			if (d.getCategoria().equals(categoria)) {
				totalGasto += d.getValor();
			}
		}

		if (totalGasto > limite) {
			double excedente = totalGasto - limite;
			String mensagem = "Orçamento Excedido: Categoria " + categoria.getNome() + " ultrapassou o orçamento em R$ "
					+ String.format("%.2f", excedente) + ".";
			String sugestao = "Avalie os gastos na categoria e ajuste seu comportamento ou revise o orçamento para os próximos períodos.";
			insights.add(new Insight(mensagem, sugestao));
		}
	}

	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}

	public ArrayList<Despesa> getDespesas() {
		return despesas;
	}

	public ArrayList<Insight> getInsights() {
		return insights;
	}
}
