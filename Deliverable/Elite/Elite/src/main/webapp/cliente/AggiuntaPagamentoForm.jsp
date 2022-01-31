<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="elite.bean.*, java.util.*, java.time.*, java.time.format.*"%>
<%
	LocalDateTime d = LocalDateTime.now();
	DateTimeFormatter formatterAnno=DateTimeFormatter.ofPattern("yy");
	DateTimeFormatter formatterMese=DateTimeFormatter.ofPattern("MM");

	int mese= Integer.parseInt(d.format(formatterMese));
	int anno= Integer.parseInt(d.format(formatterAnno));
%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript" src="../script/jquery-3.5.1.js"></script>
<script type="text/javascript" src="../script/modalPagamentoForm.js"></script>
<link rel="stylesheet" href="../css/ModalForm.css" type="text/css">
<link rel="stylesheet" href="../css/pagamentoForm.css" type="text/css">
</head>
<body>
	<div id="pagamentoModal" class="modal">
		<div class="modal-content">
			<span id="closeP">&times;</span><br>
			<h3>Aggiungi una carta</h3>
  			<form action="<%=response.encodeURL("AggiuntaPagamentoControl") %>" method="post">
				<table>
					<tr>
						<td><select id="tipo" name="tipo">
							<option selected value="">Tipo di carta</option>		
							<option value="America Express">America Express</option>							
							<option value="VISA">VISA</option>
							<option value="MasterCard">MasterCard</option>
						</select></td>
					</tr>
					<tr>
						<td><input type="text" name="nomeCompleto" placeholder="Nome sulla carta"></td>
					</tr>
					<tr>
						<td><input type="text" name="numero" placeholder="Numero della carta"></td>
					</tr>
					<tr>
						<td><select id="meseP" name="meseP">
							<%	for(int i=1;i<=12;i++){	
								String y=""+i;
									if(i<10) y="0"+i; 
									
									if(i==mese){%>
								<option selected="selected" value="<%=y%>"><%=y%></option>
							<%		}else{%>
								<option value="<%=y%>"><%=y%></option>
							<%		}	
								}%>
						</select>
						<select id="annoP" name="annoP">
							<option selected value="<%=anno %>">20<%=anno %></option>
							<%	for(int i=anno+1;i<=anno+20;i++){%>
								<option value="<%=i%>">20<%=i%></option>
							<%	} %>
						</select>
					</tr>
					<tr>
						<td colspan="2"><input type="submit"  value="Conferma"></td>
					</tr>
				</table>	
			</form>	
		</div>		
	</div>
</body>
</html>