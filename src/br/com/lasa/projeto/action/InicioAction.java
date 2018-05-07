package br.com.lasa.projeto.action;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.lasa.projeto.processamento.facade.ProcessamentoServiceFacade;
import br.com.lasa.projeto.venda.vo.VendaVO;

@Controller
public class InicioAction {

	@Autowired
	private ProcessamentoServiceFacade processamentoServiceFacade;
	
	
	@RequestMapping("/")
	public String inicio() throws IOException {
		List<VendaVO> obterProcessamentosPendentes = processamentoServiceFacade.obterProcessamentosPendentes();
		processamentoServiceFacade.criarArquivoProcessados(obterProcessamentosPendentes);
		return "hello";
	}
	
}
		