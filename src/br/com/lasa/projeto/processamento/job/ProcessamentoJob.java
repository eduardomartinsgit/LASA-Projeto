package br.com.lasa.projeto.processamento.job;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.lasa.projeto.processamento.facade.ProcessamentoServiceFacade;
import br.com.lasa.projeto.venda.facade.VendaServiceFacade;
import br.com.lasa.projeto.venda.vo.VendaVO;

public class ProcessamentoJob {
	
	@Autowired
	private VendaServiceFacade vendaServiceFacade;
	
	@Autowired
	private ProcessamentoServiceFacade processamentoServiceFacade;
	
    public synchronized void executarProcessamento() { 
    	vendaServiceFacade.processarVenda();	
    }
    
    public synchronized void criarArquivoProcessamento() {
    	List<VendaVO> processamentosPendentes = processamentoServiceFacade.obterProcessamentosPendentes();
    	processamentoServiceFacade.criarArquivoProcessados(processamentosPendentes);
    }
}
