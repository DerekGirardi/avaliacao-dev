package br.com.soc.sistema.business;

import java.util.ArrayList;
import java.util.List;

import br.com.soc.sistema.dao.exames.ExameDao;
import br.com.soc.sistema.dao.funcionarios.FuncionarioDao;
import br.com.soc.sistema.dao.realizados.ExameRealizadoDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.filter.ExamesRealizadosFilter;
import br.com.soc.sistema.vo.ExameRealizadoVo;
import br.com.soc.sistema.vo.ExameVo;
import br.com.soc.sistema.vo.FuncionarioVo;

public class ExamesRealizadosBusiness {

	private static final String FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO = "Foi informado um caracter no lugar de um numero";
	private ExameRealizadoDao dao;
	private ExameDao exameDao;
	private FuncionarioDao funcionarioDao;
	
	public ExamesRealizadosBusiness() {
		this.dao = new ExameRealizadoDao();
		this.exameDao = new ExameDao();
		this.funcionarioDao = new FuncionarioDao();
	}
	
	public List<ExameRealizadoVo> trazerTodosOsExamesRealizados() {
		return dao.findAllExamesRealizados();
	}	
	
	public List<ExameVo> trazerTodosOsExames() {
		return exameDao.findAllExames();
	}	
	
	public List<FuncionarioVo> trazerTodosOsFuncionarios() {
		return funcionarioDao.findAllFuncionarios();
	}
	
	public void salvarExameRealizado(ExameRealizadoVo exameRealizadoVo) {
		try {
			if(exameRealizadoVo.getExameid().isEmpty() 
				|| exameRealizadoVo.getFuncionarioid().isEmpty() 
				|| exameRealizadoVo.getData() == null)
				throw new IllegalArgumentException("Os campos nao podem estar em branco");
			
			if(exameRealizadoVo.getId().isEmpty()) {
				dao.insertExameRealizado(exameRealizadoVo);
			} 
			else {
				dao.editExameRealizado(exameRealizadoVo);
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new BusinessException("Nao foi possivel realizar a inclusao do registro");
		}
	}	
	
	public void excluirExameRealizado(String codigo) {
		try {
			Integer cod = Integer.parseInt(codigo);
			dao.deleteExameRealizado(cod);
		} catch (Exception e) {
			throw new BusinessException("Nao foi possivel realizar a exclusão do registro");
		}
	}	
	
	public List<ExameRealizadoVo> filtrarExamesRealizados(ExamesRealizadosFilter filter) {
		List<ExameRealizadoVo> examesRealizados = new ArrayList<>();
		
		switch (filter.getOpcoesCombo()) {
			case ID:
				try {
					Integer codigo = Integer.parseInt(filter.getValorBusca());
					examesRealizados.add(dao.findByCodigo(codigo));
				}catch (NumberFormatException e) {
					throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
				}
			break;
			
			case ID_EXAME:
				try {
					Integer codigo = Integer.parseInt(filter.getValorBusca());
					examesRealizados.add(dao.findByCodigoExame(codigo));
				}catch (NumberFormatException e) {
					throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
				}
			break;
			
			case ID_FUNCIONARIO:
				try {
					Integer codigo = Integer.parseInt(filter.getValorBusca());
					examesRealizados.add(dao.findByCodigoFuncionario(codigo));
				}catch (NumberFormatException e) {
					throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
				}
			break;

			case NOME_EXAME:
				examesRealizados.addAll(dao.findAllByNomeExame(filter.getValorBusca()));
			break;
			
			case NOME_FUNCIONARIO:
				examesRealizados.addAll(dao.findAllByNomeFuncionario(filter.getValorBusca()));
			break;
			
			case DATA:
				//examesRealizados.add(dao.findAllByData(filter.getValorBusca()));
			break;
		}
		
		return examesRealizados;
	}
	
	public ExameRealizadoVo buscarExameRealizadoPor(String codigo) {
		try {
			Integer cod = Integer.parseInt(codigo);
			return dao.findByCodigo(cod);
		}catch (NumberFormatException e) {
			throw new BusinessException(FOI_INFORMADO_CARACTER_NO_LUGAR_DE_UM_NUMERO);
		}
	}
}
