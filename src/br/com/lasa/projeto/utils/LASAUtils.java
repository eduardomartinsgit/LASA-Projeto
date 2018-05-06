package br.com.lasa.projeto.utils;

/**
 * Classe respons�vel por conter os m�todos de utilidade geral utilizados no sistema.
 * @author Eduar
 *
 */
public class LASAUtils {
	
	/**
	 * M�todo respons�vel por remover ponto e/ou virgulas de uma determinada String.
	 * @param valor
	 * @return
	 */
	public static String removerPontoVirgula(String valor) {
		return valor.replace(".", "").replace(",", "");
	}
	
	/**
	 * M�todo responsavel por retornar o valor final ap�s um determinado desconto.
	 * @param valor
	 * @param desconto
	 * @return
	 */
	public static Long calcularValorTotal(Long valor, Long desconto) {
		
		Long valorDescontado = (valor * desconto)/100;
		return valor - valorDescontado;
		
	}
}
