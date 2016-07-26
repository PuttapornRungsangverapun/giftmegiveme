function validateForm() {
    var email = document.forms["myForm"]["email"].value;
    if (email == null || email == "") {
     document.getElementById('email_text').innerHTML = "Press input Email";
     document.forms["myForm"]["email"].focus();
      return false;
    }
}