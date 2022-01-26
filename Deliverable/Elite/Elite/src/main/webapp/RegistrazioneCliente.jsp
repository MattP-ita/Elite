<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Registrazione</title>
</head>
<body>
	<form action="<%=response.encodeURL("RegistrazioneClienteControl")%>" method="post"> 
		Nome <input type="text" name="nome"><br>
		Telefono <input type="text" name="telefono"><br>
		Email <input type="text" name="email"><br>
		Password <input type="password" name="password"><br>
		Conferma Password<input type="password" name="password2"><br>
		<input type="submit" value="Conferma">
	</form>
</body>
</html>