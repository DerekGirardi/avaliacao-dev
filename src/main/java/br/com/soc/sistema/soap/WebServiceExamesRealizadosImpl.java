package br.com.soc.sistema.soap;

import javax.jws.WebService;

import br.com.soc.sistema.business.ExamesRealizadosBusiness;
import br.com.soc.sistema.vo.ExameRealizadoVo;

@WebService(endpointInterface = "br.com.soc.sistema.soap.WebServiceExamesRealizados" )
public class WebServiceExamesRealizadosImpl implements WebServiceExamesRealizados {

	private ExamesRealizadosBusiness business;
	
	public WebServiceExamesRealizadosImpl() {
		this.business = new ExamesRealizadosBusiness();
	}
	
	@Override
	public String buscarExameRealizado(String codigo) {		
		return business.buscarExameRealizadoPor(codigo).toString();
	}
	
	@Override
	public void salvarExameRealizado(ExameRealizadoVo exameRealizadoVo) {		
		business.salvarExameRealizado(exameRealizadoVo);
	}
	
	@Override
	public void editarExameRealizado(ExameRealizadoVo exameRealizadoVo) {		
		business.editarExameRealizado(exameRealizadoVo);
	}
	
	@Override
	public void excluirExameRealizado(String codigo) {		
		business.excluirExameRealizado(codigo);
	}
}
