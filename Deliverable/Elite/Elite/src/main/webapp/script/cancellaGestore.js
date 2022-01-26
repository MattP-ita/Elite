function cancellaGestore(id){
	var scelta=confirm("Sei sicuro?");
	if(scelta===true){
		location.href="EliminazioneGestoreControl?id="+id;
	}
}
