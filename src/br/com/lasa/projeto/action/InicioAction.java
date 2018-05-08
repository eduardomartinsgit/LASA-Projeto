package br.com.lasa.projeto.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Action responsável pela inicialização da página de relatório.
 * @author Eduar
 *
 */
@Controller
public class InicioAction {
	
	@RequestMapping("/")
	public ModelAndView inicio() {
		return new ModelAndView("relatorio");
	}
	
}
		