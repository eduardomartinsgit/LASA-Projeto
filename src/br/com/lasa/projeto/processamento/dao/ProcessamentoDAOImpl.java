package br.com.lasa.projeto.processamento.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.lasa.projeto.venda.vo.VendaVO;

@Repository	
public class ProcessamentoDAOImpl implements ProcessamentoDAO{
	
	private static final Logger LOGGER = Logger.getLogger(ProcessamentoDAOImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean inserirProcessamentoStatus(VendaVO vendaVO, String statusProcessamento) {
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO tb_processamento (data, loja, pdv, status) VALUES (?, ?, ?, ?)");
		try{
			jdbcTemplate.update(query.toString(), new Object[] { vendaVO.getData(), vendaVO.getLoja(), vendaVO.getPdv(), statusProcessamento });
			LOGGER.debug("Venda " + vendaVO.getId_venda() + " inserida com sucesso para processamento, com status: " + statusProcessamento);
			return true;
		} catch (DuplicateKeyException e){
		    LOGGER.error(e.getStackTrace() + e.toString());
		    return false;
		}
	}

	public List<VendaVO> obterProcessamentosPendentes() {
		StringBuffer query = new StringBuffer();
		query.append("SELECT V.id_venda, P.id_processamento, V.data, V.loja, V.pdv FROM tb_venda V INNER JOIN tb_processamento P on V.data = P.data AND V.loja = P.loja AND V.pdv = P.pdv AND P.status = 'PENDENTE' LIMIT 10");
		try{
			List<VendaVO> processamentos  = jdbcTemplate.query(query.toString(),new BeanPropertyRowMapper<>(VendaVO.class));
			LOGGER.debug("Quantida de processamentos pendentes retornados: " + processamentos.size());
			return processamentos;
		} catch (InvalidResultSetAccessException e) {
		    LOGGER.error(e.getStackTrace() + e.getSql());
		    return null;
		} 
		catch (DataAccessException e){
		    LOGGER.error(e.getStackTrace() + e.toString());
		    return null;
		}
	}	

	public boolean atualizarStatusProcessamento(Integer id_processamento, String nomeArquivo, String statusProcessamento) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE tb_processamento SET nome_arquivo = ?, status = ? WHERE id_processamento = ?;");
		try{
			jdbcTemplate.update(query.toString(), new Object[] { nomeArquivo, statusProcessamento, id_processamento });
			LOGGER.debug("STATUS do processamento " + id_processamento + " atualizado com sucesso para 'OK'");
			return true;
		}catch (DataAccessException e){
		    LOGGER.error(e.getStackTrace() + e.toString());
		    return false;
		}
	}

}
