<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="elite.bean.*, java.util.*"%>
<%
	Collection<?> vinili = (Collection<?>) request.getAttribute("vinili");
	Collection<?> artisti = (Collection<?>) request.getAttribute("artisti");
	Collection<?> generi = (Collection<?>) request.getAttribute("generi");

	if(vinili==null || artisti==null || generi==null) {
		response.sendRedirect(response.encodeRedirectURL("./VisualizzazioneCatalogoControl"));
		return;
	}
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/Catalogo.css" type="text/css">
<title>Elite</title>
</head>
<body>
	<div id="ricercaAvanzata" style="float: left;">
		<fieldset><legend>Ricerca avanzata</legend>
			<table>
				<tr>
					<td>
						<fieldset><legend>Nome</legend>
						<form name="formNomeRA" action="<%=response.encodeURL("FiltroViniliCatalogoControl?action=ricercaNome") %>" method="post">
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
							<form name="formArtista" action="<%=response.encodeURL("FiltroViniliCatalogoControl?action=ricercaArtista") %>" method="post">
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
							<form name="formGenere" action="<%=response.encodeURL("FiltroViniliCatalogoControl?action=ricercaGenere")%>" method="post">
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
							<form name="formGiri" action="<%=response.encodeURL("FiltroViniliCatalogoControl?action=ricercaGiri")%>" method="post">
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
							<form name="formQuantita" action="<%=response.encodeURL("FiltroViniliCatalogoControl?action=ricercaPrezzo")%>" method="post">											
								<input type="range" id="rangeInputPrice" name="rangeInputPrice" min="0" max="500" step="10" value="0" oninput="amountPrice.value=rangeInputPrice.value" onchange="javascript:document.formQuantita.submit();">  
								<output id="amountPrice" name="amountPrice" for="rangeInputPrice">0</output>
							</form>
						</fieldset>
					</td>
				</tr>
				<tr>								
					<td><a href="<%=response.encodeURL("FiltroViniliCatalogoControl?action=reset")%>">reset</a><br></td>
				</tr>
			</table>
		</fieldset>
	</div>
	<div id="catalogo">
		<%
		if (vinili.size() > 0) {
			Iterator<?> it = vinili.iterator();
			while (it.hasNext()) {
				Vinile v = (Vinile) it.next();
				
		%>
			<div class="vinileCatalogo">
				<h2> <a href="<%=response.encodeURL("VisualizzazioneDettagliVinileControl?codiceV="+ v.getId())%>" > <%=v.getNome()%> </a> </h2> 
				<h3> <a href="<%=response.encodeURL("FiltroViniliCatalogoControl?action=ricercaArtista&artista="+ v.getArtista().getNome()) %>" > <%=v.getArtista().getNome()%> </a> </h3>
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