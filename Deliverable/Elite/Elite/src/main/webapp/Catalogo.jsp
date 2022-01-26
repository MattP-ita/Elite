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
	<table>
		<tr>
			<th>Nome</th>
			<th>Artista</th>
			<th>Genere</th>
		</tr>
		<%
			if(vinili!=null && vinili.size()>0){
				Iterator<?> it=vinili.iterator();
				while(it.hasNext()){
					Vinile v=(Vinile) it.next();
		%>
			<tr>			
				<td><%=v.getNome()%></td>
				<td><%=v.getArtista() %></td>
				<td><%=v.getGenere() %></td>		
			</tr>
		<%
				}
			}else{
		%>
			<tr>			
				<td colspan="3">Nessun Vinile presente</td>
			</tr>				
		<%
			}
		%>
	</table>
</body>
</html>