function showPassword() {
  	var x = document.getElementById("pass");
	var y = document.getElementById("pass2");
  	if (x.type === "password") {
  		x.type = "text";
		y.type = "text";
  	} else {
  		x.type = "password";
		y.type = "password";
  	}
}