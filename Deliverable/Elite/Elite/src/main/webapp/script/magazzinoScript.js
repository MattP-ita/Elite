function sendPrice(range){	
		location.href="FiltroViniliGestoreControl?action=ricercaPrezzo&prezzoMax="+range;	
}

function sendQuantity(scelta, quantita){	
		location.href="FiltroViniliGestoreControl?action=ricercaQuantita&sceltaQuantita="+scelta+"&quantita="+quantita;	
}
