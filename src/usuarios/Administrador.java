package usuarios;

import servicos.Loja;

public class Administrador extends Usuario{

    private Loja loja;

    public Administrador() {
        
    }

    public Administrador(String nome, int idade, String cpf, Loja loja){
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.loja = loja;
    }

    @Override
    public void cadastro(String username, String senha) {
        this.username = username;
        this.senha = senha;
    }

    public void adicionarNovoJogo(String nome, double valor, String desenvolvedora, String key) {
        this.loja.adicionarJogo(nome, valor, desenvolvedora, key);
    }

    public boolean removerJogo(String nome) {
        
        if (this.loja.removerJogo(nome) != null) {
            return true;
        }
        
        return false;
    }

    public void visualizarEstoque() {
        this.loja.verEstoque();
    }

    public boolean buscarJogo(String nome) {
        
        if (this.loja.buscarJogo(nome) != null) {
            return true;
        }

        return false;
    }
}
