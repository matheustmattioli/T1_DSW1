package br.ufscar.dc.dsw.domain;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pacote {
	private Long id;
    private Long idAgencia; // utilizado para listar agencias com esse pacote
    private String CNPJ;
    private String cidade;
    private String estado;
    private String pais;

    private Date dataPartida;
    private int duracaoDias;	
    private BigDecimal valor;
    private String descricao;

    public Pacote(Long id) {
        this.id = id;
    }

    public Pacote(Long idAgencia, String CNPJ, String cidade, String estado, String pais, Date dataPartida, int duracaoDias, BigDecimal valor) {
        this.idAgencia = idAgencia;
        this.CNPJ = CNPJ;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
        this.dataPartida = dataPartida;
        this.duracaoDias = duracaoDias;
        this.valor = valor;
    }

    public Pacote(Long id, Long idAgencia, String CNPJ, String cidade, String estado, String pais, Date dataPartida, int duracaoDias, BigDecimal valor, String descricao) {
        this(idAgencia, CNPJ, cidade, estado, pais, dataPartida, duracaoDias, valor);
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

    public Long getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(Long idAgencia) {
        this.idAgencia = idAgencia;
    }
}

