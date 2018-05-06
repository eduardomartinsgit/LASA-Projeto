package br.com.lasa.projeto.venda.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.lasa.projeto.venda.vo.VendaVO;
@Repository	
public class VendaDAOImpl implements VendaDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public VendaVO obterVendaPendenteProcessamento() {
		StringBuffer query = new StringBuffer();
		query.append("SELECT V.id_venda, V.data, V.loja, V.pdv, V.status FROM tb_venda V WHERE status = 'PENDENTE'");
		List<VendaVO> vendas  = jdbcTemplate.query(query.toString(),new BeanPropertyRowMapper<>(VendaVO.class));
		for (VendaVO vendaVO : vendas) {
			return vendaVO;
		}
		return null;
	}
	
	public boolean atualizarStatusVenda(Integer id_venda) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE tb_venda SET status = 'OK' WHERE id_venda = " + id_venda);
		int update = jdbcTemplate.update(query.toString());
		return true;
	}

}
