package br.com.lasa.projeto.processamento.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.lasa.projeto.venda.vo.VendaVO;

@Repository	
public class ProcessamentoDAOImpl implements ProcessamentoDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean inserirVendaProcessada(VendaVO vendaVO) {
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO tb_processamento (data, loja, pdv, status) VALUES (?, ?, ?, ?)");
		jdbcTemplate.update(query.toString(), new Object[] { vendaVO.getData(), vendaVO.getLoja(), vendaVO.getPdv(), vendaVO.getStatus() });
		return true;
	}

	public List<VendaVO> obterProcessamentosPendentes() {
		StringBuffer query = new StringBuffer();
		query.append("SELECT V.id_venda, P.id_processamento, V.data, V.loja, V.pdv FROM tb_venda V INNER JOIN tb_processamento P on V.data = P.data AND V.loja = P.loja AND V.pdv = P.pdv AND P.status = 'PENDENTE' LIMIT 10");
		List<VendaVO> processamentos  = jdbcTemplate.query(query.toString(),new BeanPropertyRowMapper<>(VendaVO.class));
		return processamentos;
	}	

	public boolean atualizarStatusProcessamento(Integer id_processamento) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE tb_processamento SET status = 'OK' WHERE id_processamento = " + id_processamento);
		jdbcTemplate.update(query.toString());
		return true;
	}

}
