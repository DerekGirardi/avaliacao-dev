package br.com.soc.sistema.action.funcionario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.soc.sistema.business.FuncionarioBusiness;
import br.com.soc.sistema.filter.Filter;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.infra.OpcoesCombo.Buscar;
import br.com.soc.sistema.vo.FuncionarioVo;

public class FuncionarioAction extends Action {
	private List<FuncionarioVo> funcionarios = new ArrayList<>();
	private FuncionarioBusiness business = new FuncionarioBusiness();
	private Filter filtrar = new Filter();
	private FuncionarioVo funcionarioVo = new FuncionarioVo();
	
	public String todos() {
		funcionarios.addAll(business.trazerTodosOsFuncionarios());	

		return SUCCESS;
	}
	
	public String filtrar() {
		if(filtrar.isNullOpcoesCombo())
			return REDIRECT;
		
		funcionarios = business.filtrarFuncionarios(filtrar);
		
		return SUCCESS;
	}
	
	public String novo() {
		if(funcionarioVo.getNome() == null || funcionarioVo.getNome().isEmpty())
			return INPUT;

		if(funcionarioVo.getRowid().isEmpty())
			business.salvarFuncionario(funcionarioVo);
		else 
			business.editarFuncionario(funcionarioVo);

		return REDIRECT;
	}
	
	public String editar() {
		if(funcionarioVo.getRowid() == null)
			return REDIRECT;
		
		funcionarioVo = business.buscarFuncionarioPor(funcionarioVo.getRowid());
		
		return INPUT;
	}
	
	public String excluir() {

		business.excluirFuncionario(funcionarioVo.getRowid());
		
		return REDIRECT;
	}
	
	public List<Buscar> getListaOpcoesCombo(){
		return Arrays.asList(Buscar.values());
	}
	
	public List<FuncionarioVo> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<FuncionarioVo> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Filter getFiltrar() {
		return filtrar;
	}

	public void setFiltrar(Filter filtrar) {
		this.filtrar = filtrar;
	}

	public FuncionarioVo getFuncionarioVo() {
		return funcionarioVo;
	}

	public void setFuncionarioVo(FuncionarioVo funcionarioVo) {
		this.funcionarioVo = funcionarioVo;
	}
}
