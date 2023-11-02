import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            limparConsole();
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Remover Contato");
            System.out.println("3 - Buscar Contato");
            System.out.println("4 - Listar Todos os Contatos");
            System.out.println("5 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpa a quebra de linha

            switch (opcao) {
                case 1:
                    adicionarContato(agenda, scanner);
                    break;
                case 2:
                    removerContato(agenda, scanner);
                    break;
                case 3:
                    buscarContato(agenda, scanner);
                    break;
                case 4:
                    listarContatos(agenda);
                    esperarTecla();
                    break;
                case 5:
                    System.out.println("Encerrando o programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    esperarTecla();
            }
        }
    }

    public static void adicionarContato(Agenda agenda, Scanner scanner) {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Limpa a quebra de linha
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Aniversário: ");
        String aniversario = scanner.nextLine();

        Contato novoContato = new Contato(id, nome, telefone, email, aniversario);
        agenda.adicionarContato(novoContato);
        System.out.println("Contato adicionado com sucesso!");
        esperarTecla();
    }

    public static void removerContato(Agenda agenda, Scanner scanner) {
        System.out.print("Digite o ID do contato a ser removido: ");
        int idRemover = scanner.nextInt();
        scanner.nextLine();  // Limpa a quebra de linha

        boolean removido = agenda.removerContato(idRemover);

        if (removido) {
            System.out.println("Contato removido com sucesso!");
        } else {
            System.out.println("Contato não encontrado.");
        }
        esperarTecla();
    }

    public static void buscarContato(Agenda agenda, Scanner scanner) {
        System.out.print("Digite o nome do contato a ser buscado: ");
        String termoBusca = scanner.nextLine();

        List<Contato> contatosEncontrados = agenda.buscarContatosPorNome(termoBusca);

        if (!contatosEncontrados.isEmpty()) {
            limparConsole();
            System.out.println("Contatos encontrados:");
            for (Contato contato : contatosEncontrados) {
                System.out.println(contato);
                System.out.println("----------------------");
            }
            esperarTecla();
        } else {
            System.out.println("Nenhum contato encontrado.");
            esperarTecla();
        }
    }

    public static void listarContatos(Agenda agenda) {
        List<Contato> contatos = agenda.listarContatos();

        if (!contatos.isEmpty()) {
            limparConsole();
            System.out.println("Lista de Contatos:");
            for (Contato c : contatos) {
                System.out.println(c);
            }
            esperarTecla();
        } else {
            System.out.println("Nenhum contato na agenda.");
            esperarTecla();
        }
    }

    public static void limparConsole() {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                ProcessBuilder builder = new ProcessBuilder("cmd", "/c", "cls");
                builder.inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            System.out.println("Erro ao tentar limpar o console: " + e.getMessage());
        }
    }

    public static void esperarTecla() {
        System.out.println("Pressione Enter para continuar...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
