package br.com.lasa.projeto.venda.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lasa.projeto.processamento.dao.ProcessamentoDAO;
import br.com.lasa.projeto.utils.LASAUtils;
import br.com.lasa.projeto.venda.dao.VendaDAO;
import br.com.lasa.projeto.venda.vo.ItemVO;
import br.com.lasa.projeto.venda.vo.VendaVO;

@Component
public class VendaServiceFacade {

	@Autowired
	private VendaDAO vendaDAO;
	
	@Autowired
	private ProcessamentoDAO processamentoDAO;
	
	/**
	 * M�todo respons�vel por obter uma determinada venda, processar e atualizar seu status para OK.
	 * @return
	 */
	public void processarVenda() {
		VendaVO vendaVO = vendaDAO.obterVendaPendenteProcessamento();
		if(vendaVO != null) {
			boolean atualizarStatusVenda = vendaDAO.atualizarStatusVenda(vendaVO.getId_venda());
			if(atualizarStatusVenda) {
				processamentoDAO.inserirProcessamentoStatus(vendaVO, LASAUtils.STATUS_PENDENTE);
			}
		}
	}
	
	/**
	 * M�todo respons�vel por inserir uma venda pendente no banco de dados para futuro processamento.
	 * @param vendaVO
	 */
	public boolean inserirVendaStatus(VendaVO vendaVO, String statusVenda) {
		return vendaDAO.inserirVendaStatus(vendaVO, statusVenda);
	};
	
	/**
	 * M�todo respons�vel por inserir todos os itens de uma determinadas venda no banco de dados.
	 * @param vendaVO
	 * @return
	 */
	public boolean inserirItensVenda(VendaVO vendaVO) {
		return vendaDAO.inserirItensVenda(vendaVO);
	};
	
	/**
	 * M�todo respons�vel por obter todas as vendas e seus respectivos itens associados.
	 * @return
	 */
	public List<VendaVO> obterVendas(){
		List<VendaVO> listaVendas = vendaDAO.obterVendas();
		for (VendaVO vendaVO : listaVendas) {
			List<ItemVO> listaItens = vendaDAO.obterItensVenda(vendaVO.getId_venda());
			vendaVO.setItens(listaItens);
		}
		return listaVendas;
	}
}
