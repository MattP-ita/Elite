<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="elite.bean.*, java.util.*"%>
<%
	Collection<?> gestori = (Collection<?>) request.getAttribute("gestori");

	if(gestori==null) {
		response.sendRedirect(response.encodeRedirectURL("./VisualizzazioneGestoriControl"));
		return;
	}
	String msgError= (String) request.getAttribute("msgError");
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="../script/cancellaGestore.js"></script>
<title>Home Page Admin</title>
</head>
<body>
	<form name="formAddGestore" action="<%=response.encodeURL("AggiuntaGestoreControl") %>" method="post">
		<table>
			<tr>
				<td><label for="nomeGestore">Nome</label></td>
				<td><input id="nomeGestore" type="text" name="nome"></td>
			</tr>
			<tr>
				<td><label for="emailGestore">Email</label></td>
				<td><input id="emailGestore" type="text" name="email"></td>
			</tr>
			<tr>
				<td><label for="passwordGestore">Password</label></td>
				<td><input id="passwordGestore" type="password" name="password"></td>
			</tr>
			<tr>
				<td><label for="password2Gestore">Conferma Password</label></td>
				<td><input id="password2Gestore" type="password" name="password2"></td>
			</tr>
			<tr>
				<td colspan="2"><input id="submitAddGestore" type="submit" value="Conferma"></td>
			</tr>
		</table>
	</form>
	<hr>
	<table>
		<tr>
			<th></th>
			<th>Nome</th>
			<th>Email</th>
			<th>Password</th>
			<th>Modifica</th>
			<th>Cancella</th>
		</tr>
		<%
			if(gestori!=null && gestori.size()>0){
				Iterator<?> it=gestori.iterator();
				while(it.hasNext()){
					Gestore g=(Gestore) it.next();
		%>
	
			<tr>			
				<td><form id="<%="formMod"+g.getId()%>" action="<%=response.encodeURL("ModificaGestoreControl?id="+g.getId()) %>"><input type="hidden" name="id" value="<%=g.getId()%>"></form></td>
				<td><input form="<%="formMod"+g.getId()%>" type="text" name="nome" placeholder="<%=g.getNome()%>"></td>
				<td><input form="<%="formMod"+g.getId()%>" type="text" name="email" placeholder="<%=g.getEmail()%>"></td>
				<td><input form="<%="formMod"+g.getId()%>" type="text" name="password" placeholder="***********"></td>
				<td><input form="<%="formMod"+g.getId()%>" type="submit" value="M"></td>
				<td><button id="cancella" onclick="cancellaGestore(<%=g.getId()%>)">C</button></td>
			</tr>
		<%
				}
			}else{
		%>
			<tr>			
				<td colspan="3">Nessun Gestore presente</td>
			</tr>				
		<%
			}
		%>
	</table>
</body>
</html>