package br.com.lasa.projeto.venda.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lasa.projeto.processamento.dao.ProcessamentoDAO;
import br.com.lasa.projeto.venda.dao.VendaDAO;
import br.com.lasa.projeto.venda.vo.VendaVO;

@Component
public class VendaServiceFacade {

	@Autowired
	private VendaDAO vendaDAO;
	
	@Autowired
	private ProcessamentoDAO processamentoDAO;
	
	/**
	 * Método responsável por obter uma determinada venda, processar e atualizar seu status para OK.
	 * @return
	 */
	public void processarVenda() {
		VendaVO vendaVO = vendaDAO.obterVendaPendenteProcessamento();
		if(vendaVO != null) {
			boolean atualizarStatusVenda = vendaDAO.atualizarStatusVenda(vendaVO.getId_venda());
			if(atualizarStatusVenda) {
				processamentoDAO.inserirVendaProcessada(vendaVO);
			}
		}
	}
}
