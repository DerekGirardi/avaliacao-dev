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
							<th><s:text name="label.id"/></th>
							<th><s:text name="label.codigoExame"/></th>
							<th><s:text name="label.nomeExame"/></th>
							<th><s:text name="label.codigoFuncionario"/></th>
							<th><s:text name="label.nomeFuncionario"/></th>
							<th><s:text name="label.data"/></th>
						</tr>
					</thead>
					
					<tbody>
						<s:iterator value="relatorioExame" >
							<tr>
								<td>${id}</td>
								<td>${exameid}</td>
								<td>${examenm}</td>
								<td>${funcionarioid}</td>
								<td>${funcionarionm}</td>
								<td>${data}</td>
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