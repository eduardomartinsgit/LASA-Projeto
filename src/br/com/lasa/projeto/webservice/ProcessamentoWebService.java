package br.com.lasa.projeto.webservice;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.lasa.projeto.processamento.facade.ProcessamentoServiceFacade;
import br.com.lasa.projeto.utils.LASAUtils;
import br.com.lasa.projeto.venda.facade.VendaServiceFacade;
import br.com.lasa.projeto.venda.vo.VendaVO;

@Path("/vendas")
public class ProcessamentoWebService {
	
	@Autowired
	private VendaServiceFacade vendaServiceFacade;
	
	@Autowired
	private ProcessamentoServiceFacade processamentoServiceFacade;
	
	@POST
	@Path("/inserirVenda")
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserirVenda(VendaVO vendaVO) {
		
		if(vendaServiceFacade.inserirVendaStatus(vendaVO, LASAUtils.STATUS_OK)) {
			if(vendaServiceFacade.inserirItensVenda(vendaVO)) {
				if(processamentoServiceFacade.inserirProcessamentoStatus(vendaVO, LASAUtils.STATUS_PENDENTE)) {
					System.out.println("PROCESSAMENTO GERADO COM SUCESSO");
				}
			}
		}
	}
	
}
	