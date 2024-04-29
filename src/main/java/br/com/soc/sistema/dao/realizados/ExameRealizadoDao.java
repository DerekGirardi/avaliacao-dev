package br.com.soc.sistema.dao.realizados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.soc.sistema.dao.Dao;
import br.com.soc.sistema.vo.ExameRealizadoVo;

public class ExameRealizadoDao extends Dao {
	
	public void insertExameRealizado(ExameRealizadoVo exameRealizadoVo) {
	    StringBuilder query = new StringBuilder("INSERT INTO exames_realizados (id_funcionario, id_exame, data) VALUES (?, ?, ?)");
	    try(
	        Connection con = getConexao();
	        PreparedStatement ps = con.prepareStatement(query.toString())
	    ){
	        int i=1;
	        ps.setInt(i++, Integer.parseInt(exameRealizadoVo.getFuncionarioid()));
	        ps.setInt(i++, Integer.parseInt(exameRealizadoVo.getExameid()));
	        ps.setString(i++, exameRealizadoVo.getData());
	        ps.executeUpdate();
	    }catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void deleteExameRealizado(Integer codigo) {
	    StringBuilder query = new StringBuilder("DELETE FROM exames_realizados WHERE id = ?");
	    try (
	        Connection con = getConexao();
	        PreparedStatement ps = con.prepareStatement(query.toString())
	    ) {
	        ps.setInt(1, codigo);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void editExameRealizado(ExameRealizadoVo exameRealizadoVo) {
	    StringBuilder query = new StringBuilder("UPDATE exames_realizados SET id_funcionario = ?, id_exame = ?, data = ? WHERE id = ?");
	    try(
	        Connection con = getConexao();
	        PreparedStatement ps = con.prepareStatement(query.toString())
	    ){
	        int i=1;
	        ps.setInt(i++, Integer.parseInt(exameRealizadoVo.getFuncionarioid()));
	        ps.setInt(i++, Integer.parseInt(exameRealizadoVo.getExameid()));
	        ps.setString(i++, exameRealizadoVo.getData());
	        ps.setInt(i++, Integer.parseInt(exameRealizadoVo.getId()));
	        ps.executeUpdate();
	    }catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public List<ExameRealizadoVo> findAllExamesRealizados() {
		StringBuilder query = new StringBuilder("SELECT id, id_exame, id_funcionario, data FROM exames_realizados");
		try(
			Connection con = getConexao();
			PreparedStatement  ps = con.prepareStatement(query.toString());
			ResultSet rs = ps.executeQuery()){
			
			ExameRealizadoVo vo =  null;
			List<ExameRealizadoVo> examesRealizados = new ArrayList<>();
			while (rs.next()) {
				vo = new ExameRealizadoVo();
				vo.setId(rs.getString("id"));
				vo.setExameid(rs.getString("id_exame"));
				vo.setFuncionarioid(rs.getString("id_funcionario"));
				vo.setData(rs.getString("data"));
				
				examesRealizados.add(vo);
			}
			return examesRealizados;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Collections.emptyList();
	}
	
	public ExameRealizadoVo findByCodigo(Integer codigo) {
		StringBuilder query = new StringBuilder("SELECT id, id_exame, id_funcionario, data FROM exames_realizados ")
								.append("WHERE id = ?");
		
		try(Connection con = getConexao();
			PreparedStatement ps = con.prepareStatement(query.toString())){
			int i = 1;
			
			ps.setInt(i, codigo);
			
			try(ResultSet rs = ps.executeQuery()){
				ExameRealizadoVo vo =  null;
				
				while (rs.next()) {
					vo = new ExameRealizadoVo();
					vo.setId(rs.getString("id"));
					vo.setExameid(rs.getString("id_exame"));
					vo.setFuncionarioid(rs.getString("id_funcionario"));
					vo.setData(rs.getString("data"));
				}
				return vo;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	public List<ExameRealizadoVo> findAllByNomeExame(String nome) {
		StringBuilder query = new StringBuilder("SELECT id, id_exame, id_funcionario, data FROM exames_realizados ")
								.append("WHERE id_exame IN (SELECT rowid FROM exame WHERE lower(nm_exame) like lower(?))");
		
		try(Connection con = getConexao();
			PreparedStatement ps = con.prepareStatement(query.toString())){
			int i = 1;
			
			ps.setString(i, "%"+nome+"%");
			
			try(ResultSet rs = ps.executeQuery()){
				ExameRealizadoVo vo =  null;
				List<ExameRealizadoVo> examesRealizados = new ArrayList<>();
				
				while (rs.next()) {
					vo = new ExameRealizadoVo();
					vo.setId(rs.getString("id"));
					vo.setExameid(rs.getString("id_exame"));
					vo.setFuncionarioid(rs.getString("id_funcionario"));
					vo.setData(rs.getString("data"));
					
					examesRealizados.add(vo);
				}
				return examesRealizados;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return Collections.emptyList();
	}
	
	public ExameRealizadoVo findByCodigoExame(Integer codigo) {
		StringBuilder query = new StringBuilder("SELECT id, id_exame, id_funcionario, data FROM exames_realizados ")
								.append("WHERE id_exame IN (SELECT rowid FROM exame WHERE rowid = ?)");
		
		try(Connection con = getConexao();
			PreparedStatement ps = con.prepareStatement(query.toString())){
			int i = 1;
			
			ps.setInt(i, codigo);
			
			try(ResultSet rs = ps.executeQuery()){
				ExameRealizadoVo vo =  null;
				
				while (rs.next()) {
					vo = new ExameRealizadoVo();
					vo.setId(rs.getString("id"));
					vo.setExameid(rs.getString("id_exame"));
					vo.setFuncionarioid(rs.getString("id_funcionario"));
					vo.setData(rs.getString("data"));
				}
				return vo;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	public List<ExameRealizadoVo> findAllByNomeFuncionario(String nome) {
		StringBuilder query = new StringBuilder("SELECT id, id_exame, id_funcionario, data FROM exames_realizados ")
								.append("WHERE id_funcionario IN (SELECT rowid FROM funcionario WHERE lower(nm_funcionario) like lower(?))");
		
		try(Connection con = getConexao();
			PreparedStatement ps = con.prepareStatement(query.toString())){
			int i = 1;
			
			ps.setString(i, "%"+nome+"%");
			
			try(ResultSet rs = ps.executeQuery()){
				ExameRealizadoVo vo =  null;
				List<ExameRealizadoVo> examesRealizados = new ArrayList<>();
				
				while (rs.next()) {
					vo = new ExameRealizadoVo();
					vo.setId(rs.getString("id"));
					vo.setExameid(rs.getString("id_exame"));
					vo.setFuncionarioid(rs.getString("id_funcionario"));
					vo.setData(rs.getString("data"));
					
					examesRealizados.add(vo);
				}
				return examesRealizados;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return Collections.emptyList();
	}
	
	public ExameRealizadoVo findByCodigoFuncionario(Integer codigo) {
		StringBuilder query = new StringBuilder("SELECT rowid id, nm_exame data FROM exames_realizados ")
								.append("WHERE id_exame IN (SELECT rowid FROM exame WHERE rowid = ?)");
		
		try(Connection con = getConexao();
			PreparedStatement ps = con.prepareStatement(query.toString())){
			int i = 1;
			
			ps.setInt(i, codigo);
			
			try(ResultSet rs = ps.executeQuery()){
				ExameRealizadoVo vo =  null;
				
				while (rs.next()) {
					vo = new ExameRealizadoVo();
					vo.setId(rs.getString("id"));
					vo.setExameid(rs.getString("id_exame"));
					vo.setFuncionarioid(rs.getString("id_funcionario"));
					vo.setData(rs.getString("data"));
				}
				return vo;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}		
		return null;
	}
	
	/*public ExameRealizadoVo findAllByData(String data) {
	    try {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        StringBuilder query = new StringBuilder("SELECT id, id_exame, id_funcionario, nome FROM exames_realizados ")
	                                    .append("WHERE nome = ?");

	        try(Connection con = getConexao();
	            PreparedStatement ps = con.prepareStatement(query.toString())) {
	            ps.setString(1, new java.sql.Date(dateFormat.parse(data).getTime()));

	            try(ResultSet rs = ps.executeQuery()) {
	                ExameRealizadoVo vo = null;
	                if (rs.next()) {
	                    vo = new ExameRealizadoVo();
	                    vo.setId(rs.getString("id"));
	                    vo.setExameid(rs.getString("id_exame"));
	                    vo.setFuncionarioid(rs.getString("id_funcionario"));
	                    vo.setData(rs.getString("nome"));getData               }
	                return vo;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    return null;
	}*/
}