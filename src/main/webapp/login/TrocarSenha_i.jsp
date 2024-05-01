<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Trocar Senha</title>
	    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
	
	    <style>
	        body {
	            background-color: #f8f9fa;
	            font-family: Arial, sans-serif;
	            padding: 50px;
	        }
	        .password-change-container {
	            max-width: 400px;
	            margin: auto;
	            background-color: #fff;
	            border-radius: 5px;
	            padding: 30px;
	            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
	        }
	        .password-change-container h2 {
	            text-align: center;
	            margin-bottom: 30px;
	        }
	        .password-change-container label {
	            font-weight: bold;
	        }
	        .password-change-container .btn-save, .password-change-container .btn-return {
	            width: 100%;
	        }
	    </style>
	</head>
	<body>
	    <div class="password-change-container">
	        <h2>Trocar Senha</h2>
	        <s:form action="executeTrocarSenha">
	            <div class="form-group">
	                <label for=nome>Usuário:</label>
	                <s:textfield cssClass="form-control" id="nome" name="usuarioVo.nome" required="true"/>
	            </div>
	            <div class="form-group">
	                <label for="senha">Senha Atual:</label>
	                <s:password cssClass="form-control" id="senha" name="usuarioVo.senha" required="true"/>
	            </div>
	            <div class="form-group">
	                <label for="newpassword">Nova Senha:</label>
	                <s:password cssClass="form-control" id="newpassword" name="novaSenha" required="true"/>
	            </div>
	            <div class="form-group">
	                <label for="newpasswordconf">Confirmar Nova Senha:</label>
	                <s:password cssClass="form-control" id="newpasswordconf" name="novaSenhaConfirm" required="true"/>
	            </div>
	            <button type="submit" class="btn btn-primary btn-save">Salvar</button>
	            <a href="Login.action" class="btn btn-secondary btn-return mt-3">Retornar</a>
	        </s:form>
	    </div>
	    
	    <script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
	</body>
</html>
