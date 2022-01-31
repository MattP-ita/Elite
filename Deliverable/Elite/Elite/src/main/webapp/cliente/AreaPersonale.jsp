<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="elite.bean.*, java.util.*"%>
<%
	Cliente c=(Cliente) session.getAttribute("Cliente");
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="../script/jquery-3.5.1.js"></script>
<script type="text/javascript" src="../script/areaPersonale.js"></script>
<link href="../css/AreaPersonale.css" rel="stylesheet">
<title>Elite | Area Personale</title>
</head>
<body>
	<div style="display: table ;">
		<div style="display: table-layout: table-row ;">
			<div style="display: table-cell;">		
				<table>
					<tr>
						<td>Dati Personali</td>
					</tr>
					<tr>
						<td><a href="<%=response.encodeURL("AreaPersonalePagamenti.jsp")%>">Metodi di Pagamenti</a></td>
					</tr>
					<tr>
						<td><a href="<%=response.encodeURL("AreaPersonaleIndirizzi.jsp")%>">Indirizzi di Spedizione</a></td>
					</tr>
				</table>
			</div>
			<div style="display: table-cell;">
				<input id="setMod" value="Modifica" type="button">
				<form name="formModDatiUtente" action="<%=response.encodeURL("ModificaDatiClienteControl") %>" method="post">
					<table>
						<tr>
							<td><label for="nome">Nome</label></td>
							<td class="userData"><%=c.getNome() %></td>
							<td><input class="inputMod hidden" type="text" name="nome" placeholder="<%=c.getNome()%>"></td>
						</tr>	
						<tr>
							<td><label for="telefono">Telefono</label></td>
							<td class="userData"><%=c.getTelefono() %></td>
							<td><input class="inputMod hidden"  type="text" name="telefono" placeholder="<%=c.getTelefono()%>"></td>
						</tr>	
						<tr>
							<td><label for="email">Email</label></td>
							<td class="userData"><%=c.getEmail() %></td>
							<td><input class="inputMod hidden"  type="text" name="email" placeholder="<%=c.getEmail()%>"></td>
						</tr>	
						<tr>
							<td><label for="password">Password</label></td>
							<td class="userData">*******</td>
							<td><input class="inputMod hidden"  type="text" name="password" placeholder="Password Attuale"></td>
							<td><input class="inputMod hidden"  type="text" name="password2" placeholder="Nuova Password"></td>
							<td><input class="inputMod hidden"  type="text" name="password3" placeholder="Conferma Password"></td>
						</tr>	
						<tr>
							<td colspan="2"><input type="submit" value="Salva"></td>
						</tr>		
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>