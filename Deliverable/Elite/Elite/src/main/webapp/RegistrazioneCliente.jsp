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
<title>Registrazione</title>
</head>
<body>
	<div id="content">	
		<div>
			<a href="<%=response.encodeURL("HomePageCliente.jsp") %>" class="logo"> Elite </a>
		</div>
		<div>
			<form action="<%=response.encodeURL("RegistrazioneClienteControl")%>" method="post"> 
				<input type="text" name="nome" placeholder="Nome"><br>
				<input type="text" name="telefono" placeholder="Telefono"><br>
				<input type="text" name="email" placeholder="E-mail"><br>
				<div class="tooltip"><input type="password" id="pass" name="password" placeholder="Password"><span id="stt1" class="tooltiptext"><strong>Formato Password:</strong><br>Almeno una lettera Maiuscola<br>Alemeno una lettera minuscola<br>Almeno un numero</span></div><br>
				<div class="tooltip"><input type="password" id="pass2" name="password2" placeholder="Conferma Password"><span id="stt2" class="tooltiptext"><strong>Confermare la password</strong></span></div><br>
				<div id="mostraPass"><input id="mostraPass" type="checkbox" onclick="showPassword()"><label for="mostraPass">Mostra Password</label></div>
				<input type="submit" value="Conferma">
			</form>
		</div>
	</div>
	<%if(msg!=null && !msg.equals("")){
		session.removeAttribute("msg");%>
		<div id="alert"><%=msg %></div>
	<%}%>
</body>
</html>