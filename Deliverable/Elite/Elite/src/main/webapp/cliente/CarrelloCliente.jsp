<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="elite.bean.*, java.util.*"%>
<%
	Carrello carrello=(Carrello) session.getAttribute("carrello");
	if(carrello== null){
		response.sendRedirect(response.encodeRedirectURL("./LoginCliente.jsp"));
		return;
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/Carrello.css" type="text/css">
<script type="text/javascript" ></script>
<title>Elite | Carrellotitle></title>
</head>
<body>
	<h1>Carrello</h1>
	<div id="carrello">
		<%
		if (carrello.getSize() > 0) {
			Iterator<?> it = carrello.getItems().iterator();
			while (it.hasNext()) {
				Vinile v = (Vinile) it.next();
				
		%>
			<div class="vinileCarrello">
				<h2> <a href="<%=response.encodeURL("VisualizzazioneDettagliVinileControl?codiceV="+ v.getId())%>" > <%=v.getNome()%> </a> </h2> 
				<h3> <a href="<%=response.encodeURL("FiltroViniliCatalogoControl?action=ricercaArtista&artista="+ v.getArtista().getNome()) %>" > <%=v.getArtista().getNome()%> </a> </h3>
				<a href="<%=response.encodeURL("VisualizzazioneDettagliVinileControl?codiceV="+ v.getId()) %>" ><img class="img__prodotto" src="./CopertinaControl?codiceV=<%= v.getId()%>" onerror="this.src='../images/NoCop.jpg'"></a>
				<a href="<%=response.encodeURL("EliminazioneVinileCarrelloControl?codiceV="+ v.getId()) %>" >Rimuovi</a>
			</div>
		
		<%	
			}
		}else{
		%>
			<p style="padding:100px; font-size: 30px;">Nessun vinile nel Carrello</p>
		<%
		}
		%>
	</div>
	<a href="<%=response.encodeURL("CheckoutCarrello.jsp") %>">Procedi con l'acquisto</a>
</body>
</html>