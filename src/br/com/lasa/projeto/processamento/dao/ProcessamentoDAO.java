package br.com.lasa.projeto.processamento.dao;

import java.util.List;

import br.com.lasa.projeto.venda.vo.ProcessamentoVO;
import br.com.lasa.projeto.venda.vo.VendaVO;

/**
 * Interface responsável por mapear as ações realizadas no momento de processamento das vendas.
 * @author Eduardo Martins
 *
 */
public interface ProcessamentoDAO {

	/**
	 * Método responsável por inserir uma venda na tabela de processamentos com o status de PENDENTE.	
	 * @param vendaVO
	 * @return
	 */
	public boolean inserirVendaProcessada(VendaVO vendaVO);
	
	/**
	 * Método responsável por obter os processamentos pendentes.
	 * @return
	 */
	public List<ProcessamentoVO> obterProcessamentosPendentes();
	
	/**
	 * Método responsável por atualizar o status de um determinado processamento.
	 * @return
	 */
	public boolean atualizarStatusProcessamento(Integer id_processamento);
}
