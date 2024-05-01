package br.com.soc.sistema.action.login;

import br.com.soc.sistema.business.LoginBusiness;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.vo.UsuarioVo;

public class TrocarSenhaAction extends Action {
	private LoginBusiness business = new LoginBusiness();
	private UsuarioVo usuarioVo = new UsuarioVo();
    private String novaSenha = null;
    private String novaSenhaConfirm = null;

    public String execute() {
    	System.out.println("chegou");
        if (business.validarUsuario(usuarioVo)) {
            if (novaSenha.equals(novaSenhaConfirm)) {
                if (business.atualizarSenha(usuarioVo, novaSenha)) {
                	System.out.println("Senha atualizada com sucesso");
                    return SUCCESS;
                } else {
                    addActionError("Falha ao atualizar a senha. Tente novamente.");
                    System.out.println("Falha ao atualizar a senha. Tente novamente.");
                    return INPUT;
                }
            } else {
                addActionError("As novas senhas não coincidem.");
                System.out.println("As novas senhas não coincidem.");
                return INPUT;
            }
        } else {
            addActionError("Senha atual incorreta.");
            System.out.println("Senha atual incorreta.");
            return INPUT;
        }
    }

	public UsuarioVo getUsuarioVo() {
		return usuarioVo;
	}

	public void setUsuarioVo(UsuarioVo usuarioVo) {
		this.usuarioVo = usuarioVo;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public String getNovaSenhaConfirm() {
		return novaSenhaConfirm;
	}

	public void setNovaSenhaConfirm(String novaSenhaConfirm) {
		this.novaSenhaConfirm = novaSenhaConfirm;
	}
}
