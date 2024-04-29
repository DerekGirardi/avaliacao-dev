package br.com.soc.sistema.filter;

import br.com.soc.sistema.infra.OpcoesCombo.Buscar;

public class Filter {
	private Buscar opcoesCombo;
	private String valorBusca;

	public String getValorBusca() {
		return valorBusca;
	}

	public Filter setValorBusca(String valorBusca) {
		this.valorBusca = valorBusca;
		return this;
	}

	public Buscar getOpcoesCombo() {
		return opcoesCombo;
	}

	public Filter setOpcoesCombo(String codigo) {
		this.opcoesCombo = Buscar.buscarPor(codigo);
		return this;
	}	
	
	public boolean isNullOpcoesCombo() {
		return this.getOpcoesCombo() == null;
	}
	
	public static Filter builder() {
		return new Filter();
	}
}
