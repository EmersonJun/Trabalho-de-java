package utils;

import controller.BibliotecaController;
import model.*;

import java.time.LocalDate;

public class PreCarga {

    public static void executar(BibliotecaController controller) {
        Usuario u1 = criarUsuario("mario", "mario@email.com", "blablabla", 123456789, true);
        Usuario u2 = criarUsuario("mario2", "mario@email.com2", "blablabla2", 1234567892, true);

        Livro l1 = criarLivro(10, 2010, "c#", "jonas");
        Livro l2 = criarLivro(2, 2000, "java", "carlos");

        cadastrarUsuarios(controller, u1, u2);
        cadastrarLivros(controller, l1, l2);

        realizarEmprestimos(controller, u1, u2, l1, l2);
    }

    private static Usuario criarUsuario(String nome, String email, String endereco, int telefone, boolean especial) {
        return new Usuario(nome, email, endereco, telefone, especial);
    }

    private static Livro criarLivro(int exemplares, int ano, String nome, String autor) {
        return new Livro(exemplares, ano, nome, autor);
    }

    private static void cadastrarUsuarios(BibliotecaController controller, Usuario... usuarios) {
        for (Usuario u : usuarios) {
            controller.cadastrarUsuario(u);
        }
    }

    private static void cadastrarLivros(BibliotecaController controller, Livro... livros) {
        for (Livro l : livros) {
            controller.cadastrarLivro(l);
        }
    }

    private static void realizarEmprestimos(BibliotecaController controller, Usuario u1, Usuario u2, Livro l1, Livro l2) {
        // Empréstimo atrasado e devolvido hoje
        controller.emprestarLivro(u2, l2, LocalDate.of(2023, 5, 20), LocalDate.of(2023, 5, 23));
        Emprestimo emprestimoAtrasado = controller.getEmprestimos().get(0);
        controller.devolverLivro(emprestimoAtrasado, LocalDate.now());

        // Empréstimos ativos
        controller.emprestarLivro(u1, l1, LocalDate.now().minusDays(12), LocalDate.now().minusDays(5));
        controller.emprestarLivro(u2, l1, LocalDate.of(2023, 5, 20), LocalDate.of(2025, 12, 18));
    }
}
