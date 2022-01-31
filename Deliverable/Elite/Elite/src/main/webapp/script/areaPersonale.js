$(document).ready(function(){
	$("#setMod").click(function(){		
		for(i = 0; i < 4; i++){
			$(".userData").eq(i).toggle("slide");
		}	
		setTimeout(function() {
   			for(i = 0; i < 6; i++){
				$(".inputMod").eq(i).css("visibility", "visible");
			}	
		}, 1500);
		if($("#setMod").val()=="Modifica"){			
			$("#setMod").val("Annulla");
		}else{
			for(i = 0; i < 6; i++){
				$(".inputMod").eq(i).css("visibility", "hidden");
			}
			$("#setMod").val("Modifica");
		}
	});
});


function selectPagamento(id){	
	location.href="SelectPagamentoControl?id="+id;
}

