function validateForm() {
    var productName = document.forms["myForm"]["productName"].value;
    var price = document.forms["myForm"]["price"].value;
    var amount = document.forms["myForm"]["amount"].value;
  if (productName == null || productName == "") {
   document.getElementById('productName_text').innerHTML = "Press input productName";
   document.forms["myForm"]["productName"].focus();
      return false;
  } else {
   document.getElementById('productName_text').innerHTML = "";
  }

    if (price == null || price == "") {
      document.getElementById('price_text').innerHTML = "Press input price";
      document.forms["myForm"]["price"].focus();
      return false;
    } else if (price.length != 0) {
          for(var i=0; i <= price.length ; i++) {
            var checkString =price.charAt(i)
            if(checkString =="e") {
              document.getElementById('price_text').innerHTML = "can't input :e";
              document.forms["myForm"]["price"].focus();
              return false;
            } else {
              document.getElementById('price_text').innerHTML = "";
            }
          }
    }

    if (amount == null || amount == "") {
      document.getElementById('amount_text').innerHTML = "Press input amount";
      document.forms["myForm"]["amount"].focus();
      return false;
    } else if (amount.length != 0) {
          for(var i=0; i <= amount.length ; i++) {
            var checkString =amount.charAt(i)
            if(checkString =="e") {
              document.getElementById('amount_text').innerHTML = "can't input :e";
              document.forms["myForm"]["amount"].focus();
              return false;
            } else {
              document.getElementById('amount_text').innerHTML = "";
            }
          }
    }
}