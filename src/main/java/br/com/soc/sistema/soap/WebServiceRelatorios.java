package br.com.soc.sistema.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface WebServiceRelatorios{
	@WebMethod
	public String gerarRelatorioHtml(String dataInicial, String dataFinal);
	@WebMethod
	public String gerarIndicadoresHtml(String dataInicial, String dataFinal);
}
