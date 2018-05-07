package br.com.lasa.projeto.utils;

/**
 * Classe responsável por conter os métodos de utilidade geral utilizados no sistema.
 * @author Eduar
 *
 */
public class LASAUtils {
	
	public static final String STATUS_NAO_PROCESSADO = "NÃO PROCESSADO";
	public static final String STATUS_OK = "OK";
	public static final String STATUS_PENDENTE = "PENDENTE";
	
	/**
	 * Método responsável por remover ponto e/ou virgulas de uma determinada String.
	 * @param valor
	 * @return
	 */
	public static String removerPontoVirgula(String valor) {
		return valor.replace(".", "").replace(",", "");
	}
	
	/**
	 * Método responsavel por retornar o valor final após um determinado desconto.
	 * @param valor
	 * @param desconto
	 * @return
	 */
	public static Double calcularValorTotal(Double valor, Double desconto) {
		
		Double valorDescontado = (valor * desconto)/100;
		return valor - valorDescontado;
		
	}
}
