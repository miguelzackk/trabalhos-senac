package taskFinal2Bimestre;

import java.util.Date;

public class Despesa {
	private Categoria categoria;
	private double valor;
	private Date data;

	public Despesa(Categoria categoria, double valor, Date data) {
		this.categoria = categoria;
		this.valor = valor;
		this.data = data;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
