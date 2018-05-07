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

	private Integer id_item_venda;
	private String produto;
	private Double preco_unitario;
	private Double desconto;

	public Integer getId_item_venda() {
		return id_item_venda;
	}

	public void setId_item_venda(Integer id_item_venda) {
		this.id_item_venda = id_item_venda;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Double getPreco_unitario() {
		return preco_unitario;
	}

	public void setPreco_unitario(Double preco_unitario) {
		this.preco_unitario = preco_unitario;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

}
