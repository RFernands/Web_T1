package model;

public class Promocao {

    private int ID;
    private String URLdoSite;
    private String nomePeca;
    private String precoPeca;
    private String data;
    private String horario;

    public Promocao(int ID) {
        this.ID = ID;
    }

    public Promocao(int ID, String URLdoSite, String nomePeca, String precoPeca, String data, String horario) {
        this.ID = ID;
        this.URLdoSite = URLdoSite;
        this.nomePeca = nomePeca;
        this.precoPeca = precoPeca;
        this.data = data;
        this.horario = horario;
    }

    public Promocao(String URLdoSite, String nomePeca, String precoPeca, String data, String horario) {
        this.URLdoSite = URLdoSite;
        this.nomePeca = nomePeca;
        this.precoPeca = precoPeca;
        this.data = data;
        this.horario = horario;
    }

    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }

    public String getURLdoSite() {
        return URLdoSite;
    }

    public void setURLdoSite(String URLdoSite) {
        this.URLdoSite = URLdoSite;
    }
    
    public String getNomePeca() {
        return nomePeca;
    }
    
    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
