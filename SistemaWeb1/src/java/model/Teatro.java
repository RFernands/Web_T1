package model;

public class Teatro {

    private String email;
    private String senha;
    private String CNPJ;
    private String nome;
    private String cidade;

    public Teatro(String email, String senha, String CNPJ, String nome, String cidade) {
        this.email = email;
        this.senha = senha;
        this.CNPJ = CNPJ;
        this.nome = nome;
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
