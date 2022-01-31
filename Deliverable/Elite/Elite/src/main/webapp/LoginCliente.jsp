<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg=(String) session.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="script/login.js"></script>
<link rel="stylesheet" href="css/Login.css" type="text/css">
<title>Login Cliente</title>
</head>
<body>
	<div id="content">	
		<div>
			<a href="<%=response.encodeURL("HomePageCliente.jsp") %>" class="logo"> Elite </a>
		</div>
		<div>
			<form name="formLoginCliente" action="<%=response.encodeURL("LoginClienteControl") %>" method="post">	
				<input type="text" name="email" placeholder="E-mail"><br>
				<input type="password" id="pass" name="password" placeholder="Password:"><br>
				<div id="mostraPass"><input id="mostraPass" type="checkbox" onclick="showPassword()"><label for="mostraPass">Mostra Password</label></div>
				<input type="submit" value="Login">
			</form>
			<a id="registra" href="<%=response.encodeURL("RegistrazioneCliente.jsp")%>">Registrati ora</a>
		</div>
	</div>
	<%if(msg!=null && !msg.equals("")){
		session.removeAttribute("msg");%>
		<div id="alert"><%=msg %></div>
	<%}%>	
</body>
</html>