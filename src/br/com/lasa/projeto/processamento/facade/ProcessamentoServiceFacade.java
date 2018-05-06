package br.com.lasa.projeto.processamento.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lasa.projeto.processamento.dao.ProcessamentoDAO;
import br.com.lasa.projeto.venda.vo.ProcessamentoVO;

@Component
public class ProcessamentoServiceFacade {

	@Autowired
	private ProcessamentoDAO processamentoDAO;
		
	public List<ProcessamentoVO> obterProcessamentosPendentes(){
		
		List<ProcessamentoVO> processamentosPendentes = processamentoDAO.obterProcessamentosPendentes();
		for (ProcessamentoVO itemVenda : processamentosPendentes) {
			processamentoDAO.atualizarStatusProcessamento(itemVenda.getId_processamento());
		}
		return processamentosPendentes;		
		
	}
	
}
