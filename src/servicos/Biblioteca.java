package servicos;

import java.util.ArrayList;
import produtos.Jogo;

public class Biblioteca {

    private ArrayList<Jogo> minhaBiblioteca = new ArrayList<>();

    public boolean adicionarJogo(Jogo novoJogo) {
        
        if (novoJogo != null) {
            this.minhaBiblioteca.add(novoJogo);
            return true;
        }

        return false;
    }

    public void verMinhaBiblioteca() {

        if (!this.minhaBiblioteca.isEmpty()) {
            
            for (Jogo jogo : minhaBiblioteca) {
                System.out.println(jogo.toString());
            }
        } else {
            System.out.println("Biblioteca vazia!");
        }
    }
}
