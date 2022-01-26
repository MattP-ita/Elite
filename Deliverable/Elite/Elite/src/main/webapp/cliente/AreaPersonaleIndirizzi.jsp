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
<title>Area Personale</title>
</head>
<body>
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
			<div style="display: table-cell;">
				<div>
					<button>+</button>
				</div>
				<%	
				if(indirizzi!= null && indirizzi.size()>0){	
					Iterator<?> it=indirizzi.iterator();
					while(it.hasNext()){
						Indirizzo i=(Indirizzo) it.next();
				%>
					<div>
						<h2><%=i.getIndirizo() %></h2>
						<h3><%=i.getProvincia() %></h3>
					</div>
				<%
					}
				}else{
				%>
					<p>Nessun metodo di pagamento</p>
				<%
				}
				%>			
			</div>
		</div>
	</div>
</body>
</html>