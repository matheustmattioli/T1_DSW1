package br.ufscar.dc.dsw.domain;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;

public class Pacote {
	private Long id;
    private String CNPJ;
    private long destino;

    private Date dataPartida;
    private int duracaoDias;	
    private BigDecimal valor;
    private String descricao;
    // Contains base64-encoded photos
    private ArrayList<String> fotos;
    
    public Pacote(Long id) {
        this.id = id;
    }

    public Pacote(String CNPJ, long destino, Date dataPartida, int duracaoDias, BigDecimal valor) {
        this.CNPJ = CNPJ;
        this.destino = destino;
        this.dataPartida = dataPartida;
        this.duracaoDias = duracaoDias;
        this.valor = valor;
    }

    public Pacote(Long id, String CNPJ, long destino, Date dataPartida, int duracaoDias, BigDecimal valor, String descricao) {
        this(CNPJ, destino, dataPartida, duracaoDias, valor);
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

	public String getDescricao() {
	    return descricao;
	}

	public void setDescricao(String descricao) {
	    this.descricao = descricao;
	}

    public long getDestino() {
        return destino;
    }

    public void setDestino(long destino) {
        this.destino = destino;
    }

    public Date getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(Date dataPartida) {
        this.dataPartida = dataPartida;
    }

    public int getDuracaoDias() {
        return duracaoDias;
    }

    public void setDuracaoDias(int duracaoDias) {
        this.duracaoDias = duracaoDias;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public ArrayList<String> getFotos() {
        return fotos;
    }

    public void setFotos(ArrayList<String> fotos) {
        this.fotos = fotos;
    }

}

