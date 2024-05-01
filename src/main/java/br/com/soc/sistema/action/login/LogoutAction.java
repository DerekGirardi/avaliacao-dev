package br.com.soc.sistema.action.login;

import br.com.soc.sistema.infra.Action;

import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class LogoutAction extends Action {

    public String execute() {
        HttpSession session = ServletActionContext.getRequest().getSession(false);
        if (session != null) {
            session.invalidate();
            return SUCCESS;
        }
        return LOGIN;
    }
}
