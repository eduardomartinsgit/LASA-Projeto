package br.com.lasa.projeto.processamento.dao;

import java.util.List;

import br.com.lasa.projeto.venda.vo.ProcessamentoVO;
import br.com.lasa.projeto.venda.vo.VendaVO;

/**
 * Interface respons�vel por mapear as a��es realizadas no momento de processamento das vendas.
 * @author Eduardo Martins
 *
 */
public interface ProcessamentoDAO {

	/**
	 * M�todo respons�vel por inserir uma venda na tabela de processamentos com o status de PENDENTE.	
	 * @param vendaVO
	 * @return
	 */
	public boolean inserirVendaProcessada(VendaVO vendaVO);
	
	/**
	 * M�todo respons�vel por obter os processamentos pendentes.
	 * @return
	 */
	public List<ProcessamentoVO> obterProcessamentosPendentes();
	
	/**
	 * M�todo respons�vel por atualizar o status de um determinado processamento.
	 * @return
	 */
	public boolean atualizarStatusProcessamento(Integer id_processamento);
}
