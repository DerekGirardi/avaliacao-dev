package br.com.soc.sistema.dao.login;

import java.sql.Connection;   
import java.sql.PreparedStatement;  
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.soc.sistema.dao.Dao;
import br.com.soc.sistema.vo.UsuarioVo;
  
public class LoginDao extends Dao {
  
    public boolean isValidUser(UsuarioVo usuarioVo) {
    	StringBuilder query = new StringBuilder("SELECT * FROM usuario WHERE nm_usuario = ? AND pw_usuario = ?");
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
        	con = getConexao();
			ps = con.prepareStatement(query.toString());

            ps.setString(1, usuarioVo.getNome());
            ps.setString(2, usuarioVo.getSenha());
            
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean updatePassword(UsuarioVo usuarioVo, String newPassword) {
        String query = "UPDATE usuario SET pw_usuario = ? WHERE nm_usuario = ?";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = getConexao();
            ps = con.prepareStatement(query);

            ps.setString(1, newPassword);
            ps.setString(2, usuarioVo.getNome());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
