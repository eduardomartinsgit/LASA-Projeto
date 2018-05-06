package br.com.lasa.projeto.processamento.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.lasa.projeto.venda.vo.ProcessamentoVO;
import br.com.lasa.projeto.venda.vo.VendaVO;

@Repository	
public class ProcessamentoDAOImpl implements ProcessamentoDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean inserirVendaProcessada(VendaVO vendaVO) {
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO tb_processamento (data, loja, pdv, status) VALUES (?, ?, ?, ?)");
		int update = jdbcTemplate.update(query.toString(), new Object[] { vendaVO.getData(), vendaVO.getLoja(), vendaVO.getPdv(), vendaVO.getStatus() });
		return true;
	}

	public List<ProcessamentoVO> obterProcessamentosPendentes() {
		StringBuffer query = new StringBuffer();
		query.append("SELECT P.id_processamento, P.data, P.loja, P.pdv, P.status FROM tb_processamento P WHERE status = 'PENDENTE' LIMIT 10");
		List<ProcessamentoVO> processamentos  = jdbcTemplate.query(query.toString(),new BeanPropertyRowMapper<>(ProcessamentoVO.class));
		return processamentos;
	}	

	@Override
	public boolean atualizarStatusProcessamento(Integer id_processamento) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE tb_processamento SET status = 'OK' WHERE id_processamento = " + id_processamento);
		int update = jdbcTemplate.update(query.toString());
		return true;
	}

}
