package br.com.soc.sistema.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import br.com.soc.sistema.vo.ExameRealizadoVo;

@WebService
@SOAPBinding(style = Style.RPC)
public interface WebServiceExamesRealizados {
	@WebMethod
	public String buscarExameRealizado(String codigo);
	@WebMethod
	void salvarExameRealizado(ExameRealizadoVo exameRealizadoVo);
	@WebMethod
	void editarExameRealizado(ExameRealizadoVo exameRealizadoVo);
	@WebMethod
	void excluirExameRealizado(String codigo);
}
