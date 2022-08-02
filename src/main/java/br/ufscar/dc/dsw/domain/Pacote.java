package br.ufscar.dc.dsw.domain;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pacote {
	private Long id;
    private String CNPJ;
    private String destino;

    private Date dataPartida;
    private int duracaoDias;	
    private BigDecimal valor;
    private String descricao;

    public Pacote(Long id) {
        this.id = id;
    }

    public Pacote(String CNPJ, String destino, Date dataPartida, int duracaoDias, BigDecimal valor) {
        this.CNPJ = CNPJ;
        this.destino = destino;
        this.dataPartida = dataPartida;
        this.duracaoDias = duracaoDias;
        this.valor = valor;
    }

    public Pacote(Long id, String CNPJ, String destino, Date dataPartida, int duracaoDias, BigDecimal valor, String descricao) {
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

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
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

    public List<String> getFotosImages(String path){
        List<String> aux = new ArrayList<String>();

        path = path + File.separator + this.id.toString();
        List<String> imageList = new ArrayList<String>();
        File dir = new File(path);
        File[] files = dir.listFiles();
        if (files != null) {
            for (final File imageFile : files) {
                imageList.add("images" + File.separator + this.id.toString() + File.separator + imageFile.getName());
                aux.add(path + File.separator + imageFile.getName());
            }
        }
        return imageList;
    }
}

