package br.com.soc.sistema.dao.relatorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import br.com.soc.sistema.dao.Dao;

public class RelatorioDao extends Dao {
	
	public Workbook gerarExcelRelatorio(String dataInicial, String dataFinal) {
	    String query = "SELECT er.id, e.rowid, e.nm_exame, f.rowid as funcionarioid, f.nm_funcionario, er.data " +
	            "FROM exame e " +
	            "JOIN exames_realizados er ON e.rowid = er.id_exame " +
	            "JOIN funcionario f ON er.id_funcionario = f.rowid " +
	            "WHERE er.data BETWEEN ? AND ?";
	    
	    try (Connection con = getConexao();
	         PreparedStatement ps = con.prepareStatement(query)) {

	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        ps.setDate(1, new java.sql.Date(dateFormat.parse(dataInicial).getTime()));
	        ps.setDate(2, new java.sql.Date(dateFormat.parse(dataFinal).getTime()));

	        try (ResultSet rs = ps.executeQuery()) {
	            Workbook workbook = new XSSFWorkbook();
	            Sheet sheet = workbook.createSheet("Exames Realizados");

	            Row headerRow = sheet.createRow(0);
	            headerRow.createCell(0).setCellValue("ID");
	            headerRow.createCell(1).setCellValue("Código do Exame");
	            headerRow.createCell(2).setCellValue("Nome do Exame");
	            headerRow.createCell(3).setCellValue("Código do Funcionário");
	            headerRow.createCell(4).setCellValue("Nome do Funcionário");
	            headerRow.createCell(5).setCellValue("Data do Exame");

	            int rowNum = 1;
	            while (rs.next()) {
	                Row row = sheet.createRow(rowNum++);
	                row.createCell(0).setCellValue(rs.getInt("id"));
	                row.createCell(1).setCellValue(rs.getInt("rowid"));
	                row.createCell(2).setCellValue(rs.getString("nm_exame"));
	                row.createCell(3).setCellValue(rs.getInt("funcionarioid"));
	                row.createCell(4).setCellValue(rs.getString("nm_funcionario"));
	                row.createCell(5).setCellValue(rs.getString("data"));
	            }
	            return workbook;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
    public Workbook gerarExcelIndicadores(String dataInicial, String dataFinal) {
        String query = "SELECT e.nm_exame, COUNT(*) as total_realizados " +
                "FROM exame e " +
                "JOIN exames_realizados er ON e.rowid = er.id_exame " +
                "WHERE er.data BETWEEN ? AND ? " +
                "GROUP BY e.nm_exame " +
                "ORDER BY total_realizados DESC " +
                "LIMIT 5";
        
        try (Connection con = getConexao();
             PreparedStatement ps = con.prepareStatement(query)) {
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            ps.setDate(1, new java.sql.Date(dateFormat.parse(dataInicial).getTime()));
            ps.setDate(2, new java.sql.Date(dateFormat.parse(dataFinal).getTime()));
            
            try (ResultSet rs = ps.executeQuery()) {
                Workbook workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet("Relatório de Indicadores");

                Row dataInicialRow = sheet.createRow(0);
                dataInicialRow.createCell(0).setCellValue("Data Inicial:");
                dataInicialRow.createCell(1).setCellValue(dataInicial);
                
                Row dataFinalRow = sheet.createRow(1);
                dataFinalRow.createCell(0).setCellValue("Data Final:");
                dataFinalRow.createCell(1).setCellValue(dataFinal);

                Row headerRow = sheet.createRow(3);
                headerRow.createCell(0).setCellValue("Nome do Exame");
                headerRow.createCell(1).setCellValue("Total Realizados");
                
                int rowNum = 4;

                while (rs.next()) {
                    Row row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(rs.getString("nm_exame"));
                    row.createCell(1).setCellValue(rs.getInt("total_realizados"));
                }

                sheet.autoSizeColumn(0);
                sheet.autoSizeColumn(1);
                
                return workbook;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
