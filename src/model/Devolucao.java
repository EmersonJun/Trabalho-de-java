package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Devolucao {
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private int diasEmprestados;
    public Devolucao(Livro livro, Usuario usuario, LocalDate dataEmprestimo, LocalDate dataDevolucao, int diasEmprestados) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.diasEmprestados = dataDevolucao.getDayOfYear() - dataEmprestimo.getDayOfYear();
        livro.setExemplaresDisponiveis(livro.getExemplaresDisponiveis() + 1);
        usuario.setPossuiEmprestimo(false);
    }
    public Livro getLivro() {
        return livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }
    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    public int getDiasEmprestados() {
        return diasEmprestados;
    }
    public void setDiasEmprestados(int diasEmprestados) {
        this.diasEmprestados = diasEmprestados;
    }
    @Override
    public String toString() {
        return "Devolucao [livro=" + livro + ", usuario=" + usuario + ", dataEmprestimo=" + dataEmprestimo + ", dataDevolucao="
                + dataDevolucao + ", diasEmprestados=" + diasEmprestados + "]";
    }
    
}
