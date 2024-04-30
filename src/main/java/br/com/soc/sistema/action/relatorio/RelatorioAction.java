package br.com.soc.sistema.action.relatorio;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;

import br.com.soc.sistema.business.RelatorioBusiness;
import br.com.soc.sistema.infra.Action;

public class RelatorioAction extends Action {
	private RelatorioBusiness business = new RelatorioBusiness();
	private String dataInicial = null;
	private String dataFinal = null;
	
	public String gerar() {
	    if (dataInicial == null || dataFinal == null)
	        return REDIRECT;

	    Workbook workbook = business.gerarRelatorio(dataInicial, dataFinal);

	    if (workbook != null) {
	        try {
	            byte[] bytesDoExcel = business.workbookToBytes(workbook);

	            HttpServletResponse response = ServletActionContext.getResponse();

	            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	            response.setHeader("Content-Disposition", "attachment; filename=relatorio.xlsx");

	            ServletOutputStream outputStream = response.getOutputStream();
	            outputStream.write(bytesDoExcel);

	            outputStream.flush();
	            outputStream.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return SUCCESS;
	    } else {
	        return REDIRECT;
	    }
	}
	
	public String getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}

	public String getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}
}
