<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*" %>
<html>
	<head>
		<meta http-equiv="Content-Language" content="th">
		
		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="shortcut icon" href="img/title-3.ico" />
		<link rel="stylesheet" type="text/css" href="css/travelDetail.css">
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<script src="js/checkConfirm.js"></script>	
		<title>Travel | รับฝากซื้อสินค้าจากต่างประเทศเป็นเรื่องง่ายๆ</title>
	</head>
	<body>
	<%@ include file="header.jsp" %>
    <form id='formBack' action="travel.jsp" method="POST"></form>
	<form id='validateemail' action="validateemail" method="POST">
	<input type="hidden" name="country" value="<%= request.getParameter("country")%>">
		<input type="hidden" name="detail" value="<%= request.getParameter("detail")%>">
		<input type="hidden" name="hashtag" value="<%= request.getParameter("hashtag")%>">
		<input type="hidden" name="startDate" value="<%= request.getParameter("startDate")%>">
		<input type="hidden" name="endDate" value="<%= request.getParameter("endDate")%>">
		<input type="hidden" name="announceDate" value="<%= request.getParameter("announceDate")%>">
	</form>
  		<div class="container travel_form" style="padding-top:10%;">
			<div class="col-md-3"></div>
			<form action="inserttravel" method="POST" name="myForm" onsubmit="return validateForm()">
				<div class="col-md-3"></div><br />
				<ul>
					<li>
						<h2>Information!</h2>
					</li>
					<br />
				<div class="form-group">
					<label label class="control-label col-sm-2">ประเทศ : </label>
					<div class="col-sm-10 ">
						<%= request.getParameter("country")%>
					</div>
						<input type="hidden" name="country" value="<%= request.getParameter("country")%>">
				</div>
				<div class="form-group">
					<label label class="control-label col-sm-2">รายละเอียด : </label>
					<div class="col-sm-10 ">
						<%= request.getParameter("detail")%>
					</div>
						<input type="hidden" name="detail" value="<%= request.getParameter("detail")%>">
				</div>
				<div class="form-group">
					<label label class="control-label col-sm-2">HashTag ที่เพิ่ม : </label>
					<div class="col-sm-10 ">
						<%
						String hashtag = request.getParameter("hashtag");
						String[] hashtags = hashtag.split("#");
							for(int i = 1; i<hashtags.length; i++) {%>
							<button type="button" class="btn btn-info btn-xs">#<%= hashtags[i]%></button>
						<%}%>
					</div>
						<input type="hidden" name="hashtag" value="<%= request.getParameter("hashtag")%>">
				</div>
				<div class="form-group">
					<label label class="control-label col-sm-2">วันที่ไป : </label>
					<div class="col-sm-10 ">
						<%= request.getParameter("startDate")%>
					</div>
						<input type="hidden" name="startDate" value="<%= request.getParameter("startDate")%>">
				</div>
				<div class="form-group">
					<label label class="control-label col-sm-2">วันที่กลับ : </label>
					<div class="col-sm-10 ">
						<%= request.getParameter("endDate")%>
					</div>
						<input type="hidden" name="endDate" value="<%= request.getParameter("endDate")%>">
				</div>
				<div class="form-group">
					<label label class="control-label col-sm-2">วันที่กลับ : </label>
					<div class="col-sm-10 ">
						<%= request.getParameter("endDate")%>
					</div>
						<input type="hidden" name="announceDate" value="<%= request.getParameter("announceDate") %>">
				</div>
				<div class="form-group">
					<label label class="control-label col-sm-2">โปรดกรอกรหัสยืนยัน 5 หลัก : </label>
					<div class="col-sm-8">
						<input name="number" type="number" class="form-control"></input>
					</div>
					<div class="col-sm-2">
						<input type="hidden" name="randomNumber" value="${sessionScope.randomNumber}">
						<button type="submit" name="validateemail" form="validateemail" class="btn btn-info">ส่งรหัสอีกครั้ง</button>
				</div>
				<li style="float:left;">
					<button type="submit" name="travel" value='travel' class="btn btn-success">ยืนยัน</button>
					<button type="submit" name="travel" value='travel' form="formBack" class="btn btn-danger">ย้อนกลับ</button>			
				</li>
				</ul>
				</form>
			</div>	
			<div class="col-md-3"></div>
		</div>
	</body>
</html>
