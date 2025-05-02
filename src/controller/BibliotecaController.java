package controller;

import model.*;
import java.util.*;
import java.time.LocalDate;

public class BibliotecaController {
    private List<Livro> livros = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();
    private List<Devolucao> devolucoes = new ArrayList<>();
    private List<Devolucao> atrasos = new ArrayList<>();

    public void cadastrarLivro(Livro l) { livros.add(l); }
    public void cadastrarUsuario(Usuario u) { usuarios.add(u); }

    public void emprestarLivro(Usuario u, Livro l, LocalDate dataEmprestimo, LocalDate previsaoDevolucao) {
        if (l.getExemplaresDisponiveis() > 0 && !u.isPossuiEmprestimo()) {
            emprestimos.add(new Emprestimo(l, u, dataEmprestimo, previsaoDevolucao));
            l.setExemplaresDisponiveis(l.getExemplaresDisponiveis() - 1);
            u.setPossuiEmprestimo(true);
            System.out.println("Empréstimo realizado para " + u.getNome() + " - Livro: " + l.getNomeDoLivro());
        } else {
            System.out.println("Não foi possível emprestar para " + u.getNome() + ". Verifique disponibilidade ou empréstimos pendentes.");
        }
    }

    public void devolverLivro(Emprestimo e, LocalDate dataDevolucao) {
        if (e == null) return; // evita NullPointerException
        Devolucao d = new Devolucao(e.getLivro(), e.getUsuario(), e.getDataDEvolucaoPrevista().minusDays(7), dataDevolucao, 0);
        devolucoes.add(d);
        if (dataDevolucao.isAfter(e.getDataDEvolucaoPrevista())) {
            atrasos.add(d);
            atrasos.sort((a, b) -> b.getDiasEmprestados() - a.getDiasEmprestados());
        }
    }

    public List<Devolucao> getAtrasos() { 
        return atrasos;  
    }
    public List<Emprestimo> getEmprestimos() { 
        return emprestimos; 
    }
    public List<Usuario> getUsuarios() { 
        return usuarios; 
    }
}