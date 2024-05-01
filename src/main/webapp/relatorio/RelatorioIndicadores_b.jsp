<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><s:text name="label.titulo.pagina.indicadores"/></title>
		<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
	</head>
	<body class="bg-secondary">	
		<div class="container">
			<div class="row mt-5" style="justify-content: center;
									background: white;
								    font-weight: bold;
								    padding: 5px 0px 5px 0px;
								    border-bottom: 2px solid currentColor;">
				<s:text name="label.titulo.pagina.indicadores"/>
			</div>
			
			<div class="row" style="justify-content: center;
									background: white;
								    font-weight: bold;
								    padding: 5px 0px 5px 0px;
								    border-bottom: 2px solid currentColor;">
				<s:property value="getDataInicial() + ' até ' + getDataFinal()" />
			</div>

			<div class="row">
				<table class="table table-light table-striped align-middle">
					<thead>
						<tr>
							<th><s:text name="label.nome"/></th>
							<th><s:text name="label.ocorrencias"/></th>
						</tr>
					</thead>
					
					<tbody>
						<s:iterator value="relatorioIndicadores" >
							<tr>
								<td>${nome}</td>
								<td>${qtd}</td>
							</tr>
						</s:iterator>
					</tbody>
					
					<tfoot class="table-secondary">
						<tr>
							<td colspan="2" style="text-align: left">
								<s:url action="redirecionarRelatorio" var="redirecionar"/>
								<div style="text-align: center">
									<a href="${redirecionar}" class="btn btn-success" style="float: left">
										<s:text name="label.voltar"/>
									</a>
								</div>
							</td>
						</tr>
					</tfoot>				
				</table>
			</div>
			<div class="row">
			
			</div>
		</div>
		
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
	</body>
</html>