package br.com.soc.sistema.filter;

import br.com.soc.sistema.infra.OpcoesCombo.BuscarExamesRealizados;

public class ExamesRealizadosFilter {
	private BuscarExamesRealizados opcoesCombo;
	private String valorBusca;

	public String getValorBusca() {
		return valorBusca;
	}

	public ExamesRealizadosFilter setValorBusca(String valorBusca) {
		this.valorBusca = valorBusca;
		return this;
	}

	public BuscarExamesRealizados getOpcoesCombo() {
		return opcoesCombo;
	}

	public ExamesRealizadosFilter setOpcoesCombo(String codigo) {
		this.opcoesCombo = BuscarExamesRealizados.buscarPor(codigo);
		return this;
	}	
	
	public boolean isNullOpcoesCombo() {
		return this.getOpcoesCombo() == null;
	}
	
	public static ExamesRealizadosFilter builder() {
		return new ExamesRealizadosFilter();
	}
}
