<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
	    <meta charset="UTF-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	    <title>Logout</title>
	    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
	    <style>
	        body {
	            font-family: Arial, sans-serif;
	            padding: 50px;
	            text-align: center;
	        }
	        .logout-container {
	            max-width: 400px;
	            margin: auto;
	        }
	        .message {
	            margin-bottom: 20px;
	        }
	        .btn-login {
	            margin-top: 20px;
	        }
	    </style>
	</head>
	<body>
	    <div class="logout-container">
	        <h2>Usuário deslogado com sucesso.</h2>
	        <p class="message">Obrigado por utilizar.</p>
	        <a href="Login.action" class="btn btn-primary btn-login">Voltar para a página de login</a>
	    </div>

		<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
	</body>
</html>
