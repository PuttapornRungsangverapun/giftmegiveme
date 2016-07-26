<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
	<head>
		<title>Buy | รับฝากซื้อสินค้าจากต่างประเทศเป็นเรื่องง่ายๆ </title>
		<meta charset="utf-8">
		<meta http-equiv="Content-Language" content="th">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="shortcut icon" href="img/title-3.ico" />
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

		<style>
			#content {
				padding-top: 2%;
			}
			#detail {
				padding-top: 3%;

			}
			#tagbar {
				background-color:#f2f2f2;
			}
			#tags {
				padding-top: 1%;
				padding-bottom: 1%;
			}
		</style>

	</head>

	<body style="overflow: scroll">
		<% int count = 0;%>
		<%@ include file ="header.jsp" %>
			<nav class="container-fluid" id="tagbar" style="padding-top:9%;">
				<div class="container">
					<div class="navbar-header">
      					<a class="navbar-brand"><span class="glyphicon glyphicon-tags"></span></a>
    				</div>
					<div id="tags">
						<c:forEach items="${hashtagList}" var="count">
							<input type="submit" class="btn btn-primary btn-xs" value="#${count.hashtagName}"
							onclick="location.href='searchpopular?popular=${count.hashtagName}'"/>
						</c:forEach>
					</div>
				</div>
			</nav>
		<div class="container" id="content">
			<a href="index.jsp">หน้าแรก</a>
			<span>> อยากได้อะไร</span><br/></br>
			<div class="row">
			<c:forEach items="${list}" var="searchlist">
					<div class="col-sm-4">
					      <div class="panel panel-primary" onclick="location.href='details?index=<%=count%>';" style="border:1px solid #e3e3e3; background-color: #f2f2f2; cursor:pointer;">
					        <div class="panel-body">

					          <div class="row">
					            <div class="col-sm-5" >
					              <img src= "${searchlist.picturePath}" style="width:100px; height: 100px;"/>
					            </div>
					            <div class="col-sm-7" style="font-size: 2.5vw">
					              <p class="text-capitalize"><c:out value="${searchlist.firstName}"/></p>
					            </div>
					          </div>

					          <div class="row" id="detail" style="font-size: 125%">
											<div class="col-sm-3" >
					            	Country:
											</div>
											<div class="col-sm-9" >
					            	<c:out value="${searchlist.country}"/>
											</div>
					          </div>

					          <div class="row" id="detail" style="font-size: 125%">
											<div class="col-sm-3" >
												Go  :
											</div>
											<div class="col-sm-9" >
												<c:out value="${searchlist.startDate}"/>
											</div>
					          </div>

					          <div class="row" id="detail" style="font-size: 125%">
											<div class="col-sm-3" >
												Back  :
											</div>
											<div class="col-sm-9" >
												<c:out value="${searchlist.endDate}"/>
											</div>
					          </div>
					        </div>
					     </div>
						</div>
						<% count++;%>
				</c:forEach>

		 </div>
			 </div><br><br>
	</body>
</html>
