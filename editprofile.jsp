<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<html>
	<head>
	<title>EditProfile | รับฝากซื้อสินค้าจากต่างประเทศเป็นเรื่องง่ายๆ</title>
	<meta charset="utf-8">
	<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
	<link rel="shortcut icon" href="img/title-3.ico" />
	<script type="text/javascript">
	function chk_form(){
	$(":input + span.require").remove();
		$("#password ").each(function(){
			$(this).each(function(){
				if ($(this).val()=="") {
					$(this).after("<span class=require style=color:red> *จำเป็นต้องกรอก</span>");
				}
			});
		});
		$("#confirmPassword ").each(function(){
			$(this).each(function(){
				if ($(this).val()=="") {
					$(this).after("<span class=require style=color:red> *จำเป็นต้องกรอก</span>");
				}
			});
		});
		$("#picture ").each(function(){
			$(this).each(function(){
				if ($(this).val()=="") {
					$(this).after("<span class=require style=color:red> *จำเป็นต้องใส่รูปด้วย</span>");
				}
			});
		});
		if ($(":input").next().is(".require")==false) {
			return true;
		} else {
			return false;
		}
	}
	</script>
	</head>
<body style="overflow:scroll">
<%@ include file ="header.jsp" %>
	<div class="container" style="padding-top:10%;">
	<a href="index.jsp">หน้าแรก</a>
	<span>> แก้ไขประวัติส่วนตัว</span><br/></br>
		<div class="col-lg-12 well">
		<div class="row">
		<form id="fromedit" onsubmit="return chk_form()" action="edit" method="POST" enctype="multipart/form-data" class="signup_form" >
			<div class="form-group">
				<label class="control-label col-sm-2" for="idcard">Username :</label>
				<div class="col-sm-10">
					<input type="text" name="username" class="form-control" id="username" onchange="check_username()" value="${sessionScope.user.username}">
					<span id="username_text" style="color:red;"></span>
				</div>
			</div>
			<div class="form-group has-feedback">
				<label class="control-label col-sm-2" for="idcard">Password :</label>
				<div class="col-sm-10">
					<input type="password" name="password" class="form-control css-require" id="password" onchange="check_password()" placeholder="Enter Password">
					<span id="password_text" style="color:red;"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="idcard">ConfirmPassword :</label>
				<div class="col-sm-10">
					<input type="password" name="confirmPassword" class="form-control" id="confirmPassword" onchange="check_confirmPassword()" placeholder="Confirm Password" >
					<span id="confirmPassword_text" style="color:red"</span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="idcard">Name :</label>
				<div class="col-sm-10">
					<input type="text" name="firstname" class="form-control" id="firstname" onchange='check_firstName()' value="${sessionScope.member.firstName}">
					<span id="firstname_text" style="color:red;"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="idcard">Lastname :</label>
				<div class="col-sm-10">
					<input type="text" name="lastname" class="form-control" id="lastname" onchange='check_lastName()' value="${sessionScope.member.lastName}">
					<span id="lastName_text" style="color:red;"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="lastname">Telephone :</label>
				<div class="col-sm-10">
					<input type="number" name="telephone" class="form-control" id="telephone" onchange='check_telephone()' value="${sessionScope.member.phoneNumber}">
					<span id="telephone_text" style="color:red;"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="lastname">E-mail :</label>
				<div class="col-sm-10">
					<input type="email" name="email" class="form-control" id="email" onchange='check_email()' autocomplete="off" value="${sessionScope.member.email}">
					<span id="email_text" style="color:red;"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="lastname">LineID :</label>
				<div class="col-sm-10">
					<input type="text" name="lineID" class="form-control" id="lineID" onchange='check_lineId()' autocomplete="off" value="${sessionScope.member.lineId}">
					<span id="lineId_text" style="color:red;"></span>
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="address">Address :</label>
				<div class="col-sm-10">
					<input type="textarea" name="address" id="address" class="form-control" onchange='check_address()' value="${sessionScope.member.address}">
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
