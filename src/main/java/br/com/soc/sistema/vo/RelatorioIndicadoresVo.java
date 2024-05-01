package br.com.soc.sistema.vo;

public class RelatorioIndicadoresVo {
	private String qtd;
	private String nome;	
	
	public RelatorioIndicadoresVo() {}
		
	public RelatorioIndicadoresVo(String qtd, String nome) {
		this.qtd = qtd;
		this.nome = nome;
	}

	public String getQtd() {
		return qtd;
	}

	public void setQtd(String qtd) {
		this.qtd = qtd;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "RelatorioIndicadoresVo [qtd=" + qtd + ", nome=" + nome + "]";
	}
}
