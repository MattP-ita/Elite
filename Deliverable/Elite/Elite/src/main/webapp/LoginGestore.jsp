<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Login Gestore</title>
</head>
<body>
	<form name="formLoginGestore" action="<%=response.encodeURL("LoginGestoreControl") %>" method="post">	
		<input type="text" name="email" placeholder="email"><br>
		<input type="password" name="password" placeholder="Password:"><br>
		<input type="submit" value="Login">
	</form>
</body>
</html>