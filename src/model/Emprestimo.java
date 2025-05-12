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
    

    @Override
        public String toString() {
        return String.format("Livro: [%s]\nUsuário: [%s]\nData Empréstimo: %s | Data Prevista Devolução: %s",
            livro.toString(), usuario.toString(), dataEmprestimo, dataDevolucaoPrevista);
}

}