package produtos;

public class Jogo extends Produto{

    private int quantidade;
    private String key;
    private String desenvolvedora;

    public Jogo(String nome, double valor, String desenvolvedora, String key){
        this.nome = nome;
        this.valor = valor;
        this.tipo = "Jogo";
        this.desenvolvedora = desenvolvedora;
        this.key = key;
        this.quantidade = 1;
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getKey() {
        return key;
    }

    public void adicionarProduto() {
        this.quantidade += 1;
    }

    public void removerProduto() {
        this.quantidade -= 1;
    }

    @Override
    public String toString() {
        return "Jogo [Tipo = " + getTipo() + ", Nome = " + getNome() + ", Valor = " + getValor()
                + ", Desenvolvedora = " + getDesenvolvedora() + ", Quantidade = " + getQuantidade() + "]";
    }
}
