<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      	<title>Order | รับฝากซื้อสินค้าจากต่างประเทศเป็นเรื่องง่ายๆ</title>
    		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
    		<link rel="shortcut icon" href="img/title-3.ico" />
    		<link rel="stylesheet" type="text/css" href="css/travelDetail.css">
    		<link rel="stylesheet" type="text/css" href="css/style.css">
		    <link rel="stylesheet" type="text/css" href="css/registerform.css">
        <script src="js/checkOrder.js"></script>
    </head>
    <body >
		<%@ include file ="header.jsp" %>
		<div class="container travel_form" style="padding-top:10%;">
			<form id='formBack' action="search" method="POST"></form>
			<form name="myForm" onsubmit="return validateForm()"  action="orderproduct" method="POST"  enctype="multipart/form-data">
			<div class="col-md-3"></div><br />
			<ul>
			<li style="border-bottom:1px solid #000;">
				<h2><span class="glyphicon glyphicon-shopping-cart"></span>สั่งซื้อสินค้า</h2>
				<span class="required_notification">* Denotes Required Field</span>
			</li>
			<div class="col-md-6"><br />
			<li>
				<label><span class="glyphicon glyphicon-gift"></span> ชื่อสินค้า  </label>
				<input type="text" name="productName" class="form-control" /> <span id="productName_text" style="color:red;"></span>
			</li>
			<li>
				<label><span class="glyphicon glyphicon-usd"></span> ราคา  </label>
				<input type="number" name="price" class="form-control " />
					<%@include file="currencyMoney.html" %>
				<span id="price_text" style="color:red;"></span>
				<span id="currencies_text" style="color:red;"></span>
			</li>
			<li>
				<label><span class="glyphicon glyphicon-piggy-bank"></span> จำนวน  </label>
				<input type="number" name="amount" class="form-control" /> <span id="amount_text" style="color:red;"></span>
			</li>
			<li>
				<span class="btn btn-default btn-file">
				Product picture ... <input type="file" name="photo" accept="image/*"/>
				</span>
			</li>
			<li>
				<button type="submit" name="travelId" value="<%= request.getParameter("buyProduct")%>" class="btn btn-info">Order</button>
				<button type="submit" value="Cancel" form="formBack" class="btn btn-info">Cancel</button>
			</li>
			</ul>
			</form>
		</div>
    </body>
</html>
