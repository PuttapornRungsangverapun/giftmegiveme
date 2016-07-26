function validateForm() {
    var IDcard = document.forms["myForm"]["IDcard"].value;
    var username = document.forms["myForm"]["username"].value;
    var password = document.forms["myForm"]["password"].value;
    var confirmPassword = document.forms["myForm"]["confirmPassword"].value;
    var firstname = document.forms["myForm"]["firstname"].value;
    var lastname = document.forms["myForm"]["lastname"].value;
    var telephone = document.forms["myForm"]["telephone"].value;
    var email = document.forms["myForm"]["email"].value;
    var lineID = document.forms["myForm"]["lineID"].value;
    var address = document.forms["myForm"]["address"].value;
    if (IDcard == ""  || IDcard == null) {
        alert("Press input IDcard");
        return false;
    }
    if (IDcard.length != 13) {
        alert("Press input 13 digit");
        return false;
    }
    if (IDcard.length == 13) {
      for(var i=0; i <= IDcard.length ; i++) {
        var checkString =IDcard.charAt(i)
        if(checkString =="e"){
          alert("can't input :e");
          return false;
        }
      }
    }
     if (username == ""  || username == null) {
        alert("Press input username");
        return false;
    }
     if (password == ""  || password == null) {
        alert("Press input password");
        return false;
    }
    if (confirmPassword == ""  || confirmPassword == null) {
       alert("Press input confirmPassword");
       return false;
   }
   else if (confirmPassword != password) {
      alert("Press check Password or ConfirmPassword");
      return false;
   }
     if (firstname == ""  || firstname == null) {
        alert("Press input firstname");
        return false;
    }
     if (lastname == ""  || lastname == null) {
        alert("Press input lastname");
        return false;
    }
     if (telephone == ""  || telephone == null) {
        alert("Press input telephone");
        return false;
    }
     if (telephone.length != 10) {
         alert("Press input 10 digit");
         return false;
     }
     if (telephone.length == 10) {
        for(var i=0; i <= telephone.length ; i++) {
          var checkString =telephone.charAt(i)
          if(checkString =="e"){
            alert("can't input :e");
            return false;
          }
        }
     }
     if (email == ""  || email == null) {
        alert("Press input email");
        return false;
    }
     if (lineID == ""  || lineID == null) {
        alert("Press input lineID");
        return false;
    }
     if (address == ""  || address == null) {
        alert("Press input address");
        return false;
    }

}
