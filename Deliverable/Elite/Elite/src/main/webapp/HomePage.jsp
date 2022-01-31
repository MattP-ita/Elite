<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/flickity.css" rel="stylesheet">
<link href="css/HomePage.css" rel="stylesheet">
<title>Elite | Home Page</title>



</head>
<body>
	<%@include file="NavCliente.jsp"%>
	
<div class="carousel js-flickity">
  <!-- images from unsplash.com -->
  <div class="carouselCell">
    <img src="image/vinile1.jpg"/>
  </div>
  <div class="carouselCell">
    <img src="image/vinile2.jpg"/>
  </div>
  <div class="carouselCell">
    <img src="image/vinile3.jpg"/>
  </div>
  <div class="carouselCell">
    <img src="image/vinile4.jpg"/>
  </div>
  <div class="carouselCell">
    <img src="image/vinile1.jpg"/>
  </div>
  <div class="carouselCell">
    <img src="image/vinile2.jpg"/>
  </div>
  <div class="carouselCell">
    <img src="image/vinile3.jpg"/>
  </div>
  <div class="carouselCell">
    <img src="image/vinile4.jpg"/>
  </div>
  <div class="carouselCell">
    <img src="image/vinile1.jpg"/>
  </div>
</div>

	<br>
	<br>
	<h4 class="titolo">Genere</h4>
	
	<div class=container>
		<div class="card">
			<img src="image/vinile1.jpg" style="width:100%">
			<div class="cardGenere">
				<h4 class="sottoTitolo">Pop</h4>
			</div>
		</div>
		
		<div class="card">
			<img src="image/vinile1.jpg" style="width:100%">
			<div class="cardGenere">
				<h4 class="sottoTitolo">Classico</h4>
			</div>
		</div>
		
		<div class="card">
			<img src="image/vinile1.jpg" style="width:100%">
			<div class="cardGenere">
				<h4 class="sottoTitolo">Rock</h4>
			</div>
		</div>
		
	</div>
	
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<%@include file="Footer.jsp"%>

<script src="script/flickity.pkgd.js"></script>
</body>

</html>