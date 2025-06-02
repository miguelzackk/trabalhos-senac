package taskFinal2Bimestre;

public class Categoria {
    private String nome;
    private double limite;

    public Categoria(String nome, double limite) {
        this.nome = nome;
        this.limite = limite;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}

