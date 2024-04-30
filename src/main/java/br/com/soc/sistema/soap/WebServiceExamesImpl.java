package br.com.soc.sistema.soap;

import javax.jws.WebService;

import br.com.soc.sistema.business.ExameBusiness;
import br.com.soc.sistema.vo.ExameVo;

@WebService(endpointInterface = "br.com.soc.sistema.soap.WebServiceExames" )
public class WebServiceExamesImpl implements WebServiceExames {

	private ExameBusiness business;
	
	public WebServiceExamesImpl() {
		this.business = new ExameBusiness();
	}
	
	@Override
	public String buscarExame(String codigo) {		
		return business.buscarExamePor(codigo).toString();
	}
	
	@Override
	public void salvarExame(ExameVo examevo) {		
		business.salvarExame(examevo);
	}
	
	@Override
	public void editarExame(ExameVo exameVo) {		
		business.editarExame(exameVo);
	}
	
	@Override
	public void excluirExame(String codigo) {		
		business.excluirExame(codigo);
	}
}
