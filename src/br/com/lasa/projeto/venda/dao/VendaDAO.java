package br.com.lasa.projeto.venda.dao;

import java.util.List;

import br.com.lasa.projeto.venda.vo.ItemVO;
import br.com.lasa.projeto.venda.vo.VendaVO;

/**
 * Interface responsável por mapear as ações realizadas em conjunto com o banco de dados.
 * @author Eduardo Martins
 *
 */
	
public interface VendaDAO {

	/**
	 * Método responsável por obter a venda a ser processada.
	 * @return
	 */
	public VendaVO obterVendaPendenteProcessamento();
	
	/**
	 * Método responsável por atualizar o status de uma venda.
	 * @return
	 */
	public boolean atualizarStatusVenda(Integer id_venda);
	
	/**
	 * Método responsável por obter uma lista de itens referente a uma determinada venda.
	 * @param id_venda
	 * @return
	 */
	public List<ItemVO> obterItensVenda(Integer id_venda);
	
	/**
	 * Método responsável por inserir uma venda pendente de processamento.
	 * @param vendaVO
	 */
	public boolean inserirVendaStatus(VendaVO vendaVO, String statusVenda);
	
	/**
	 * Método responsável por inserir os itens associados a uma venda.
	 * @param itemVO
	 * @return
	 */
	public boolean inserirItensVenda(VendaVO vendaVO);
	

	/**
	 * Método responsável por obter todas as vendas e seus respectivos status.
	 * @return
	 */
	public List<VendaVO> obterVendas();
}
