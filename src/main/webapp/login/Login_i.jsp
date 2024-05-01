<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Login</title>
	    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
	
	    <style>
	        body {
	        	background-image: "images/soc.png";
	            background-color: #f8f9fa;
	            font-family: Arial, sans-serif;
	            padding: 50px;
	        }
	        .login-container {
	            max-width: 400px;
	            margin: auto;
	            background-color: #fff;
	            border-radius: 5px;
	            padding: 30px;
	            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
	        }
	        .login-container h2 {
	            text-align: center;
	            margin-bottom: 30px;
	        }
	        .login-container label {
	            font-weight: bold;
	        }
	        .login-container .btn-login {
	            width: 100%;
	        }
	    </style>
	</head>
	<body>
	    <div class="login-container">
	        <h2>Login</h2>
	        <s:form action="validateUserLogin">
	            <div class="form-group">
	                <label for="nome">Nome de usuário:</label>
	                <s:textfield cssClass="form-control" id="nome" name="usuarioVo.nome" required="true"/>
	            </div>
	            <div class="form-group">
	                <label for="senha">Senha:</label>
	                <s:password cssClass="form-control" id="senha" name="usuarioVo.senha" required="true"/>
	            </div>
	            <button type="submit" class="btn btn-primary btn-login">Login</button>
	        </s:form>
	    </div>
	    
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
	</body>
</html>
