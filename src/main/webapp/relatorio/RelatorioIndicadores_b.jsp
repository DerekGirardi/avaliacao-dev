<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><s:text name="label.titulo.pagina.consulta"/></title>
		<link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
	</head>
	<body class="bg-secondary">	
		<div class="container">
			<div class="row" style="justify-content: center;
									background: white;
								    font-weight: bold;
								    padding: 5px 0px 5px 0px;
								    border-bottom: 2px solid currentColor;">
				<s:text name="label.titulo.pagina.consulta"/>
			</div>

			<div class="row">
				<table class="table table-light table-striped align-middle">
					<thead>
						<tr>
							<th><s:text name="label.ocorrencias"/></th>
							<th><s:text name="label.nome"/></th>
						</tr>
					</thead>
					
					<tbody>
						<s:iterator value="relatorioIndicadores" >
							<tr>
								<td>${qtd}</td>
								<td>${nome}</td>
							</tr>
						</s:iterator>
					</tbody>			
				</table>
			</div>
			<div class="row">
			
			</div>
		</div>
		
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
	</body>
</html>