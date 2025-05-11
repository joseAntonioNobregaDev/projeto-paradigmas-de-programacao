package usuarios;

public abstract class Usuario {

    protected String nome;
    protected int idade;
    protected String cpf;
    protected String username;
    protected String senha;

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }

    public String getUsername() {
        return username;
    }

    public abstract void cadastro(String username, String senha);

    public boolean login(String username, String senha) {
        if (username.equals(this.username) && senha.equals(this.senha)) {
            return true;
        }

        return false;
    }
}
