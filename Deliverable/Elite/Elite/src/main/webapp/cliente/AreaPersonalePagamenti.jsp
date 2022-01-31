<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="elite.bean.*, java.util.*"%>
<%
	Collection<?> pagamenti = (Collection<?>) request.getAttribute("pagamenti");
	Pagamento pagamento=(Pagamento)session.getAttribute("pagamento");
	if(pagamenti==null) {
		response.sendRedirect(response.encodeRedirectURL("./VisualizzazionePagamentiControl"));
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="../script/areaPersonale.js"></script>
<title>Area Personale</title>
</head>
<body>
<%@ include file="/cliente/AggiuntaPagamentoForm.jsp" %>
	<div style="display: table ;">
		<div style="display: table-layout: table-row ;">
			<div style="display: table-cell;">		
				<table>
					<tr>
						<td><a href="<%=response.encodeURL("AreaPersonale.jsp")%>">Dati Personali</a></td>
					</tr>
					<tr>
						<td>Metodi di Pagamenti</td>
					</tr>
					<tr>
						<td><a href="<%=response.encodeURL("AreaPersonaleIndirizzi.jsp")%>">Indirizzi di Spedizione</a></td>
					</tr>
				</table>
			</div>
			<button id="addPagamento">+</button>
			<div style="display: table-cell;">	
				<table>
				<%	
				if(pagamenti!= null && pagamenti.size()>0){	
					Iterator<?> it=pagamenti.iterator();
					while(it.hasNext()){
						Pagamento p=(Pagamento) it.next();
				%>
					<tr>
						<td><button value="<%=p.getId()%>" onclick="selectPagamento(this.value)"><%=p.getTipo()%><br>****<%=p.getNumero().substring(12) %></button></td>
					</tr>
				<%
					}
				}else{
				%>
				<tr><td>Nessun metodo di pagamento</td></tr>
				<%
				}
				%>	
				</table>		
			</div>
			<div style="display: table-cell;">
				<%	
				if(pagamento!= null){	
				%>
					<h3><%=pagamento.getNome() %></h3>
					<h2><%=pagamento.getNumero() %></h2>
					<a href="<%=response.encodeURL("EliminazionePagamentoControl?id="+pagamento.getId())%>">Rimuovi</a>
				<%
				}
				%>
			</div>
		</div>
	</div>
</body>
</html>