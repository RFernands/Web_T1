package model;

public class Usuario {

    private int ID;
    private String email;
    private String senha;
    private int ativo;

    public Usuario(int ID) {
        this.ID = ID;
    }

    public Usuario(int ID, String email, String senha, int ativo) {
        this.ID = ID;
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
    }

    public Usuario(String email, String senha, int ativo) {
        this.email = email;
        this.senha = senha;
        this.ativo = ativo;
    }
/*
    public Usuario(String email, int ativo) {
        this.email = email;
        this.ativo = ativo;
    }
*/
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }
}
