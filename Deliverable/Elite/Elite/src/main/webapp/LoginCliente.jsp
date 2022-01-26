<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Login Cliente</title>
</head>
<body>
	<form name="formLoginCliente" action="<%=response.encodeURL("LoginClienteControl") %>" method="post">	
		<input type="text" name="email" placeholder="email"><br>
		<input type="password" name="password" placeholder="Password:"><br>
		<input type="submit" value="Login">
	</form>
</body>
</html>