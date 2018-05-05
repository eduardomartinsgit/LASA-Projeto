package br.com.lasa.projeto.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioAction {

	@RequestMapping("/")
	public String inicio() {
		return "hello";
	}
	
}
