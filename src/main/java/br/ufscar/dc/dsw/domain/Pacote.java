package br.ufscar.dc.dsw.domain;

import java.text.SimpleDateFormat;

public class Pacote {
	private Long id;
    private String CNPJ;
    private String destino;
    private SimpleDateFormat dataPartida;
    private int duracaoDias;	
    private int valor;
    
    public Pacote(Long id) {
        this.id = id;
    }

    public Pacote(String CNPJ, String destino, SimpleDateFormat dataPartida, int duracaoDias, int valor) {
        this.CNPJ = CNPJ;
        this.destino = destino;
        this.dataPartida.setCalendar(dataPartida.getCalendar());
        this.duracaoDias = duracaoDias;
        this.valor = valor;
    }

    public Pacote(Long id, String CNPJ, String destino, SimpleDateFormat dataPartida, int duracaoDias, int valor) {
        this(CNPJ, destino, dataPartida, duracaoDias, valor);
        this.id = id;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

	public String getDescricao() {
	    return descricao;
	}

	public void setDescricao(String descricao) {
	    this.descricao = descricao;
	}

}

