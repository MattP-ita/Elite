<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="elite.bean.*, java.util.*"%>
<%
Vinile vinile=(Vinile) request.getAttribute("vinile");

if(vinile==null){
	response.sendRedirect(response.encodeRedirectURL("./Catalogo.jsp"));
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<title>Elite | Dettagli Vinile</title>
</head>
<body>
	<div>
		<div>
			<h1><%=vinile.getNome() %></h1>
		</div>
		<div>
			<h2>Artista: <%=vinile.getArtista().getNome() %></h2>
			<h2>Genere:	<%=vinile.getGenere().getNome() %></h2>	
			<% 
				if (vinile.getQuantita()>0) {
			%>
					<h2 style="color: green;">Disponibile</h2>
			<%
				} else{  
			%>
					<h2 style="color:red">Non Disponibile</h2>
			<%
				} 
			%>	
			<h2>Giri: <%=vinile.getGiri() %></h2>				
			<h2>Prezzo: <%=vinile.getPrezzo() %></h2>
			<h2>Quantità: <%=vinile.getQuantita() %></h2>
			
			<form action="<%=response.encodeURL("cliente/AggiuntaVinileCarrelloControl?codiceV="+vinile.getId()) %>" method="post">
				<label for="Quantità">Quantita:</label>
				<select name="quantita">
					<%
					for(int i=1;i<=vinile.getQuantita();i++){
					%>
						<option value="<%=i %>"><%=i %></option>
					<%
					} 
					%>					
				</select>
				<input type="submit" value="Aggiungi al carrello">
			</form>
		</div>
	</div>
</body>
</html>