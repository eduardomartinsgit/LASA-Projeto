package br.com.lasa.projeto.processamento.facade;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.lasa.projeto.processamento.dao.ProcessamentoDAO;
import br.com.lasa.projeto.utils.LASAUtils;
import br.com.lasa.projeto.venda.dao.VendaDAO;
import br.com.lasa.projeto.venda.vo.ItemVO;
import br.com.lasa.projeto.venda.vo.VendaVO;

@Component
public class ProcessamentoServiceFacade {

	@Autowired
	private ProcessamentoDAO processamentoDAO;
	
	@Autowired
	private VendaDAO vendaDAO;
		
	public List<VendaVO> obterProcessamentosPendentes(){
		return processamentoDAO.obterProcessamentosPendentes();
	}
	
	/**
	 * Método responsável por criar/alterar o diretorio PROCESSADOS e inserir o arquivo TXT com as vendas processadas.
	 * @param listaProcessados
	 */
	public void criarArquivoProcessados(List<VendaVO> listaProcessados){
		Date dataAtual = new Date();
		SimpleDateFormat formatador = new SimpleDateFormat("dd_mm_yyyy_HH_mm_ss");
		SimpleDateFormat formatadorArquivo = new SimpleDateFormat("ddmmyyyy");
		

		try {
			//Verifica se o diretorio onde será gravado existe, caso não exista será criado o diretorio a partir do PATH passado como parametro.
			new File("C:\\PROCESSADOS\\").mkdir();
			PrintWriter arquivo;
			arquivo = new PrintWriter(new File("C:\\PROCESSADOS\\VENDAS_PROCESSADAS_" + formatador.format(dataAtual) + ".txt"));
			Integer qntdVendasProcessadas = 0;
			for (VendaVO vendaVO : listaProcessados) {
				List<ItemVO> itens = vendaDAO.obterItensVenda(vendaVO.getId_venda());
				for (ItemVO itemVO : itens) {
					if(qntdVendasProcessadas == 10) {
						break;
					} else {
						arquivo.print(StringUtils.leftPad(vendaVO.getId_venda().toString(), 10, "0"));
						arquivo.print(formatadorArquivo.format(vendaVO.getData()));
						arquivo.print(StringUtils.leftPad(vendaVO.getLoja().toString(), 4, "0"));
						arquivo.print(StringUtils.leftPad(vendaVO.getPdv().toString(), 4, "0"));
						arquivo.print(StringUtils.leftPad(itemVO.getProduto(), 10, "0"));
						arquivo.print(StringUtils.leftPad(LASAUtils.removerPontoVirgula(itemVO.getPreco_unitario().toString()), 4, "0"));
						arquivo.print(StringUtils.leftPad(LASAUtils.removerPontoVirgula(itemVO.getDesconto().toString()), 4, "0"));
						
						arquivo.println(StringUtils.leftPad(LASAUtils.removerPontoVirgula(LASAUtils.calcularValorTotal(itemVO.getPreco_unitario(), itemVO.getDesconto()).toString()).toString(), 4, "0"));
						
						qntdVendasProcessadas++;
					}
				}
				processamentoDAO.atualizarStatusProcessamento(vendaVO.getId_processamento());
			}
			
			arquivo.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método responsável por inserir uma venda processada com o status de PENDENTE, aguardando ser gerada no arquivo TXT.
	 * @param vendaVO
	 * @return
	 */
	public boolean inserirProcessamentoStatus(VendaVO vendaVO, String statusProcessamento) {
		return processamentoDAO.inserirProcessamentoStatus(vendaVO, statusProcessamento);
	}
	
}
