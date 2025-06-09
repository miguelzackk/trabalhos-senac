package taskFinal2Bimestre;

public class Insight {
	private String mensagem;
	private String sugestao;

	public Insight(String mensagem, String sugestao) {
		this.mensagem = mensagem;
		this.sugestao = sugestao;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getSugestao() {
		return sugestao;
	}

	public void setSugestao(String sugestao) {
		this.sugestao = sugestao;
	}
}
