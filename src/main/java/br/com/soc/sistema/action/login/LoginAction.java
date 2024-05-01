package br.com.soc.sistema.action.login;

import org.apache.struts2.ServletActionContext;

import br.com.soc.sistema.business.LoginBusiness;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.vo.UsuarioVo;

public class LoginAction extends Action {
	private LoginBusiness business = new LoginBusiness();
	private UsuarioVo usuarioVo = new UsuarioVo();

    public String validateUser() {
    	if(usuarioVo.getNome() == null || usuarioVo.getNome().isEmpty())
    		return INPUT;
    	if(usuarioVo.getSenha() == null || usuarioVo.getSenha().isEmpty())
    		return INPUT;
        if (business.validarUsuario(usuarioVo)) {
        	ServletActionContext.getRequest().getSession().setAttribute("username", usuarioVo.getNome());
        	System.out.println("Usuario validado com sucesso");
            return SUCCESS;
        } else {
        	System.out.println("Falha na autenticação");
            return INPUT;
        }
    }

	public UsuarioVo getUsuarioVo() {
		return usuarioVo;
	}

	public void setUsuarioVo(UsuarioVo usuarioVo) {
		this.usuarioVo = usuarioVo;
	}
}
