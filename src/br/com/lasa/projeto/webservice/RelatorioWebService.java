package br.com.lasa.projeto.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.lasa.projeto.venda.facade.VendaServiceFacade;
import br.com.lasa.projeto.venda.vo.VendaVO;

/**
 * WebService responsável por todos os métodos utilizados na página do relatório de vendas.
 * @author Eduardo Martins
 *
 */
@Path("/relatorio")
public class RelatorioWebService {

	@Autowired
	private VendaServiceFacade vendaServiceFacade;
	
	@GET
	@Path("/obterVendas")
	@Consumes(MediaType.APPLICATION_JSON)
	public List<VendaVO> obterVendas() {
		List<VendaVO> listaVendas = vendaServiceFacade.obterVendas();
		return listaVendas;
	}
}
