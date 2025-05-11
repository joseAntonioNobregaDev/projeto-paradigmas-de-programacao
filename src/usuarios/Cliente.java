package usuarios;

import servicos.Biblioteca;
import servicos.Loja;
import produtos.Jogo;

public class Cliente extends Usuario{

    private double minhaCarteira = 0;
    private Biblioteca minhaBiblioteca;
    private Loja loja;

    public Cliente() {
        
    }

    public Cliente(String nome, int idade, String cpf, Loja loja){
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.loja = loja;
    }

    @Override
    public void cadastro(String username, String senha){
        this.username = username;
        this.senha = senha;
        this.minhaBiblioteca = new Biblioteca();
    }

    public boolean adicionarSaldo(double valor) {

        if (valor > 0) {
            this.minhaCarteira += valor;
            return true;
        }

        return false;
    }

    public boolean comprarJogo(String nomeJogo) {
        Jogo compra = this.loja.buscarJogo(nomeJogo);

        if (compra != null) {
            if (this.minhaCarteira >= compra.getValor()) {
                this.minhaBiblioteca.adicionarJogo(this.loja.removerJogo(nomeJogo));
                this.minhaCarteira -= compra.getValor();
                System.out.println("Compra realizada!");
                return true;
            }

            System.out.println("Saldo insuficiente!");
        }

        return false;
    }

    public void visualizarEstoque() {
        this.loja.verEstoque();
    }

    public void acessarMinhaBiblioteca() {
        this.minhaBiblioteca.verMinhaBiblioteca();
    }

    public void mostrarPrecoOrdenado() {
        this.loja.ordenarPreco();
    }
}
