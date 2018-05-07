package br.com.lasa.projeto.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.lasa.projeto.venda.facade.VendaServiceFacade;
import br.com.lasa.projeto.venda.vo.VendaVO;

@Controller
public class InicioAction {
	
	@Autowired
	private VendaServiceFacade vendasServiceFacade;
	
	@RequestMapping("/")
	public ModelAndView inicio() {
		ModelAndView mv = new ModelAndView("relatorio");
		
		List<VendaVO> listaVendas = vendasServiceFacade.obterVendas();
		
		mv.addObject("listaVendas", listaVendas);
		
		return mv;
	}
	
}
		