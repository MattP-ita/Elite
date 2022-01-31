<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="script/login.js"></script>
<link rel="stylesheet" href="css/Login.css" type="text/css">
<title>Elite | Login Gestore</title>
</head>
<body>
	<div id="content">	
		<div>
			<form name="formLoginGestore" action="<%=response.encodeURL("LoginGestoreControl") %>" method="post">	
				<input type="text" name="email" placeholder="E-mail"><br>
				<input type="password" id="pass" name="password" placeholder="Password:"><br>
				<div id="mostraPass"><input id="mostraPass" type="checkbox" onclick="showPassword()"><label for="mostraPass">Mostra Password</label></div>
				<input type="submit" value="Login">
			</form>
		</div>
	</div>
</body>
</html>