package br.com.lasa.projeto.venda.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Classe responsável por mapear uma venda de acordo com seus dados principais a
 * serem persistidos na base de dados.
 * 
 * @author Eduardo Martins
 *
 */
public class VendaVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2578690208160382677L;

	private Integer id_venda;
	private Integer id_processamento;
	private List<ItemVO> itens;
	private Date data;
	private Integer loja;
	private Integer pdv;
	private String status;

	public Integer getId_venda() {
		return id_venda;
	}

	public void setId_venda(Integer id_venda) {
		this.id_venda = id_venda;
	}

	public Integer getId_processamento() {
		return id_processamento;
	}

	public void setId_processamento(Integer id_processamento) {
		this.id_processamento = id_processamento;
	}

	public List<ItemVO> getItens() {
		return itens;
	}

	public void setItens(List<ItemVO> itens) {
		this.itens = itens;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
