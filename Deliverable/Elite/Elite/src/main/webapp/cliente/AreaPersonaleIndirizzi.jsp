<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="elite.bean.*, java.util.*"%>
<%
	Collection<?> indirizzi = (Collection<?>) request.getAttribute("indirizzi");
	
	if(indirizzi==null) {
		response.sendRedirect(response.encodeRedirectURL("./VisualizzazioneIndirizziControl"));
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<title>Elite | Area Personale</title>
</head>
<body>
<%@ include file="/cliente/AggiuntaIndirizzoForm.jsp" %>
	<div style="display: table ;">
		<div style="display: table-layout: table-row ;">
			<div style="display: table-cell;">		
				<table>
					<tr>
						<td><a href="<%=response.encodeURL("AreaPersonale.jsp")%>">Dati Personali</a></td>
					</tr>
					<tr>
						<td><a href="<%=response.encodeURL("AreaPersonalePagamenti.jsp")%>">Metodi di Pagamento</a></td>
					</tr>
					<tr>
						<td>Indirizzi di Spedizione</td>
					</tr>
				</table>
			</div>
			<button id="addIndirizzo">+</button>
			<div style="display: table-cell;">
				<%	
				if(indirizzi!= null && indirizzi.size()>0){	
					Iterator<?> it=indirizzi.iterator();
					while(it.hasNext()){
						Indirizzo i=(Indirizzo) it.next();
				%>
					<div>
						<h2><%=i.getIndirizzo() %></h2>
						<h3><%=i.getProvincia() %></h3>
						<a href="<%=response.encodeURL("EliminazioneIndirizzoControl?id="+i.getId())%>">Rimuovi</a>
					</div>
				<%
					}
				}else{
				%>
					<p>Nessun indirizzo di spedizione</p>
				<%
				}
				%>			
			</div>
		</div>
	</div>
</body>
</html>