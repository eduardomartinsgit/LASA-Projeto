package br.com.lasa.projeto.venda.vo;

import java.io.Serializable;

/**
 * Classe responsável por mapear um item a partir de uma determinada venda.
 * 
 * @author Eduardo Martins
 *
 */
public class ItemVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7762394417363225381L;

	private Integer idItem;
	private String produto;
	private Long precoUnitario;
	private Long desconto;

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Long getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(Long precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public Long getDesconto() {
		return desconto;
	}

	public void setDesconto(Long desconto) {
		this.desconto = desconto;
	}

}
