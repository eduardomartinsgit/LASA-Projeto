package br.com.lasa.projeto.processamento.dao;

import java.util.List;

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
	public boolean inserirProcessamentoStatus(VendaVO vendaVO, String statusProcessamento);	
	
	/**
	 * Método responsável por obter os processamentos pendentes.
	 * @return
	 */
	public List<VendaVO> obterProcessamentosPendentes();
	
	/**
	 * Método responsável por atualizar o status de um determinado processamento.
	 * @return
	 */
	public boolean atualizarStatusProcessamento(Integer id_processamento, String nomeArquivo, String statusProcessamento);
	
}
