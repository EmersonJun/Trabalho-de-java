package utils;

import controller.BibliotecaController;
import model.*;
import java.time.LocalDate;

public class PreCarga {
    public static void executar(BibliotecaController controller) {
        Usuario u1 = new Usuario("mario", "mario@email.com", "blablabla", 123456789, true);
        Usuario u2 = new Usuario("mario2", "mario@email.com2", "blablabla2", 1234567892, true);
        Livro l1 = new Livro(10, 2010, "c#", "jonas");
        Livro l2 = new Livro(2, 2000, "java","carlos");

        controller.cadastrarUsuario(u1);
        controller.cadastrarUsuario(u2);
        controller.cadastrarLivro(l1);
        controller.cadastrarLivro(l2);

        controller.emprestarLivro(u2, l2, LocalDate.of(2023, 5, 20), LocalDate.of(2023, 5, 23));
        controller.devolverLivro(null, null);
        controller.emprestarLivro(u1, l1, LocalDate.now().minusDays(12), LocalDate.now().minusDays(5));
        controller.emprestarLivro(u2, l1, LocalDate.of(2023, 05, 20), LocalDate.of(2025, 12, 18));

    }
}