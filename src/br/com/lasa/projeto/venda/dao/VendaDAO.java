package br.com.lasa.projeto.venda.dao;

import java.util.List;

import br.com.lasa.projeto.venda.vo.ItemVO;
import br.com.lasa.projeto.venda.vo.VendaVO;

/**
 * Interface respons�vel por mapear as a��es realizadas em conjunto com o banco de dados.
 * @author Eduardo Martins
 *
 */
	
public interface VendaDAO {

	/**
	 * M�todo respons�vel por obter a venda a ser processada.
	 * @return
	 */
	public VendaVO obterVendaPendenteProcessamento();
	
	/**
	 * M�todo respons�vel por atualizar o status de uma venda.
	 * @return
	 */
	public boolean atualizarStatusVenda(Integer id_venda);
	
	/**
	 * M�todo respons�vel por obter uma lista de itens referente a uma determinada venda.
	 * @param id_venda
	 * @return
	 */
	public List<ItemVO> obterItensVenda(Integer id_venda);
	
	/**
	 * M�todo respons�vel por inserir uma venda pendente de processamento.
	 * @param vendaVO
	 */
	public boolean inserirVendaStatus(VendaVO vendaVO, String statusVenda);
	
	/**
	 * M�todo respons�vel por inserir os itens associados a uma venda.
	 * @param itemVO
	 * @return
	 */
	public boolean inserirItensVenda(VendaVO vendaVO);
	

	/**
	 * M�todo respons�vel por obter todas as vendas e seus respectivos status.
	 * @return
	 */
	public List<VendaVO> obterVendas();
}
