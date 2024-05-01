package br.com.soc.sistema.vo;

public class RelatorioExameVo {
	private String id;
	private String exameid;
	private String examenm;
	private String funcionarioid;
	private String funcionarionm;
	private String data;
	
	public RelatorioExameVo() {}
		
	public RelatorioExameVo(String id, String exameid, String examenm, String funcionarioid, String funcionarionm, String data) {
		this.id = id;
		this.exameid = exameid;
		this.examenm = examenm;
		this.funcionarioid = funcionarioid;
		this.funcionarionm = funcionarionm;
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getExameid() {
		return exameid;
	}

	public void setExameid(String exameid) {
		this.exameid = exameid;
	}

	public String getExamenm() {
		return examenm;
	}

	public void setExamenm(String examenm) {
		this.examenm = examenm;
	}

	public String getFuncionarioid() {
		return funcionarioid;
	}

	public void setFuncionarioid(String funcionarioid) {
		this.funcionarioid = funcionarioid;
	}

	public String getFuncionarionm() {
		return funcionarionm;
	}

	public void setFuncionarionm(String funcionarionm) {
		this.funcionarionm = funcionarionm;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "RelatorioExameVo [id=" + id + ", exameid=" + exameid + ", examenm=" + examenm + ", funcionarioid="
				+ funcionarioid + ", funcionarioinm=" + funcionarionm + ", data=" + data + "]";
	}
}
