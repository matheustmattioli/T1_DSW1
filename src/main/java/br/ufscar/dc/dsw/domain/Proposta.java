package br.ufscar.dc.dsw.domain;

import java.sql.Date;

public class Proposta {
    private Long id;
    private Long idUsuario;
    private Long idPacote;
    private Date dataProposta;
    private Float valor;
    
    public Proposta(Long idUsuario, Long idPacote, Date dataproposta, Float valor) {
        this.idUsuario = idUsuario;
        this.idPacote = idPacote;
        this.dataProposta = dataproposta;
        this.valor = valor;    
    }

    public Proposta(Long id, Long idUsuario, Long idPacote, Date dataproposta, Float valor) {
        this(idUsuario, idPacote, dataproposta, valor);
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

}
