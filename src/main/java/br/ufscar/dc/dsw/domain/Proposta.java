package br.ufscar.dc.dsw.domain;

import java.sql.Date;

public class Proposta {
    private Long id;
    private Long idUsuario;
    private Long idPacote;
    private Date dataProposta;
    private Float valor;
    private int statusProposta;

    public Proposta(Long id) {
        this.id = id;
    }

    public Proposta(Long idUsuario, Long idPacote, Date dataproposta, Float valor, int statusProposta) {
        this.idUsuario = idUsuario;
        this.idPacote = idPacote;
        this.dataProposta = dataproposta;
        this.valor = valor;    
        this.statusProposta = statusProposta;
    }

    public Proposta(Long id, Long idUsuario, Long idPacote, Date dataproposta, Float valor, int statusProposta) {
        this(idUsuario, idPacote, dataproposta, valor, statusProposta);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdPacote() {
        return idPacote;
    }

    public void setIdPacote(Long idPacote) {
        this.idPacote = idPacote;
    }

    public Date getDataProposta() {
        return dataProposta;
    }

    public void setDataProposta(Date dataProposta) {
        this.dataProposta = dataProposta;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public int getStatusProposta() {
        return statusProposta;
    }

    public void setStatusProposta(int statusProposta) {
        this.statusProposta = statusProposta;
    }

}
