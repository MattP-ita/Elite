<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="elite.bean.*, java.util.*"%>
<%
	Collection<?> pagamenti=(Collection<?>) request.getAttribute("pagamenti");
	Collection<?> indirizzi=(Collection<?>) request.getAttribute("indirizzi");
	Carrello carrello=(Carrello) session.getAttribute("carrello");
	
	if(pagamenti==null || indirizzi==null){
		response.sendRedirect(response.encodeRedirectURL("./CheckoutControl"));
		return;
	}
	if(carrello== null){
		response.sendRedirect(response.encodeRedirectURL("./LoginCliente.jsp"));
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/CheckoutCarrello.css" type="text/css">
<title>Elite | Checkout</title>
</head>
<body>
<%@ include file="/cliente/AggiuntaPagamentoForm.jsp" %>
<%@ include file="/cliente/AggiuntaIndirizzoForm.jsp" %>
	<div id="content">	
		<div>
			<a href="<%=response.encodeURL("/HomePageCliente.jsp") %>" class="logo"> Elite </a>
		</div>
		<div>
			<form id="acquistoForm" action="<%=response.encodeURL("CompletaAcquistoControl") %>" method="post"></form>
			<select form="acquistoForm" id="pagamento" name="idPagamento">
				<option selected value=""></option>
				<%	
				if(pagamenti.size()>0){	
					Iterator<?> it=pagamenti.iterator();
					while(it.hasNext()){
						Pagamento p=(Pagamento) it.next();
				%>
					<option value="<%=p.getId()%>"><%=p.getTipo()%> - ****<%=p.getNumero().substring(12) %></option>
				<%
					}
				}
				%>		
			</select>
			<button id="addPagamento">+</button>
		</div>
		<div>
			<select form="acquistoForm" id="indirizzo" name="idIndirizzo">
				<option selected value=""></option>
				<%	
				if(indirizzi.size()>0){	
					Iterator<?> it=indirizzi.iterator();
					while(it.hasNext()){
						Indirizzo i=(Indirizzo) it.next();
				%>
					<option value="<%=i.getId()%>"><%=i.getIndirizzo()%>, <%=i.getCitta()%>, <%=i.getCap()%> </option>
				<%
					}
				}
				%>		
			</select>
			<button id="addIndirizzo">+</button>
		</div>
		<div id="resoconto">
			<h4>Resoconto</h4>
			<table>
				<tr>
					<th style="width: 18%"></th>
					<th style="width: 50%"></th>
					<th style="width: 12%"></th>
					<th style="width: 20%; text-align: right;"></th>
				</tr>
				<%	
				if(carrello.getSize()>0){	
					Iterator<?> it=carrello.getItems().iterator();
					while(it.hasNext()){
						Vinile v=(Vinile) it.next();
				%>
					<tr>
						<td><img id="copertina" src="../LoadCopertinaControl?codiceV=<%=v.getId() %>" onerror="this.src='../images/NoCop.jpg'"></td>
						<td><%=v.getNome() %></td>
						<td><%=v.getQuantita() %></td>
						<td><%=v.getPrezzo()%></td>
					</tr>
				<%
					}
				%>
					<tr>
						<td colspan="4" style="text-align: right;"><%=carrello.calcolaTotale()%></td>
					</tr>
				<%
				}
				%>	
			</table>
		</div>
		<input form="acquistoForm" type="submit" value="Acquista">
	</div>
</body>
</html>