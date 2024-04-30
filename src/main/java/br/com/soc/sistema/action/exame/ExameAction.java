package br.com.soc.sistema.action.exame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.soc.sistema.business.ExameBusiness;
import br.com.soc.sistema.filter.Filter;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.infra.OpcoesCombo.Buscar;
import br.com.soc.sistema.vo.ExameVo;

public class ExameAction extends Action {
	private List<ExameVo> exames = new ArrayList<>();
	private ExameBusiness business = new ExameBusiness();
	private Filter filtrar = new Filter();
	private ExameVo exameVo = new ExameVo();
	
	public String todos() {
		exames.addAll(business.trazerTodosOsExames());	

		return SUCCESS;
	}
	
	public String filtrar() {
		if(filtrar.isNullOpcoesCombo())
			return REDIRECT;
		
		exames = business.filtrarExames(filtrar);
		
		return SUCCESS;
	}
	
	public String novo() {
		if(exameVo.getNome() == null)
			return INPUT;

		if(exameVo.getRowid().isEmpty())
			business.salvarExame(exameVo);
		else
			business.editarExame(exameVo);
		
		return REDIRECT;
	}
	
	public String editar() {
		if(exameVo.getRowid() == null)
			return REDIRECT;
		
		exameVo = business.buscarExamePor(exameVo.getRowid());
		
		return INPUT;
	}
	
	public String excluir() {

		business.excluirExame(exameVo.getRowid());
		
		return REDIRECT;
	}
	
	public List<Buscar> getListaOpcoesCombo(){
		return Arrays.asList(Buscar.values());
	}
	
	public List<ExameVo> getExames() {
		return exames;
	}

	public void setExames(List<ExameVo> exames) {
		this.exames = exames;
	}

	public Filter getFiltrar() {
		return filtrar;
	}

	public void setFiltrar(Filter filtrar) {
		this.filtrar = filtrar;
	}

	public ExameVo getExameVo() {
		return exameVo;
	}

	public void setExameVo(ExameVo exameVo) {
		this.exameVo = exameVo;
	}
}
