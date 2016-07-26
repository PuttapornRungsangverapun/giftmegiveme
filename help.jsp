<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Gift Me | รับฝากซื้อสินค้าจากต่างประเทศเป็นเรื่องง่ายๆ</title>
		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
		<link rel="shortcut icon" href="img/title-3.ico" />
		<link rel="stylesheet" type="text/css" href="bootstrap/3.3.6/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<script src="js/checkHelp.js"></script>
	</head>
	<body>
	<%@ include file ="header.jsp" %>
		<div id="box">
			<center>
				<form action="emailsearching" method="POST" name="myForm" onsubmit="return validateForm()">
					<br/>
					<label>ค้นหาบัญชีผู้ใช้</label><br/><br/>
					อีเมล์ <input type="email" name="email" ></input>
					<span id="email_text" style="color:red;"></span><br/><br/>
				  <button type="submit" name="travel" value='travel' class="btn btn-info" >ยืนยัน</button>
				</form>
			</center>
		</div>
	</body>
</html>
