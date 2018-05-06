package br.com.lasa.projeto.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.lasa.projeto.processamento.facade.ProcessamentoServiceFacade;
import br.com.lasa.projeto.venda.facade.VendaServiceFacade;
import br.com.lasa.projeto.venda.vo.ProcessamentoVO;

@Controller
public class InicioAction {

	@Autowired
	private VendaServiceFacade vendaServiceFacade;
	
	@Autowired
	private ProcessamentoServiceFacade processamentoServiceFacade;
	
	
	@RequestMapping("/")
	public String inicio() {
		List<ProcessamentoVO> obterProcessamentosPendentes = processamentoServiceFacade.obterProcessamentosPendentes();
		return "hello";
	}
	
}
		