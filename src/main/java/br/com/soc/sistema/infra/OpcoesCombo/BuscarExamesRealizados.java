package br.com.soc.sistema.infra.OpcoesCombo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import br.com.soc.sistema.exception.BusinessException;

public enum BuscarExamesRealizados {
	ID("1", "ID DO PROCEDIMENTO"), 
	ID_EXAME("2", "ID DO EXAME"), 
	NOME_EXAME("4", "NOME DO EXAME"), 
	ID_FUNCIONARIO("3", "ID DO FUNCIONARIO"), 
	NOME_FUNCIONARIO("5", "NOME DO FUNCIONARIO"),
	DATA("6", "DATA");
	
	private String codigo;
	private String descricao;
	private final static Map<String, BuscarExamesRealizados> opcoes = new HashMap<>();
	
	static {
		Arrays.asList(BuscarExamesRealizados.values())
		.forEach(
			opcao -> opcoes.put(opcao.getCodigo(), opcao)
		);
	}
	
	private BuscarExamesRealizados(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public static BuscarExamesRealizados buscarPor(String codigo) throws IllegalArgumentException {
		if(codigo == null)
			throw new IllegalArgumentException("informe um codigo valido");
		
		BuscarExamesRealizados opcao = getOpcao(codigo)
				.orElseThrow(() -> new BusinessException("Codigo informado nao existe"));
		
		return opcao;
	}
	
	private static Optional<BuscarExamesRealizados> getOpcao(String codigo){
		return Optional.ofNullable(opcoes.get(codigo));
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
}