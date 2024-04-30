package br.com.soc.sistema.business;

import java.io.ByteArrayOutputStream;

import org.apache.poi.ss.usermodel.Workbook;

import br.com.soc.sistema.dao.relatorio.RelatorioDao;
import br.com.soc.sistema.exception.BusinessException;

public class RelatorioBusiness {

	private RelatorioDao dao;
	
	public RelatorioBusiness() {
		this.dao = new RelatorioDao();
	}	
	
	public Workbook gerarRelatorio(String dataInicial, String dataFinal) {
		try {
			return dao.gerarExcelRelatorio(dataInicial, dataFinal);
		} catch (Exception e) {
			throw new BusinessException("Nao foi possivel gerar o relatório");
		}
	}
	
	public Workbook gerarIndicadores(String dataInicial, String dataFinal) {
		try {
			return dao.gerarExcelIndicadores(dataInicial, dataFinal);
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
