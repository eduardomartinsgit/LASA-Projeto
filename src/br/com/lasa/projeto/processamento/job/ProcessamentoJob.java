package br.com.lasa.projeto.processamento.job;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.lasa.projeto.processamento.facade.ProcessamentoServiceFacade;
import br.com.lasa.projeto.venda.facade.VendaServiceFacade;
import br.com.lasa.projeto.venda.vo.VendaVO;

/**
 * Classe responsável por iniciar as tarefas para processamento e geração de arquivo TXT 
 * @author Eduardo Martins
 *
 */
public class ProcessamentoJob {
	
	private static final Logger LOGGER = Logger.getLogger(ProcessamentoJob.class);
	
	@Autowired
	private VendaServiceFacade vendaServiceFacade;
	
	@Autowired
	private ProcessamentoServiceFacade processamentoServiceFacade;
	
    public synchronized void executarProcessamento() { 
    	LOGGER.debug("INICIANDO PROCESSAMENTO");
    	vendaServiceFacade.processarVenda();
    	LOGGER.debug("FINALIZANDO PROCESSAMENTO");
    }
    
    public synchronized void criarArquivoProcessamento() {
    	LOGGER.debug("INICIANDO CRIACAO DO ARQUIVO TXT");
    	List<VendaVO> processamentosPendentes = processamentoServiceFacade.obterProcessamentosPendentes();
    	processamentoServiceFacade.criarArquivoProcessados(processamentosPendentes);
    	LOGGER.debug("FINALIZANDO CRIACAO DO ARQUIVO TXT");
    }
}
