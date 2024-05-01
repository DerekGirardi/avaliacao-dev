package br.com.soc.sistema.business;

import br.com.soc.sistema.dao.login.LoginDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.vo.UsuarioVo;

public class LoginBusiness {

	private LoginDao dao;
	
	public LoginBusiness() {
		this.dao = new LoginDao();
	}

	public boolean validarUsuario(UsuarioVo usuarioVo) {
		try {
			return dao.isValidUser(usuarioVo);
		} catch (Exception e) {
			throw new BusinessException("Nao foi possivel realizar a validação do usuário");
		}
	}
}
