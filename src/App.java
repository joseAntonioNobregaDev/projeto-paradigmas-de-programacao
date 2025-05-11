import servicos.Loja;
import usuarios.Administrador;
import usuarios.Cliente;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scannerString = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        Loja loja = new Loja();
        Administrador administrador = new Administrador("Administrador", 35, "33322-32333", loja);
        Cliente cliente = new Cliente("Cliente", 34, "323444-43423", loja);
        int opcaoMenu1 = -1, opcaoMenu2 = -1;
        administrador.cadastro("admin", "admin");
        cliente.cadastro("cliente123", "123");

        while (opcaoMenu1 != 0) {
            System.out.println("Menu Administrador");
            System.out.println("1 = Adicionar Jogo no Estoque \n2 = Remover jogo do estoque \n3 = Estoque disponivel\n0 = Sair");
            System.out.print("Opcao: ");
            opcaoMenu1 = scanner.nextInt();
            
            switch (opcaoMenu1) {
                case 1:
                    System.out.print("Nome do jogo: ");
                    String nomeJogo = scannerString.nextLine();
    
                    if (administrador.buscarJogo(nomeJogo)) {
                        administrador.adicionarNovoJogo(nomeJogo, 0, null, null);
                    } else {
                        System.out.print("Valor do jogo: ");
                        double valorJogo = scanner.nextDouble();
                        System.out.print("Desenvolvedora do jogo: ");
                        String nomeDesenvolvedora = scannerString.nextLine();
                        System.out.print("Key do jogo: ");
                        String key = scannerString.nextLine();
                        administrador.adicionarNovoJogo(nomeJogo, valorJogo, nomeDesenvolvedora, key);   
                    }
                    break;
                        
                    case 2:
                        administrador.visualizarEstoque();
                        System.out.print("Nome do jogo: ");
                        String removerJogo = scannerString.nextLine();
                            
                        if (administrador.removerJogo(removerJogo)) {
                            System.out.println("Jogo removido do estoque");
                        } else {
                            System.out.print("Falha ao remover jogo");
                        }
                        break;
                        
                    case 3:
                        administrador.visualizarEstoque();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.print("Operacao invalida");
                        break;
            }
        }

        while (opcaoMenu2 != 0) {
            System.out.println("Menu Cliente");
            System.out.println("1 = Adicionar Saldo \n2 = Comprar Jogo\n3 = Estoque disponivel\n4 = Minha Biblioteca\n5 = Ordenar por preco\n0 = Sair");
            System.out.print("Opcao: ");
            opcaoMenu2 = scanner.nextInt();

            switch (opcaoMenu2) {
                case 1:
                    double valor = 0.0;
                    System.out.print("Valor: ");
                    valor = scanner.nextDouble();
                    cliente.adicionarSaldo(valor);
                    break;
                case 2:
                    String nome = "";
                    cliente.visualizarEstoque();
                    System.out.print("Nome do jogo: ");
                    nome = scannerString.nextLine();
                    cliente.comprarJogo(nome);
                    break;
                case 3:
                    cliente.visualizarEstoque();
                    break;
                case 4:
                    cliente.acessarMinhaBiblioteca();
                    break;
                case 5:
                    cliente.mostrarPrecoOrdenado();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }   
        }

        scanner.close();
        scannerString.close();

        /*Loja loja = new Loja();
        Administrador administrador = new Administrador("nome", 26, "3232133", loja);
        Cliente cliente = new Cliente("nome", 26, "3232133", loja);
        administrador.adicionarNovoJogo("Jogo1", 145, "desenvolvedora", "32132321");
        administrador.adicionarNovoJogo("Jogo2", 123, "desenvolvedora", "32132321");
        administrador.adicionarNovoJogo("Jogo3", 59, "desenvolvedora", "32132321");
        administrador.adicionarNovoJogo("Jogo4", 600, "desenvolvedora", "32132321");
        cliente.mostrarPrecoOrdenado();*/
    }
}
