package produtos;

public abstract class Produto {

    protected String tipo;
    protected String nome;
    protected double valor;

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public boolean comprar(double valor) {

        if (valor == this.valor) {
            return true;
        }

        return false;
    }
}
