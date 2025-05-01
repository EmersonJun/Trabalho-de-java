package model;

public class Usuario {
    private String nome, email, endereco;
    private int telefone;
    private boolean possuiEmprestimo;

    public Usuario(String nome, String email, String endereco, int telefone, boolean possuiEmprestimo) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.telefone = telefone;
        this.possuiEmprestimo = false;
        
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public int getTelefone() {
        return telefone;
    }
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    public boolean isPossuiEmprestimo() {
        return possuiEmprestimo;
    }
    public void setPossuiEmprestimo(boolean possuiEmprestimo) {
        this.possuiEmprestimo = possuiEmprestimo;
    }
    @Override
    public String toString() {
        return "Usuario [nome=" + nome + ", email=" + email + ", endereco=" + endereco + ", telefone=" + telefone
                + ", possuiEmprestimo=" + possuiEmprestimo + "]";
    }

    
}
