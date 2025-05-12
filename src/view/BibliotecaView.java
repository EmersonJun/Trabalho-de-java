package view;

import controller.BibliotecaController;
import model.Emprestimo;
import model.Livro;
import model.Usuario;
import utils.PreCarga;

import java.time.LocalDate;
import java.util.Scanner;

public class BibliotecaView {
    private static final Scanner sc = new Scanner(System.in);
    private static final BibliotecaController controller = new BibliotecaController();

    public static void iniciar() {
        PreCarga.executar(controller);
        int opcao;

        do {
            exibirMenu();
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1 -> listarEmprestimos();
                case 2 -> listarAtrasos();
                case 3 -> cadastrarUsuario();
                case 4 -> cadastrarLivro();
                case 5 -> realizarEmprestimo();
                case 6 -> registrarDevolucao();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }

    private static void exibirMenu() {
        System.out.println("""
            ==============================
            1. Ver emprestimos
            2. Ver atrasos
            3. Cadastrar novo usuário
            4. Cadastrar novo livro
            5. Realizar empréstimo
            6. Registrar devolução
            0. Sair
            ==============================
            Escolha uma opção:
            """);
    }

    private static void listarEmprestimos() {
        System.out.println("Empréstimos encontrados:");
        controller.getEmprestimos().forEach(System.out::println);
    }

    private static void listarAtrasos() {
        System.out.println("Entregas com atraso:");
        controller.getAtrasos().forEach(System.out::println);
    }

    private static void cadastrarUsuario() {
        System.out.println("Nome do usuário:");
        String nome = sc.nextLine();
        System.out.println("Email:");
        String email = sc.nextLine();
        System.out.println("Endereço:");
        String endereco = sc.nextLine();
        System.out.println("Telefone:");
        int telefone = sc.nextInt();
        sc.nextLine();

        controller.cadastrarUsuario(new Usuario(nome, email, endereco, telefone, false));
        System.out.println("Usuário cadastrado com sucesso.");
    }

    private static void cadastrarLivro() {
        System.out.println("Nome do livro:");
        String nomeLivro = sc.nextLine();
        System.out.println("Autor:");
        String autor = sc.nextLine();
        System.out.println("Ano de publicação:");
        int ano = sc.nextInt();
        System.out.println("Número de exemplares:");
        int exemplares = sc.nextInt();
        sc.nextLine();

        controller.cadastrarLivro(new Livro(exemplares, ano, nomeLivro, autor));
        System.out.println("Livro cadastrado com sucesso.");
    }

    private static void realizarEmprestimo() {
        System.out.println("Lista de usuários:");
        for (int i = 0; i < controller.getUsuarios().size(); i++) {
            System.out.println(i + " - " + controller.getUsuarios().get(i).getNome());
        }
        System.out.print("Escolha o usuário (número): ");
        int usuarioIndex = sc.nextInt();

        System.out.println("Lista de livros:");
        for (int i = 0; i < controller.getLivros().size(); i++) {
            System.out.println(i + " - " + controller.getLivros().get(i).getNomeDoLivro());
        }
        System.out.print("Escolha o livro (número): ");
        int livroIndex = sc.nextInt();

        System.out.print("Digite a data de empréstimo (AAAA-MM-DD): ");
        String dataEmprestimoStr = sc.next();
        System.out.print("Digite a data prevista de devolução (AAAA-MM-DD): ");
        String dataPrevistaStr = sc.next();

        Usuario u = controller.getUsuarios().get(usuarioIndex);
        Livro l = controller.getLivros().get(livroIndex);
        LocalDate dataEmprestimo = LocalDate.parse(dataEmprestimoStr);
        LocalDate dataPrevista = LocalDate.parse(dataPrevistaStr);

        controller.emprestarLivro(u, l, dataEmprestimo, dataPrevista);
        System.out.println("Empréstimo realizado com sucesso.");
    }

    private static void registrarDevolucao() {
        System.out.println("Lista de empréstimos:");
        for (int i = 0; i < controller.getEmprestimos().size(); i++) {
            System.out.println(i + " - " + controller.getEmprestimos().get(i));
        }
        System.out.print("Escolha o empréstimo para devolver (número): ");
        int emprestimoIndex = sc.nextInt();
        System.out.print("Digite a data de devolução (AAAA-MM-DD): ");
        String dataDevolucaoStr = sc.next();

        Emprestimo e = controller.getEmprestimos().get(emprestimoIndex);
        LocalDate dataDevolucao = LocalDate.parse(dataDevolucaoStr);
        controller.devolverLivro(e, dataDevolucao);

        System.out.println("Livro devolvido.");
    }
}
