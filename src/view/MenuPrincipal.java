package view;

import controller.BibliotecaController;
import utils.PreCarga;
import java.util.Scanner;


public class MenuPrincipal {
    public static void main(String[] args) {
        BibliotecaController controller = new BibliotecaController();
        PreCarga.executar(controller);

        Scanner sc = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("1. Ver emprestimos\n2. Ver atrasos\n0. Sair");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1 -> {
                    System.out.println("Emprestimos encontrados:");
                    controller.getEmprestimos().forEach(System.out::println);
                }
                case 2 -> {
                    System.out.println("entregas com atraso");
                    controller.getAtrasos().forEach(System.out::println);
                }
            }
        } while (opcao != 0);

        
    }
}
