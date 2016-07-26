function validateForm() {

    var randomNumber = document.forms["myForm"]["randomNumber"].value;
    var number = document.forms["myForm"]["number"].value;

	if (number != randomNumber) {
        alert("Press input number form email");
        return false;
	}
}