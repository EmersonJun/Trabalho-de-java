package model;

import java.time.LocalDate;

public class Emprestimo {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;

    public Emprestimo(Livro livro, Usuario usuario, LocalDate dataEmprestimo, LocalDate dataDevolucaoPrevista) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public Livro getLivro() { 
        return livro;
    }
    public Usuario getUsuario() { 
        return usuario; 
    }
    public LocalDate getDataDEvolucaoPrevista() { 
        return dataDevolucaoPrevista; 
    }
    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    @Override
    public String toString() {
        return "Emprestimo [livro=" + livro + ", usuario=" + usuario + ", dataEmprestimo=" + dataEmprestimo
                + ", dataDevolucaoPrevista=" + dataDevolucaoPrevista + "]";
    }
}