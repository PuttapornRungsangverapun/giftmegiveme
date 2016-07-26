<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*" %>
<%

	Date date = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	String dateGo = dateFormat.format(date);

	Date dates = new Date();
	SimpleDateFormat dateFormats = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
	String dateNow = dateFormats.format(dates);
%>
<html>
	<head>
		<meta http-equiv="Content-Language" content="th">
		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
		<link rel="shortcut icon" href="img/title-3.ico" />
		<link rel="stylesheet" type="text/css" href="css/travelDetail.css">
		<script src="js/jquery-1.12.4.min.js"></script>
		<script src="js/hashtag.js"></script>
		<script src="js/checkTravel.js"></script>

		<title>Travel | รับฝากซื้อสินค้าจากต่างประเทศเป็นเรื่องง่ายๆ</title>
	</head>
	<body>
	<%@ include file="header.jsp" %>
	<c:set var="username" value="${user.username}" />
	<c:if test="${username == null}">
		<meta http-equiv="refresh" content="0; url=../giftmegiveme/register.jsp" />
	</c:if>
	<c:if test="${username != null}">
	<div class="container" style="padding-top:10%;">
		<a href="index.jsp">หน้าแรก</a>
		<span>> ไปเที่ยวไหน</span><br/></br>
	</div>
	<div class="container travel_form">
		<form id='formBack' action="index.jsp" method="POST"></form>
		<form id="formReset" action="" method="POST"></form>
		<form name="myForm" onsubmit="return validateForm()" action="validateemail" method="POST">
			<div class="col-md-3"></div><br />
			<ul>
				<li>
					<h2>Information!</h2>
					<span class="required_notification">* Denotes Required Field</span>
				</li>
				<br />
			<div class="form-group">
				<label label class="control-label col-sm-2">เลือกประเทศที่ไป</label>
				<div class="col-sm-10">
					<%@include file="country.html" %>
				</div>
			</div>
			<div class="form-group">
				<label label class="control-label col-sm-2" for="detail">รายละเอียดสถานที่ท่องเที่ยว</label>
				<div class="col-sm-10">
					<textarea name="detail" id="detail" class="form-control" rows="5"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label label class="control-label col-sm-2">HashTag</label>
				<div class="col-sm-8">
					<input type="text" id="hashtag" class="form-control" placeholder="เพิ่ม hashtag เพื่อง่ายต่อการค้นหา"></input>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-2"></div>
				<div class="col-sm-8" style="margin-left:17%;">
					<br/>
					<span class="glyphicon glyphicon-tags" style="color:#337ab7;"></span>
					<span class="hashtagList" style="margin-left:1%;"></span>
				</div>
			</div>
			<div class="col-sm-12"><br/></div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="startDate">วันที่ไป</label>
				<div class="col-sm-10">
					<input type="date" name="startDate" min="<%= dateGo %>" id="startDate" class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="endDate">วันที่กลับ</label>
				<div class="col-sm-10">
					<input type="date" name="endDate" min="<%= dateGo %>" id="endDate" class="form-control">
				</div>
			</div>
				<li style="float:right;">
					<div class="hashtag" style="display:none"><input type="text" name="hashtag" id="hashtagSend"></div>
					<input type="hidden" name="announceDate" value="<%= dateNow %>">
					<button type="submit" name="travel" value='travel' class="btn btn-info" >ยืนยัน</button>
					<button type="submit" name="travel" value='travel' form="formReset" class="btn btn-danger">ยกเลิก</button>
					<button type="submit" name="remove" value='travel' form="formBack" class="btn btn-success">ย้อนกลับ</button>

				</li>
			</ul>
		</form>
	</div>
	</c:if>
	</body>
</html>
