package taskFinal2Bimestre;

public class Orcamento {
	private Categoria categoria;
	private double valorLimite;

	public Orcamento(Categoria categoria, double valorLimite) {
		this.categoria = categoria;
		this.valorLimite = valorLimite;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public double getValorLimite() {
		return valorLimite;
	}

	public void setValorLimite(double valorLimite) {
		this.valorLimite = valorLimite;
	}
}
