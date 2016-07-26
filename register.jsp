<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
	<head>
	<title>Registation | รับฝากซื้อสินค้าจากต่างประเทศเป็นเรื่องง่ายๆ</title>
		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="shortcut icon" href="img/title-3.ico" />
		<script src="js/function.js"></script>
		<script src="js/checkRegister.js"></script>
	</head>
<body style="overflow: scroll">
	<%@ include file ="header.jsp" %>
	<div class="container" style="padding-top:7%;">
		<a href="index.jsp">หน้าแรก</a>
		<span>> ลงทะเบียน</span><br/></br>
		<div class="col-lg-12 well">
		<div class="row">
		<form name="myForm" onsubmit="return validateForm()" action="registation" method="POST" enctype="multipart/form-data">
			<div class="form-group">
				<label label class="control-label col-sm-2">ID Card :</label>
				<div class="col-sm-10 ">
					<input type="number" name="IDcard" class="form-control " id="idcard" onchange='check_idcard()' placeholder="รหัสบัตรประชาชน 13 หลัก">
					<div id="idcard_text" style="color:red;"></div>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="idcard">Username :</label>
				<div class="col-sm-10">
					<input type="text" name="username" class="form-control" id="username" onchange="check_username()" placeholder="Enter Username">
					<span id="username_text" style="color:red;"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="idcard">Password :</label>
				<div class="col-sm-10">
					<input type="password" name="password" class="form-control" id="password" onchange="check_password()" placeholder="Enter Password">
					<span id="password_text" style="color:red;"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="idcard">ConfirmPassword :</label>
				<div class="col-sm-10">
					<input type="password" name="confirmPassword" class="form-control" id="confirmPassword" onchange="check_confirmPassword()" placeholder="Confirm Password">
					<span id="confirmPassword_text" style="color:red"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="idcard">Name :</label>
				<div class="col-sm-10">
					<input type="text" name="firstname" class="form-control" id="firstname" onchange='check_firstName()' placeholder="First Name">
					<span id="firstname_text" style="color:red;"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="idcard">Lastname :</label>
				<div class="col-sm-10">
					<input type="text" name="lastname" class="form-control" id="lastname" onchange='check_lastName()' placeholder="Last Name">
					<span id="lastName_text" style="color:red;"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="gender">Gender :</label>
				<div class="col-sm-10">
					<input type="radio" name="gender" value="m" checked> Male
					<input type="radio" name="gender" value="f"> Female
				</div>
			</div>
			<div class="control-label col-sm-12"></div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="lastname">Telephone :</label>
				<div class="col-sm-10">
					<input type="number" name="telephone" class="form-control" id="telephone" onchange='check_telephone()' placeholder="Phone: (xxx) - xxx - xxxx">
					<span id="telephone_text" style="color:red;"></span>
				</div>
			</div>			
			<div class="form-group">
				<label class="control-label col-sm-2" for="lastname">E-mail :</label>
				<div class="col-sm-10">
					<input type="email" name="email" class="form-control" id="email" onchange='check_email()' autocomplete="off" placeholder="email@example.com">
					<span id="email_text" style="color:red;"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="lastname">LineID :</label>
				<div class="col-sm-10">
				<input type="text" name="lineID" class="form-control" id="lineID" onchange='check_lineId()' autocomplete="off" placeholder="Line ID">
				<span id="lineId_text" style="color:red;"></span>
				</div>
			</div>
			<div class="form-group">
			<label class="control-label col-sm-2" for="address">Address :</label>
				<div class="col-sm-10">	
					<textarea name="address" id="address" class="form-control" rows="5" onchange='check_address()'></textarea>
					<span id="address_text" style="color:red;"></span>
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-sm-2" for="profilepicture">ProfilePicture :</label>
				<div class="col-sm-10">
					<div class="fileinput fileinput-new" data-provides="fileinput">
						<span class="btn btn-default btn-file">
							<span>Browse... </span><input type="file" name="photo" accept="image/*" /></span>
						<span class="fileinput-filename"></span>
							<span class="fileinput-new">No file chosen</span>
					</div>
				</div>
			</div>
			<div class="control-label col-sm-12"></div>
			<div class="form-group col-sm-2"></div>
			<div class="form-group col-sm-8">
				<input type="submit" class="btn btn-success" value="Confirm" />
				<input type="submit" class="btn btn-success" value="Cancel" />
			</div>
			<div class="form-group col-sm-2"></div>
			</form>
			</div>
		</div>
	</div>
</body>
</html>
