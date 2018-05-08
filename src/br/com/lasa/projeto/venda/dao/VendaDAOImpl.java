package br.com.lasa.projeto.venda.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.lasa.projeto.venda.vo.ItemVO;
import br.com.lasa.projeto.venda.vo.VendaVO;
@Repository	
public class VendaDAOImpl implements VendaDAO {

	private static final Logger LOGGER = Logger.getLogger(VendaDAOImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public VendaVO obterVendaPendenteProcessamento() {
		StringBuffer query = new StringBuffer();
		query.append("SELECT V.id_venda, V.data, V.loja, V.pdv, V.status FROM tb_venda V WHERE status = 'OK' ORDER BY V.data DESC LIMIT 1");
		try {
			VendaVO vendaVO  = jdbcTemplate.queryForObject(query.toString(), VendaVO.class);
			LOGGER.debug("A venda " + vendaVO.getId_venda() + " foi obtida para processamento.");
			return vendaVO;
		} catch (InvalidResultSetAccessException e) {
		    LOGGER.error(e.getStackTrace() + e.getSql());
		    return null;
		} 
		catch (DataAccessException e){
		    LOGGER.error(e.getStackTrace() + e.toString());
		    return null;
		}
	}
	
	public boolean atualizarStatusVenda(Integer id_venda) {
		StringBuffer query = new StringBuffer();
		query.append("UPDATE tb_venda SET status = 'OK' WHERE id_venda = " + id_venda);
		try {
			jdbcTemplate.update(query.toString());
			LOGGER.debug("Status da venda: " + id_venda + " foi atualizado com sucesso para: 'OK'");
			return true;
		}catch (DataAccessException e){
		    LOGGER.error(e.getStackTrace() + e.toString());
		    return false;
		}
	}

	public List<ItemVO> obterItensVenda(Integer id_venda) {
		StringBuffer query = new StringBuffer();
		query.append("SELECT I.id_item_venda, I.produto, I.preco_unitario, I.desconto FROM tb_item_venda I WHERE I.id_venda = " + id_venda + " LIMIT 10");
		try {
			List<ItemVO> itens  = jdbcTemplate.query(query.toString(),new BeanPropertyRowMapper<>(ItemVO.class));
			LOGGER.debug("Obtidos " + itens.size() + " itens referentes a venda " + id_venda);
			return itens;
		} catch (InvalidResultSetAccessException e) {
		    LOGGER.error(e.getStackTrace() + e.getSql());
		    return null;
		} 
		catch (DataAccessException e){
		    LOGGER.error(e.getStackTrace() + e.toString());
		    return null;
		}
	}

	public boolean inserirVendaStatus(VendaVO vendaVO, String statusVenda) {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO tb_venda (id_venda, data, loja, pdv, status) VALUES (?, ?, ?, ?, ?)");
		try{
			jdbcTemplate.update(query.toString(), new Object[] { vendaVO.getId_venda(), vendaVO.getData(), vendaVO.getLoja(), vendaVO.getPdv(), statusVenda});
			LOGGER.debug("A venda " + vendaVO.getId_venda() + " foi inserida com sucesso com o status: " + statusVenda);
			return true;
		} 
		catch (DuplicateKeyException e){
		    LOGGER.error(e.getStackTrace() + e.toString());
		    return false;
		}
		
	}

	public boolean inserirItensVenda(VendaVO vendaVO) {
		StringBuffer query = new StringBuffer();
		query.append("INSERT INTO tb_item_venda (id_venda, id_item_venda, produto, preco_unitario, desconto) VALUES (?, ?, ?, ?, ?)");
		try {
			for (ItemVO itemVO : vendaVO.getItens()) {
				jdbcTemplate.update(query.toString(), new Object[] { vendaVO.getId_venda(), itemVO.getId_item_venda(), itemVO.getProduto(), itemVO.getPreco_unitario(), itemVO.getDesconto()});
			}
			LOGGER.debug("Todos os itens referentes a venda " + vendaVO.getId_venda() + " foram inseridos com sucesso");
			return true;
		}	catch (DuplicateKeyException e){
		    	LOGGER.error(e.getStackTrace() + e.toString());
		    return false;
		}

	}

	public List<VendaVO> obterVendas() {
		StringBuffer query = new StringBuffer();
		query.append("SELECT V.id_venda, V.data, V.loja, V.pdv, V.status FROM tb_venda V");
		try {
			List<VendaVO> vendas  = jdbcTemplate.query(query.toString(),new BeanPropertyRowMapper<>(VendaVO.class));
			LOGGER.debug("Quantidade de vendas retornadas: " + vendas.size());
			return vendas;
		} catch (InvalidResultSetAccessException e) {
		    LOGGER.error(e.getStackTrace() + e.getSql());
		    return null;
		} 
		catch (DataAccessException e){
		    LOGGER.error(e.getStackTrace() + e.toString());
		    return null;
		}
	}

}
