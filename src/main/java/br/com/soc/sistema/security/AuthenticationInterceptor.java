package br.com.soc.sistema.security;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

public class AuthenticationInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        HttpSession session = ServletActionContext.getRequest().getSession(false);
        System.out.println("chegou aqui ai 1");
        if (session == null || session.getAttribute("username") == null) {
        	System.out.println("chegou aqui ai 2");
            return "login";
        }
        return invocation.invoke();
    }
}
