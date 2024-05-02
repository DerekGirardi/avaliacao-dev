package br.com.soc.sistema.action.relatorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.struts2.ServletActionContext;

import br.com.soc.sistema.business.RelatorioBusiness;
import br.com.soc.sistema.infra.Action;
import br.com.soc.sistema.vo.RelatorioExameVo;
import br.com.soc.sistema.vo.RelatorioIndicadoresVo;

public class RelatorioAction extends Action {
	private RelatorioBusiness business = new RelatorioBusiness();
	private List<RelatorioExameVo> relatorioExame = new ArrayList<>();
	private List<RelatorioIndicadoresVo> relatorioIndicadores = new ArrayList<>();
	private String dataInicial = null;
	private String dataFinal = null;
	private Boolean output = false;
	
	public String redirecionar() {
		return REDIRECT;
	}
	
	public String gerar() {
		if(dataInicial.isEmpty() 	|| dataInicial == null 
		|| dataFinal.isEmpty() 		|| dataFinal == null)
	        return REDIRECT;
		
		if(output) {
		    Workbook workbook = business.gerarRelatorioExcel(dataInicial, dataFinal);

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
		relatorioExame = business.gerarRelatorioHtml(dataInicial, dataFinal);
		return REPORT;
	}
	
	public String indicadores() {
		if(dataInicial.isEmpty() 	|| dataInicial == null 
		|| dataFinal.isEmpty() 		|| dataFinal == null)
	        return REDIRECT;
		
		if(output) {
		    Workbook workbook = business.gerarIndicadoresExcel(dataInicial, dataFinal);

		    if (workbook != null) {
		        try {
		            byte[] bytesDoExcel = business.workbookToBytes(workbook);

		            HttpServletResponse response = ServletActionContext.getResponse();

		            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
		            response.setHeader("Content-Disposition", "attachment; filename=indicadores.xlsx");

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
		relatorioIndicadores = business.gerarIndicadoresHtml(dataInicial, dataFinal);
		return INDICATOR;
	}
	
	public Map<Boolean, String> getOutputList() {
	    Map<Boolean, String> outputMap = new HashMap<>();
	    
	    outputMap.put(true, "EXCEL");
	    outputMap.put(false, "HTML");

	    return outputMap;
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

	public Boolean getOutput() {
		return output;
	}

	public void setOutput(Boolean output) {
		this.output = output;
	}

	public List<RelatorioExameVo> getRelatorioExame() {
		return relatorioExame;
	}

	public void setRelatorioExame(List<RelatorioExameVo> relatorioExame) {
		this.relatorioExame = relatorioExame;
	}

	public List<RelatorioIndicadoresVo> getRelatorioIndicadores() {
		return relatorioIndicadores;
	}

	public void setRelatorioIndicadores(List<RelatorioIndicadoresVo> relatorioIndicadores) {
		this.relatorioIndicadores = relatorioIndicadores;
	}
}
