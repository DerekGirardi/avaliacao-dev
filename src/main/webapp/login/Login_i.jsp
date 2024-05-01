<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
	    <meta charset="UTF-8">
	    <title>Login</title>
	</head>
	<body>
	    <h2>Login</h2>
	    <s:form action="validateUserLogin">
	        <label for="nome">Nome de usuário:</label>
	        <s:textfield cssClass="form-control" id="nome" name="usuarioVo.nome" required="true"/>
	        
	        <label for="senha">Senha:</label>
	        <s:textfield cssClass="form-control" id="senha" name="usuarioVo.senha" required="true"/>
	        <button class="btn btn-primary col-sm-4 offset-sm-1">Login</button>
	    </s:form>
	</body>
</html>
