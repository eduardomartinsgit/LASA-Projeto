package br.com.lasa.projeto.venda.vo;

import java.io.Serializable;
import java.util.Date;

public class ProcessamentoVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7526474155410390803L;

	private Integer id_processamento;
	private Date data;
	private Integer loja;
	private Integer pdv;
	private String nome_arquivo;
	private String status;

	public Integer getId_processamento() {
		return id_processamento;
	}

	public void setId_processamento(Integer id_processamento) {
		this.id_processamento = id_processamento;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getLoja() {
		return loja;
	}

	public void setLoja(Integer loja) {
		this.loja = loja;
	}

	public Integer getPdv() {
		return pdv;
	}

	public void setPdv(Integer pdv) {
		this.pdv = pdv;
	}

	public String getNome_arquivo() {
		return nome_arquivo;
	}

	public void setNome_arquivo(String nome_arquivo) {
		this.nome_arquivo = nome_arquivo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
