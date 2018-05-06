package br.com.lasa.projeto.venda.dao;

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
	 * Método responsável por atualizar o status de uma venda;
	 * @return
	 */
	public boolean atualizarStatusVenda(Integer id_venda);
}
