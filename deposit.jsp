<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import="java.text.SimpleDateFormat" %>

<html>
	<head>
	<title>Deposits | รับฝากซื้อสินค้าจากต่างประเทศเป็นเรื่องง่ายๆ</title>
	<meta http-equiv="Content-Language" content="th">
	<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/orderstyle.css">
	<link rel="shortcut icon" href="img/title-3.ico"/>
	<script src="https://code.getmdl.io/1.1.3/material.min.js"></script>
	<link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.indigo-pink.min.css">
	<!-- Material Design icon font -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons"></head>

	<body>
	<%@ include file ="header.jsp" %>
	<div class="container" style="padding-top:10%;">
	<a href="index.jsp">หน้าแรก</a>
	<span>> รายการรับฝาก</span><br/></br>
	<div class="table-responsive">
		<table class="table table-hover">
			<thead>
				<tr class="success">
					<th>รหัสการท่องเที่ยว</th>
					<th>ประเทศ</th>
					<th>รายละเอียด</th>
					<th>วันไป</th>
					<th>วันกลับ</th>
					<th>เวลาโพส</th>
					<th>ปิด/เปิด รับสินค้า</th>
					<th>รายละเอียด</th>
				</tr>
			</thead>
		<tbody>
			<form id='formOpen' action="deposit" method="POST"></form>
			<form id='formClose' action="deposit" method="POST"></form>
			<form action="orderlist" method="POST">
				<c:forEach items="${travelList}" var="travel">
					<c:choose>
						<c:when test="${travel.status.equals('0')}">
							<tr class="danger"></c:when>
						<c:otherwise>
							<tr class="info"></c:otherwise>
						</c:choose>
							<td id="status"><c:out value="${travel.travelId}"/></td>
							<td><c:out value="${travel.country}"/></td>
							<td><c:out value="${travel.detail}"/></td>
							<td><c:out value="${travel.startDate}"/></td>
							<td><c:out value="${travel.endDate}"/></td>
							<td><c:out value="${travel.currentDate}"/></td>
						<c:choose>
						<c:when test="${travel.status.equals('1')}">
							<td>
							<label class="mdl-switch mdl-js-switch mdl-js-ripple-effect" >
								<input type="submit" id="switch-1" class="mdl-switch__input" name="open" form="formOpen" value="${travel.travelId}" checked></input>
								<span class="mdl-switch__label"></span>
							</label>
							</td>
						</c:when>
						<c:otherwise>
							<td>
							<label class="mdl-switch mdl-js-switch mdl-js-ripple-effect" >
								<input type="submit" id="switch-2" class="mdl-switch__input" name="close" form="formClose" value="${travel.travelId}"></input>
								<span class="mdl-switch__label"></span>
							</label>
							</td>
						</c:otherwise>
						</c:choose>
							<td>
								<button type="submit" name="detail" class="btn btn-primary btn-md " value="${travel.travelId}">detail</button>
							</td>
							</tr>
						</c:forEach>
						</form>
					</tbody>
				</table>
			</div>
		</div>
	</body>
</html>