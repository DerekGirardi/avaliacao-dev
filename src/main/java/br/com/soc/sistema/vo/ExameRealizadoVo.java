package br.com.soc.sistema.vo;

public class ExameRealizadoVo {
	private String id;
	private String id_funcionario;
	private String id_exame;
	private String data;
	
	public ExameRealizadoVo() {}
		
	public ExameRealizadoVo(String id, String id_funcionario, String id_exame, String data) {
		this.id = id;
		this.id_funcionario = id_funcionario;
		this.id_exame = id_exame;
		this.data = data;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFuncionarioid() {
		return id_funcionario;
	}
	public void setFuncionarioid(String id_funcionario) {
		this.id_funcionario = id_funcionario;
	}
	public String getExameid() {
		return id_exame;
	}
	public void setExameid(String id_exame) {
		this.id_exame= id_exame;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "ExameRealizadoVo [id=" + id + ", id_funcionario=" + id_funcionario + ", id_exame=" + id_exame + ", data=" + data + "]";
	}
}
