package model;

public class Livro {
    private int exemplaresDisponiveis, anoDePublicacao;
    private String nomeDoLivro, autor;
        
    public Livro(int exemplaresDisponiveis, int anoDePublicacao, String nomeDoLivro, String autor) {
        this.exemplaresDisponiveis = exemplaresDisponiveis;
        this.anoDePublicacao = anoDePublicacao;
        this.nomeDoLivro = nomeDoLivro;
        this.autor = autor;
    }
    public void cadastroDeLivros(){
        
    }
    public int getExemplaresDisponiveis() {
        return exemplaresDisponiveis;
    }
    public void setExemplaresDisponiveis(int exemplaresDisponiveis) {
        if (exemplaresDisponiveis >= 0) {
            this.exemplaresDisponiveis = exemplaresDisponiveis;
        }
    }
    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }
    public void setAnoDePublicacao(int anoDePublicacao) {
        this.anoDePublicacao = anoDePublicacao;
    }
    public String getNomeDoLivro() {
        return nomeDoLivro;
    }
    public void setNomeDoLivro(String nomeDoLivro) {
        this.nomeDoLivro = nomeDoLivro;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    @Override
    public String toString() {
        return "Livro [exemplaresDisponiveis=" + exemplaresDisponiveis + ", anoDePublicacao=" + anoDePublicacao
                + ", nomeDoLivro=" + nomeDoLivro + ", autor=" + autor + "]";
    }
}
