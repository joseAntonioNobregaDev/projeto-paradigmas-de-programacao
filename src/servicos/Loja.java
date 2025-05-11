package servicos;

import java.util.ArrayList;
import produtos.Jogo;

public class Loja {

    private ArrayList<Jogo> estoque = new ArrayList<>();
    
    public boolean adicionarJogo(String nome, double valor, String desenvolvedora, String key){
        
        if (this.estoque.isEmpty()) {
            this.estoque.add(new Jogo(nome, valor, desenvolvedora, key));
            return true;
        } else {

            Jogo busca = this.buscarJogo(nome);

            if (busca != null) {
                busca.adicionarProduto();
                return true;
            }

            this.estoque.add(new Jogo(nome, valor, desenvolvedora, key));
            return true;
        }
    }

    public Jogo removerJogo(String nome){

        if (!this.estoque.isEmpty()) {
            Jogo busca = this.buscarJogo(nome);
            
            if (busca != null) {
                if (busca.getQuantidade() > 1) {
                    busca.removerProduto();
                    return new Jogo(busca.getNome(), busca.getValor(), busca.getDesenvolvedora(), busca.getKey());
                }

                Jogo aux = busca;
                this.estoque.remove(busca);
                return aux;
            }
        }

        return null;
    }

    public void verEstoque() {

        if (!this.estoque.isEmpty()) {
            
            for (Jogo jogo : this.estoque) {
                System.out.println(jogo.toString());
            }
        } else {
            System.out.println("Estoque vazio!");
        }
    }

    public Jogo buscarJogo(String nome) {

        if (!this.estoque.isEmpty()) {
            
            for (Jogo jogo : this.estoque) {
                if (jogo.getNome().equalsIgnoreCase(nome)) {
                    return jogo;                     
                }
            }
        }

        return null;
    }

    public Jogo[] toArray() {
        Jogo jogos[] = new Jogo[this.estoque.size()];

        for (int i = 0; i < this.estoque.size(); i++){
            jogos[i] = this.estoque.get(i);
        }

        return jogos;
    }

    public void ordenarPreco() {
        Jogo jogos[] = this.toArray();
        int ultimoIndex = this.estoque.size() - 1;

        for (int i = 0; i < ultimoIndex ; i++){
            for (int j = 0; j < ultimoIndex - i; j++){
                if (jogos[j].getValor() > jogos[j + 1].getValor()) {
                    Jogo maior = jogos[j];
                    jogos[j] = jogos[j + 1];
                    jogos[j + 1] = maior;
                }
            }
        }

        for (Jogo jogo : jogos) {
            System.out.println(jogo.toString());
        }
    }
}
