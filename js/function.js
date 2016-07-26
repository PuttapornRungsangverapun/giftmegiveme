/*$(document).ready(function(){
	$('#myDropdown').slideUp();
    $('.dropdown-menu').find('form').click(function (e) {
        e.stopPropagation();
    });

	$('#dropbtn').on('click',function(){
		 $('#myDropdown').slideToggle();
	});
});
/*window.onclick = function(event) {
  if (!event.target.matches('#dropbtn')) {

    var dropdowns = document.getElementsByClassName("dropdown-content");
    var i;
    for (i = 0; i < dropdowns.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}*/

function check_idcard() {
	var IDCard = document.getElementById('idcard').value;

	if (IDCard == null || IDCard == "") {
		document.getElementById('idcard_text').innerHTML = "*Press input ID Card";
		document.forms["myForm"]["IDcard"].focus();
  } else if (IDCard.length < 13 || IDCard.length > 13) {
		document.getElementById('idcard_text').innerHTML = "*Press input 13 digit";
		document.forms["myForm"]["IDcard"].focus();
	} else {
		document.getElementById('idcard_text').innerHTML = "";
		document.forms["myForm"]["IDcard"].focus();
	}
}
function check_username() {
	var username = document.getElementById('username').value;
	if (username == null || username == "") {
		document.getElementById('username_text').innerHTML = "*Press input Username";
		document.forms["myForm"]["username"].focus();
	} else {
		document.getElementById('username_text').innerHTML = "";
	}
}
function check_password() {
	var password = document.getElementById('password').value;

	if (password == null || password == "") {
		document.getElementById('password_text').innerHTML = "*Press input password";
		document.forms["myForm"]["password"].focus();
  } else if (password.length < 6) {
		document.getElementById('password_text').innerHTML = "*Press input more than 5 digit";
		document.forms["myForm"]["password"].focus();
	} else {
		document.getElementById('password_text').innerHTML = "";
	}
}
function check_confirmPassword() {
	var password = document.getElementById('password').value;
	var confirmPassword = document.getElementById('confirmPassword').value;
	if (confirmPassword != password) {
		document.getElementById('confirmPassword_text').innerHTML = "*Press check Password";
		document.forms["myForm"]["confirmPassword"].focus();
	} else {
		document.getElementById('confirmPassword_text').innerHTML = "";
	}
}
function check_firstName() {
		var firstname = document.getElementById('firstname').value;
		if (firstname == null || firstname == "") {
			document.getElementById('firstname_text').innerHTML = "Press input firstname";
			document.forms["myForm"]["firstname"].focus();
		} else {
			document.getElementById('firstname_text').innerHTML = "";
		}
}
function check_lastName() {
		var lastname = document.getElementById('lastname').value;
		if (lastname == null || lastname == "") {
			document.getElementById('lastName_text').innerHTML = "Press input lastname";
			document.forms["myForm"]["lastname"].focus();
		} else {
			document.getElementById('lastname_text').innerHTML = "";
		}
}
function check_telephone() {
		var telephone = document.getElementById('telephone').value;
		if (telephone == null || telephone == "") {
			document.getElementById('telephone_text').innerHTML = "Press input telephone";
			document.forms["myForm"]["telephone"].focus();
		} else if (telephone.length != 10) {
			document.getElementById('telephone_text').innerHTML = "*Press input 10 digit";
			document.forms["myForm"]["telephone"].focus();
		} else {
			document.getElementById('telephone_text').innerHTML = "";
		}
}
function check_email() {
		var email = document.getElementById('email').value;
		if (email == null || email == "") {
			document.getElementById('email_text').innerHTML = "Press input email";
			document.forms["myForm"]["email"].focus();
		} else {
		document.getElementById('email_text').innerHTML = "";
		}
}
function check_lineId() {
		var lineID = document.getElementById('lineID').value;
		if (lineID == null || lineID == "") {
			document.getElementById('lineId_text').innerHTML = "Press input lineID";
			document.forms["myForm"]["lineID"].focus();
		} else {
		document.getElementById('lineId_text').innerHTML = "";
		}
}
function check_address() {
		var address = document.getElementById('address').value;
		if (address == null || address == "") {
			document.getElementById('address_text').innerHTML = "Press input address";
			document.forms["myForm"]["address"].focus();
		} else {
		document.getElementById('address_text').innerHTML = "";
		}
}
