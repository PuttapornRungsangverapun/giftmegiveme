function validateForm() {
	var IDcard = document.forms["myForm"]["IDcard"].value;
	alert(IDcard);
    var username = document.forms["myForm"]["username"].value;
    var password = document.forms["myForm"]["password"].value;
    var firstname = document.forms["myForm"]["firstname"].value;
    var lastname = document.forms["myForm"]["lastname"].value;
    var telephone = document.forms["myForm"]["telephone"].value;
    var email = document.forms["myForm"]["email"].value;
    var lineID = document.forms["myForm"]["lineID"].value;
    var address = document.forms["myForm"]["address"].value;

	if (validateIDCard(IDcard)) {

	}
    return false;
}

function validateIDCard(IDcard) {
	if (IDCard == null || IDCard == "") {
		document.getElementById('idcard_text').innerHTML = "*Press input ID Card";
		return false;
    } else if (IDCard.length < 13 || IDCard.length > 13) {
		document.getElementById('idcard_text').innerHTML = "*Press input 13 digit";
		return false;
	} else {
		document.getElementById('idcard_text').innerHTML = "";
		return false;
	}
	return true;
}