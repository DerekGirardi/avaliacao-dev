package br.com.soc.sistema.business;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

import br.com.soc.sistema.dao.relatorio.RelatorioDao;
import br.com.soc.sistema.exception.BusinessException;
import br.com.soc.sistema.vo.RelatorioExameVo;
import br.com.soc.sistema.vo.RelatorioIndicadoresVo;

public class RelatorioBusiness {

	private RelatorioDao dao;
	
	public RelatorioBusiness() {
		this.dao = new RelatorioDao();
	}	
	
	public Workbook gerarRelatorioExcel(String dataInicial, String dataFinal) {
		try {
			return dao.gerarExcelRelatorio(dataInicial, dataFinal);
		} catch (Exception e) {
			throw new BusinessException("Nao foi possivel gerar o relatório");
		}
	}
	
	public List<RelatorioExameVo> gerarRelatorioHtml(String dataInicial, String dataFinal) {
		try {
			return dao.gerarHtmlRelatorio(dataInicial, dataFinal);
		} catch (Exception e) {
			throw new BusinessException("Nao foi possivel gerar o relatório");
		}
	}
	
	public Workbook gerarIndicadoresExcel(String dataInicial, String dataFinal) {
		try {
			return dao.gerarExcelIndicadores(dataInicial, dataFinal);
		} catch (Exception e) {
			throw new BusinessException("Nao foi possivel gerar o relatório");
		}
	}
	
	public List<RelatorioIndicadoresVo> gerarIndicadoresHtml(String dataInicial, String dataFinal) {
		try {
			return dao.gerarHtmlIndicadores(dataInicial, dataFinal);
		} catch (Exception e) {
			throw new BusinessException("Nao foi possivel gerar o relatório");
		}
	}	
	
    public byte[] workbookToBytes(Workbook workbook) {
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
            workbook.write(outputStream);
            return outputStream.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
