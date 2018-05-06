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
}
