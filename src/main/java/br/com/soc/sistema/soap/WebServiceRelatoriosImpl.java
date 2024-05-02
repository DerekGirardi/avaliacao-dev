package br.com.soc.sistema.soap;

import javax.jws.WebService;

import br.com.soc.sistema.business.RelatorioBusiness;

@WebService(endpointInterface = "br.com.soc.sistema.soap.WebServiceRelatorios" )
public class WebServiceRelatoriosImpl implements WebServiceRelatorios {

	private RelatorioBusiness business;
	
	public WebServiceRelatoriosImpl() {
		this.business = new RelatorioBusiness();
	}
	
	@Override
	public String gerarRelatorioHtml(String dataInicial, String dataFinal) {
		return business.gerarRelatorioHtml(dataInicial, dataFinal).toString();
	}

	@Override
	public String gerarIndicadoresHtml(String dataInicial, String dataFinal) {
		return business.gerarIndicadoresHtml(dataInicial, dataFinal).toString();
	}
}
