package model;

public class Promocao {

    private int ID;
    private String URLdoSite;
    private String CNPJdoTeatro;
    private String nomePeca;
    private float precoPeca;
    private String dataPeca;
    private String horario;

    public Promocao(int ID) {
        this.ID = ID;
    }

    public Promocao(int ID, String URLdoSite, String CNPJdoTeatro, String nomePeca, float precoPeca, String dataPeca, String horario) {
        this.ID = ID;
        this.URLdoSite = URLdoSite;
        this.CNPJdoTeatro = CNPJdoTeatro;
        this.nomePeca = nomePeca;
        this.precoPeca = precoPeca;
        this.dataPeca = dataPeca;
        this.horario = horario;
    }

    public Promocao(String URLdoSite, String CNPJdoTeatro, String nomePeca, float precoPeca, String dataPeca, String horario) {
        this.URLdoSite = URLdoSite;
        this.CNPJdoTeatro = CNPJdoTeatro;
        this.nomePeca = nomePeca;
        this.precoPeca = precoPeca;
        this.dataPeca = dataPeca;
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
    
    public String getCNPJdoTeatro() {
        return CNPJdoTeatro;
    }
    
    public void setCNPJdoTeatro(String CNPJdoTeatro) {
        this.CNPJdoTeatro = CNPJdoTeatro;
    }
    
    public String getNomePeca() {
        return nomePeca;
    }
    
    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    public float getPrecoPeca() {
        return precoPeca;
    }

    public void setPrecoPeca(float precoPeca) {
        this.precoPeca = precoPeca;
    }
    
    public String getDataPeca(){
        return dataPeca;
    }
    
    public void setDataPeca(String dataPeca) {
        this.dataPeca = dataPeca;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}