package br.com.soc.sistema.action.realizados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.soc.sistema.business.ExamesRealizadosBusiness;
import br.com.soc.sistema.filter.ExamesRealizadosFilter;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.infra.OpcoesCombo.BuscarExamesRealizados;
import br.com.soc.sistema.vo.ExameRealizadoVo;
import br.com.soc.sistema.vo.ExameVo;
import br.com.soc.sistema.vo.FuncionarioVo;

public class ExamesRealizadosAction extends Action {
	private List<ExameRealizadoVo> examesRealizados = new ArrayList<>();
	private ExamesRealizadosBusiness business = new ExamesRealizadosBusiness();
	private ExamesRealizadosFilter filtrar = new ExamesRealizadosFilter();
	private ExameRealizadoVo exameRealizadoVo = new ExameRealizadoVo();
	
	public String todos() {
		examesRealizados.addAll(business.trazerTodosOsExamesRealizados());	

		return SUCCESS;
	}
	
	public String filtrar() {
		if(filtrar.isNullOpcoesCombo())
			return REDIRECT;
		
		examesRealizados = business.filtrarExamesRealizados(filtrar);
		
		return SUCCESS;
	}
	
	public String novo() {
		if(exameRealizadoVo.getExameid() == null 
			|| exameRealizadoVo.getFuncionarioid() == null 
			|| exameRealizadoVo.getData() == null)
			return INPUT;

		business.salvarExameRealizado(exameRealizadoVo);
		
		return REDIRECT;
	}
	
	public String editar() {
		if(exameRealizadoVo.getId() == null)
			return REDIRECT;
		
		exameRealizadoVo = business.buscarExameRealizadoPor(exameRealizadoVo.getId());
		
		return INPUT;
	}
	
	public String excluir() {

		business.excluirExameRealizado(exameRealizadoVo.getId());
		
		return REDIRECT;
	}
	
	public List<BuscarExamesRealizados> getListaOpcoesCombo(){
		return Arrays.asList(BuscarExamesRealizados.values());
	}
	
	public Map<String, String> getListaExames() {
	    Map<String, String> examesMap = new HashMap<>();
	    
	    for (ExameVo exame : business.trazerTodosOsExames()) {
	        examesMap.put(exame.getRowid(), exame.getNome());
	    }
	    return examesMap;
	}
	
	public Map<String, String> getListaFuncionarios() {
	    Map<String, String> funcionariosMap = new HashMap<>();
	    
	    for (FuncionarioVo funcionario : business.trazerTodosOsFuncionarios()) {
	    	funcionariosMap.put(funcionario.getRowid(), funcionario.getNome());
	    }
	    return funcionariosMap;
	}
	
	public List<ExameRealizadoVo> getExamesRealizados() {
		return examesRealizados;
	}

	public void setExamesRealizados(List<ExameRealizadoVo> examesRealizados) {
		this.examesRealizados = examesRealizados;
	}

	public ExamesRealizadosFilter getFiltrar() {
		return filtrar;
	}

	public void setFiltrar(ExamesRealizadosFilter filtrar) {
		this.filtrar = filtrar;
	}
	
	public ExameRealizadoVo getExameRealizadoVo() {
		return exameRealizadoVo;
	}

	public void setExameRealizadoVo(ExameRealizadoVo exameRealizadoVo) {
		this.exameRealizadoVo = exameRealizadoVo;
	}
}
