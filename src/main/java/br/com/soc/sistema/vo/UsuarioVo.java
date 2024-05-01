package br.com.soc.sistema.vo;

public class UsuarioVo {
	private String nome;	
	private String senha;
	
	public UsuarioVo() {}
		
	public UsuarioVo(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "UsuarioVo [nome=" + nome + ", senha=" + senha + "]";
	}
}
