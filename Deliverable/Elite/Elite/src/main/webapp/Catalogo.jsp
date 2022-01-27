<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="elite.bean.*, java.util.*"%>
<%
	Collection<?> vinili = (Collection<?>) request.getAttribute("vinili");

	if(vinili==null) {
		response.sendRedirect(response.encodeRedirectURL("./VisualizzazioneCatalogoControl"));
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<title>Elite</title>
</head>
<body>
	<div>
		<%
		if ( vinili.size() > 0) {
			Iterator<?> it = vinili.iterator();
			while (it.hasNext()) {
				Vinile v = (Vinile) it.next();
				
		%>
			<div>
				<h2> <a href="<%=response.encodeURL("VisualizzazioneDettagliVinileControl?codiceV="+ v.getId())%>" > <%=v.getNome()%> </a> </h2> 
				<h3> <a href="<%=response.encodeURL("FiltroViniliClienti?action=artista&artista="+ v.getIdArtista()) %>" > <%=v.getArtista()%> </a> </h3>
				<a href="<%=response.encodeURL("VisualizzazioneDettagliVinileControl?codiceV="+ v.getId()) %>" ><img class="img__prodotto" src="./CopertinaControl?codiceV=<%= v.getId()%>" onerror="this.src='./images/NoCop.jpg'"></a>
			</div>
		
		<%	
			}
		}else{
		%>
			<p style="padding:100px; font-size: 30px;">Nessun vinile trovato</p>
		<%
		}
		%>
	</div>
</body>
</html>