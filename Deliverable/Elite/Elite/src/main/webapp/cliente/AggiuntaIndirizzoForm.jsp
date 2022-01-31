<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="elite.bean.*, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<title>Elite | Indirizzi</title>
<script type="text/javascript" src="../script/jquery-3.5.1.js"></script>
<script type="text/javascript" src="../script/modalIndirizzoForm.js"></script>
<link rel="stylesheet" href="../css/ModalForm.css" type="text/css">
</head>
<body>
	<div id="indirizzoModal">
		<div class="modal-content">
			<span id="closeI">&times;</span>
			<form action="<%=response.encodeURL("AggiuntaIndirizzoControl") %>" method="post">
				<table>
					<tr>
						<td><label for="nomeCompleto">Nome</label></td>
						<td><input type="text" name="nomeCompleto"></td>
					</tr>
					<tr>
						<td><label for="telefono">Telefono</label></td>
						<td><input type="text" name="telefono"></td>
					</tr>
					<tr>
						<td><label for="indirizzo">Indirizzo</label></td>
						<td><input type="text" name="indirizzo"></td>
					</tr>
					<tr>
						<td><label for="regione">Regione</label></td>
						<td><input type="text" name="regione"></td>
					</tr>
					<tr>
						<td><label for="provincia">Provincia</label></td>
						<td><input type="text" name="provincia"></td>
					</tr>
					<tr>
						<td><label for="citta">Città</label></td>
						<td><input type="text" name="citta"></td>
					</tr>
					<tr>
						<td><label for="cap">CAP</label></td>
						<td><input type="text" name="cap"></td>
					</tr>
					<tr>
						<td><label for="descrizione">Descrizione</label></td>
						<td><textarea name="descrizione"></textarea></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Conferma"></td>
					</tr>
				</table>	
			</form>	
		</div>
	</div>
</body>
</html>