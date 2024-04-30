<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title><s:text name="label.titulo.pagina"/></title>
	    <link rel='stylesheet' href='webjars/bootstrap/5.1.3/css/bootstrap.min.css'>
	    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	</head>
	<body class="bg-secondary">

		<div class="container">
			<s:form action="/gerarRelatorio.action">

				<div class="card mt-5">
					<div class="card-header">
						<div class="row">
							<div class="col-sm-5">
								<s:url action="todosExames" var="todos"/>
								<a href="${todos}" class="btn btn-success" >Exames</a>
							</div>
							
							<div class="col-sm">
								<h5 class="card-title">Gerar Relat�rio</h5>
							</div>
						</div>
					</div>
					
					<div class="card-body">
	                    <div class="row align-items-center mt-3">
	                        <label for="data" class="col-sm-1 col-form-label text-center">
	                            Data inicial:
	                        </label>   
	                        <div class="col-sm-5">
	                            <s:date name="dataInicial" format="yyyy-MM-dd" />
	                            <s:textfield type="text" cssClass="form-control datepicker" id="dataInicial" name="dataInicial" readonly="true" style="background-color: white"/>	           
	                        </div>  
	                    </div>
						
	                    <div class="row align-items-center mt-3">
	                        <label for="dataFinal" class="col-sm-1 col-form-label text-center">
	                            Data final:
	                        </label>   
	                        <div class="col-sm-5">
	                            <s:date name="dataFinal" format="yyyy-MM-dd" />
	                            <s:textfield type="text" cssClass="form-control datepicker" id="dataFinal" name="dataFinal" readonly="true" style="background-color: white"/>	           
	                        </div>  
	                    </div>
					</div>

					<div class="card-footer">
						<div class="form-row">
							<button class="btn btn-primary col-sm-4 offset-sm-1">Gerar</button>
							<button type="reset" class="btn btn-secondary col-sm-4 offset-sm-2">Limpar Formulario</button>
						</div>
					</div>
				</div>
			</s:form>			
		</div>

	    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
	    <script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
	    <script>
	        $(function() {
	            $(".datepicker").datepicker({
	                dateFormat: 'yy-mm-dd',
	                onSelect: function(dateText, inst) {
	                    $(this).val(dateText);
	                }
	            });
	        });
	    </script>
	</body>
</html>