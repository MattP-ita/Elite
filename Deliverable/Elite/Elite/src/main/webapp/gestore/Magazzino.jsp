<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="elite.bean.*, java.util.*"%>
<%
	Collection<?> vinili = (Collection<?>) request.getAttribute("vinili");
	Collection<?> artisti = (Collection<?>) request.getAttribute("artisti");
	Collection<?> generi = (Collection<?>) request.getAttribute("generi");
	
	if(vinili==null || artisti==null || generi==null) {
		response.sendRedirect(response.encodeRedirectURL("./FiltroViniliGestoreControl"));
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="../script/magazzinoScript.js"></script>
<title>Elite | Magazzino</title>
</head>
<body><h1>Magazzino</h1>
	<div id="addItems">
		<div id="addVinile">
			<fieldset><legend>Aggiunta Vinile</legend>
			<form action="<%=response.encodeURL("AggiuntaVinileControl") %>" method="post">
				<table>
					<tr>
						<td><label for="idV">ID</label></td>
						<td><input id="idV" type="text" name="codiceV"></td>
					</tr>
					<tr>
						<td><label for="nomeV"></label>Nome</td>
						<td><input id="nomeV" type="text" name="nomeV"></td>
					</tr>
					<tr>
						<td><label for="giriV">Giri</label></td>
						<td><select id="giriV" name="giri">
								<option selected value=""></option>
								<option value="33">33</option>
								<option value="45">45</option>
								<option value="78">78</option>
							</select></td>
					</tr>
					<tr>
						<td><label for="artistaV">Artista</label></td>
						<td><select id="artistaV" name="idArtista">
								<option selected value=""></option>
								<%	
								if(artisti!= null && artisti.size()>0){	
									Iterator<?> it=artisti.iterator();
									while(it.hasNext()){
										Artista a=(Artista) it.next();
								%>
									<option value="<%=a.getId()%>"><%=a.getNome() %></option>
								<%
									}
								}
								%>		
							</select></td>
					</tr>
					<tr>
						<td><label for="genereV">Genere</label></td>
						<td><select id="genereV" name="idGenere">
								<option selected value=""></option>
								<%
								if(generi.size()>0){
									Iterator<?> it=generi.iterator();
									while(it.hasNext()){
										Genere g=(Genere) it.next();
								%>			
									<option value="<%=g.getId() %>"><%=g.getNome() %></option>
								<%
									}
								}
								%>
							</select></td>
					</tr>
					<tr>
						<td><label for="prezzoV">Prezzo</label></td>
						<td><input id="prezzoV" type="number" name="prezzo" min="0.01" max="999" step="0.01"></td>
					</tr>
					<tr>
						<td><label for="quantitaV">Quantità</label></td>
						<td><input id="quantitaV" type="number" name="quantita" min="1" max="9999" step="1"></td>
					</tr>
					<tr>
						<td><input type="reset" value="Reset"></td>
						<td><input type="submit" value="Aggiungi"></td>
					</tr>
				</table>
			</form>
			</fieldset>
		</div>
		<div>
			<fieldset><legend>Artista</legend>
				<form action="<%=response.encodeURL("AggiuntaArtistaControl") %>" method="post">
					<input type="text" name="nomeA">
					<input type="submit" value="Conferma">
				</form>
				<form action="<%=response.encodeURL("ModificaArtistaControl") %>" method="post">
					<select id="artistaV" name="idArtista">
						<option selected value=""></option>
						<%	
						if(artisti!= null && artisti.size()>0){	
							Iterator<?> it=artisti.iterator();
							while(it.hasNext()){
								Artista a=(Artista) it.next();
						%>
							<option value="<%=a.getId()%>"><%=a.getNome() %></option>
						<%
							}
						}
						%>		
					</select>
					<input type="text" name="nomeA">
					<input type="submit" value="Conferma">
				</form>
			</fieldset>
		</div>
		<div>
			<fieldset><legend>Genere</legend>
				<form action="<%=response.encodeURL("AggiuntaGenereControl") %>" method="post">
					<input type="text" name="nomeG">
					<input type="submit" value="Conferma">
				</form>
				<form action="<%=response.encodeURL("ModificaGenereControl") %>" method="post">
					<select id="genereV" name="idGenere">
						<option selected value=""></option>
						<%
						if(generi.size()>0){
							Iterator<?> it=generi.iterator();
							while(it.hasNext()){
								Genere g=(Genere) it.next();
						%>			
							<option value="<%=g.getId() %>"><%=g.getNome() %></option>
						<%
							}
						}
						%>
					</select>
					<input type="text" name="nomeG">
					<input type="submit" value="Conferma">
				</form>
			</fieldset>
		</div>			
	</div>
	<div id="ricercaAvanzata" style="float: left;">
		<fieldset><legend>Ricerca avanzata</legend>
			<table>
				<tr>
					<td>
						<fieldset><legend>Nome</legend>
						<form name="formNomeRA" action="<%=response.encodeURL("FiltroViniliGestoreControl?action=ricercaNome") %>" method="post">
							<select name="nome" onchange="javascript:document.formNomeRA.submit();">
								<option selected value=""></option>
								<%	
								if(vinili!= null && vinili.size()>0){
									List<String> lettere=new ArrayList<String>();		
									boolean chiave=true;
									Iterator<?> it=vinili.iterator();
									while(it.hasNext()){
										chiave=true;
										Vinile v=(Vinile) it.next();
										String lettera=v.getNome().substring(0, 1);
										for(int i=0; i<lettere.size();i++){	
											String tmp=lettere.get(i);
											if(tmp.equals(lettera)){
												chiave=false;
											}
										}
										if(lettere.size()==0){
											lettere.add(lettera);
											chiave=false;
										}
										if(chiave){
											lettere.add(lettera);
										}
									}
									for(String lettera:lettere){
								%>
										<option value="<%=lettera%>"><%=lettera %></option>
								<%
									}
								}
								%>		
							</select>
						</form>
						</fieldset>
					</td>
				</tr>
				<tr>
					<td>
						<fieldset><legend>Artista</legend>
							<form name="formArtista" action="<%=response.encodeURL("FiltroViniliGestoreControl?action=ricercaArtista") %>" method="post">
								<select name="artista" onchange="javascript:document.formArtista.submit();">
									<option selected value=""></option>
									<%	
									if(artisti.size()>0){	
										Iterator<?> it=artisti.iterator();
										while(it.hasNext()){
											Artista a=(Artista) it.next();
									%>
											<option value="<%=a.getNome()%>"><%=a.getNome() %></option>
									<%
										}
									}
									%>		
								</select>
							</form>
						</fieldset>
					</td>
				</tr>
				<tr>
					<td>
						<fieldset><legend>Genere</legend>
							<form name="formGenere" action="<%=response.encodeURL("FiltroViniliGestoreControl?action=ricercaGenere")%>" method="post">
								<select name="genere" onchange="javascript:document.formGenere.submit();">
									<option selected value=""></option>
									<%
									if(generi.size()>0){
										Iterator<?> it=generi.iterator();
										while(it.hasNext()){
											Genere g=(Genere) it.next();
									%>			
											<option value="<%=g.getNome() %>"><%=g.getNome() %></option>
									<%
										}
									}
									%>
								</select>
							</form>
						</fieldset>
					</td>
				</tr>
				<tr>
					<td>				
						<fieldset><legend>Giri</legend>
							<form name="formGiri" action="<%=response.encodeURL("FiltroViniliGestoreControl?action=ricercaGiri")%>" method="post">
								<select name="giri" onchange="javascript:document.formGiri.submit();">
									<option selected value=""></option>
									<option value="33">33</option>
									<option value="45">45</option>
									<option value="78">78</option>
								</select>
							</form>
						</fieldset>
					</td>
				</tr>
				<tr>
					<td>
						<fieldset><legend>Prezzo</legend>							
							<input type="range" id="rangeInputPrice" name="rangeInputPrice" min="0" max="500" step="10" value="0" oninput="amountPrice.value=rangeInputPrice.value" onchange="sendPrice(this.value)">  
							<output id="amountPrice" name="amountPrice" for="rangeInputPrice">0</output>
						</fieldset>
					</td>
				</tr>
				<tr>
					<td>
						<fieldset><legend>Quantità</legend>							
							<input type="radio" id="sceltaQuantita" name="sceltaQuantita" value="minore">Minore di: |
							<input type="radio" id="sceltaQuantita" name="sceltaQuantita" value="maggiore">Maggiore di: <br>
							<input type="range" id="rangeInputQuantity" name="rangeInputQuantity" min="0" max="500" step="10" value="0" oninput="amountQuantity.value=rangeInputQuantity.value" onchange="sendQuantity(sceltaQuantita.checked, this.value)">  
							<output id="amountQuantity" name="amountQuantity" for="rangeInputQuantity">0</output>
						</fieldset>
					</td>
				</tr>
				<tr>								
					<td><a href="<%=response.encodeURL("FiltroViniliGestoreControl?action=reset")%>">reset</a><br></td>
				</tr>
			</table>
		</fieldset>
	</div>
	<div id="divVinili">
		<div id="viniliMagazzino">
			<table>
				<tr>
					<th></th>
					<th><a href="<%=response.encodeURL("FiltroViniliGestoreControl?action=sort&sort=nome") %>">Nome</a></th>
					<th><a href="<%=response.encodeURL("FiltroViniliGestoreControl?action=sort&sort=giri") %>">Giri</a></th>
					<th><a href="<%=response.encodeURL("FiltroViniliGestoreControl?action=sort&sort=artista") %>">Artista</a></th>
					<th><a href="<%=response.encodeURL("FiltroViniliGestoreControl?action=sort&sort=genere") %>">Genere</a></th>
					<th><a href="<%=response.encodeURL("FiltroViniliGestoreControl?action=sort&sort=prezzo") %>">Prezzo</a></th>
					<th><a href="<%=response.encodeURL("FiltroViniliGestoreControl?action=sort&sort=quantita") %>">Quantità</a></th>
					<th>Modifica</th>
				</tr>
				<%
					if(vinili!=null && vinili.size()>0){
						Iterator<?> it=vinili.iterator();
						while(it.hasNext()){
							Vinile v=(Vinile) it.next();
				%>
					<tr>		
						<td><form id="<%="formModV"+v.getId()%>" action="<%=response.encodeURL("ModificaVinileControl?id="+v.getId()) %>"><input type="hidden" name="id" value="<%=v.getId()%>"></form></td>	
						<td><input form="<%="formModV"+v.getId()%>" type="text" name="nomeV" placeholder="<%=v.getNome()%>"></td>
						<td><select form="<%="formModV"+v.getId()%>" id="giriV" name="giri">
								<option selected value=""><%=v.getGiri()%></option>
								<option value="33">33</option>
								<option value="45">45</option>
								<option value="78">78</option>
							</select></td>
						<td><select form="<%="formModV"+v.getId()%>" id="artistaV" name="idArtista">
								<option selected value=""><%=v.getArtista()%></option>
								<%	
								if(artisti!= null && artisti.size()>0){	
									Iterator<?> it2=artisti.iterator();
									while(it2.hasNext()){
										Artista a=(Artista) it2.next();
								%>
									<option value="<%=a.getId()%>"><%=a.getNome() %></option>
								<%
									}
								}
								%>		
							</select></td>	
						<td><select form="<%="formModV"+v.getId()%>" id="genereV" name="idGenere">
						<option selected value=""><%=v.getGenere()%></option>
						<%
						if(generi.size()>0){
							Iterator<?> it3=generi.iterator();
							while(it3.hasNext()){
								Genere g=(Genere) it3.next();
						%>			
							<option value="<%=g.getId() %>"><%=g.getNome() %></option>
						<%
							}
						}
						%>
					</select></td>
						<td><input form="<%="formModV"+v.getId()%>" id="prezzoV" type="number" name="prezzo" min="0.01" max="999" step="0.01" placeholder="<%=v.getPrezzo()%>"></td>
						<td><input form="<%="formModV"+v.getId()%>" id="quantitaV" type="number" name="quantita" min="1" max="9999" step="1" placeholder="<%=v.getQuantita()%>"></td>		
						<td><input form="<%="formModV"+v.getId()%>" type="submit" value="M"></td>
					</tr>
				<%
						}
					}else{
				%>
					<tr>			
						<td colspan="8">Nessun Vinile presente</td>
					</tr>				
				<%
					}
				%>
			</table>
		</div>
	</div>
</body>
</html>