package br.ufscar.dc.dsw.domain;

public class Destino {
    private long id;
    private String cidade;
    private String estado;
    private String pais;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Destino(String cidade, String estado, String pais) {
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Destino(long id, String cidade, String estado, String pais) {
        this.id = id;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }
}
