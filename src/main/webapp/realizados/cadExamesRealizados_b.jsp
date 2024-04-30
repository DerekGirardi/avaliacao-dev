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
			<div class="row mt-5 mb-2">
				<div class="col-sm p-0">
					<s:form action="/filtrarExamesRealizados.action">
						<div class="input-group">
							<span class="input-group-text">
								<strong><s:text name="label.buscar.por"/></strong>
							</span>	
								<s:select  
									cssClass="form-select" 
									name="filtrar.opcoesCombo" 
									list="listaOpcoesCombo"  
									headerKey=""  
									headerValue="Escolha..." 
									listKey="%{codigo}" 
									listValueKey="%{descricao}"
									value="filtrar.opcoesCombo.codigo"									
								/>
								
								<s:textfield cssClass="form-control" id="nome" name="filtrar.valorBusca"/>
								<button class="btn btn-primary" type="submit"><s:text name="label.pesquisar"/></button>
						</div>
					</s:form>			
				</div>				
			</div>
			
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
							<th class="text-end mt-5"><s:text name="label.acao"/></th>
						</tr>
					</thead>
					
					<tbody>
						<s:iterator value="examesRealizados" >
							<tr>
								<td>${id}</td>
								<td>${exameid}</td>
								<td><s:property value="getNomeExamePorId(exameid)" default="-" /></td>
								<td>${funcionarioid}</td>
								<td><s:property value="getNomeFuncionarioPorId(funcionarioid)" default="-" /></td>
								<td>${data}</td>
								<td class="text-end">
									<s:url action="editarExamesRealizados" var="editar">
										<s:param name="exameRealizadoVo.id" value="id"></s:param>
									</s:url>

									<a href="${editar}" class="btn btn-warning text-white">
										<s:text name="label.editar"/>
									</a>

									<a href="#" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#confirmarExclusao${id}">
										<s:text name="label.excluir"/>
									</a>
								</td>
							</tr>
						</s:iterator>
					</tbody>
					
					<tfoot class="table-secondary">
						<tr>
							<td colspan="7" style="text-align: left">
								<s:url action="novoExamesRealizados" var="novo"/>
								<s:url action="gerarRelatorio" var="gerar"/>
								<div style="text-align: center">
									<a href="${novo}" class="btn btn-success" style="float: left">
										<s:text name="label.adicionar"/>
									</a>
									
									<s:url action="todosExames" var="exames"/>
									
									<a href="${exames}" class="btn btn-primary">
										<s:text name="label.exames"/>
									</a>
									
									<s:url action="todosFuncionarios" var="funcionarios"/>
									
									<a href="${funcionarios}" class="btn btn-primary">
										<s:text name="label.funcionarios"/>
									</a>
									
									<s:url action="todosExamesRealizados" var="examesRealizados"/>
									
									<a href="${examesRealizados}" class="btn btn-primary" style="background-color: #0032C1;cursor: default;pointer-events: none;">
										<s:text name="label.examesRealizados"/>
									</a>
									
									<a href="${gerar}" class="btn btn-success" style="float: right">
										<s:text name="label.gerarRelatorio"/>
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
		
		<s:iterator value="examesRealizados">
			<div class="modal fade" id="confirmarExclusao${id}" 
		    	data-bs-backdrop="static" data-bs-keyboard="false"
		    	tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
		    <div class="modal-dialog" role="document">
		    	<div class="modal-content">
		    		<div class="modal-header">
		    			<h5 class="modal-title"><s:text name="label.modal.titulo"/></h5>
		    			
		          		<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		        	</div>
		        	
		        	<div class="modal-body">
		          		<span><s:text name="label.modal.corpo"/></span>
		        	</div>
		        	
		        	<div class="modal-footer">
		          		<a class="btn btn-secondary" data-bs-dismiss="modal" aria-label="Close">
		            		<s:text name="label.nao"/>
		          		</a>
		          		
		          		<a href="<s:url action='excluirExamesRealizados'/>?exameRealizadoVo.id=${id}" class="btn btn-primary">
		            		<s:text name="label.sim"/>
		          		</a>
		        	</div>
		      	</div>
		    </div>
		  </div>
		</s:iterator>
		
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
	</body>
</html>