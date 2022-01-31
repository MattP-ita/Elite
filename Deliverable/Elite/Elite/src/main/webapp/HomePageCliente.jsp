<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="elite.bean.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
</head>
<body>
	<a href="<%=response.encodeURL("./cliente/AreaPersonale.jsp") %>">Area Personale</a>
	<a href="<%=response.encodeURL("./cliente/CarrelloCliente.jsp") %>">Carrello</a>
	<a href="<%=response.encodeURL("./Catalogo.jsp") %>">Catalogo</a>
</body>
</html>