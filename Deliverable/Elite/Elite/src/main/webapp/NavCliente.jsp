<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/NavCliente.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<nav class="contenitoreNav" id="topNav">
		<div>
			<a href="<%=response.encodeURL("HomePage.jsp")%>" class="logoNav"> Elite </a>
			<a class="elemNav" href="">Carrello</a>
			<a class="elemNav" href="">Login</a>
    		<form class="elemNav " action="/action_page.php">
      			<input class="inputSearch" type="text" placeholder="Search.." name="search">
      			<button type="submit"><i class="fa fa-search"></i></button>
    		</form>
  		
			
			<a href="javascript:void(0);" class="icon" onclick="myFunction()">
    			<i class="fa fa-bars icone" id="fa-barsId"></i>
 			</a>
		</div>
	</nav>

<script>
function myFunction() {
  var x = document.getElementById("topNav");
  if (x.className === "contenitoreNav") {
    x.className += " responsive";
  } else {
    x.className = "contenitoreNav";
  }
}
</script>	
	
</body>
</html>
