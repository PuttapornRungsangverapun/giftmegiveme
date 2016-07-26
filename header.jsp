<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Gift Me | รับฝากซื้อสินค้าจากต่างประเทศเป็นเรื่องง่ายๆ</title>
		<meta http-equiv="Content-Language" content="th">
		<meta http-equiv="content-Type" content="text/html; charset=UTF-8">
		
		<script src="js/jquery-1.12.4.min.js"></script>
		<script src="bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script src="js/function.js"></script>
		<script src="js/jquery.livequery.js"></script>

		<link rel="shortcut icon" href="img/title-3.ico" />
		<link rel="stylesheet" type="text/css" href="bootstrap/3.3.6/css/bootstrap.min.css">		
		<link rel="stylesheet" type="text/css" href="css/style.css">

	</head>
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top opaque-navbar" role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapsible">
						<span class="sr-only">Toggle navigation</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.jsp"><img src="img/logowhite-1.png"></img></a>
				</div>
				<div class="navbar-collapse collapse" id="searchbar">
					<c:set var="username" value="${user.username}" />
					<c:if test="${username == null}">
					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="register.jsp">
								<span class="glyphicon glyphicon-user userColor" style="margin-left:10px;font-size: 20px;"></span>
							</a>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">
								<span class="glyphicon glyphicon-log-in shareColor" style="font-size:20px;"></span>
							</a>
							<ul class="dropdown-menu" style="padding: 15px;margin-top:7px;min-width: 250px;">
							<li>
							<div class="row">
								<div class="col-md-12">
									<form class="form" role="form" method="post" action="login" accept-charset="UTF-8" id="login-nav">
										<div class="form-group">
										<label class="sr-only" for="exampleInputEmail2">Username</label>
										<input type="text" class="form-control" id="exampleInputEmail2" name="username" placeholder="Username" required autofocus="autofocus">
										</div>
										<div class="form-group">
										<label class="sr-only" for="exampleInputPassword2">Password</label>
										<input type="password" class="form-control" id="exampleInputPassword2" name="password" placeholder="Password" required>
										</div>
										<div class="form-group">
										<button type="submit" class="btn btn-success btn-block">Sign in</button>
										</div>
										<div class="form-group">
										<a href="help.jsp">forget your password?</a>
										</div>
									</form>
								</div>
							</div>
							</li>
							</ul>
						</li>
					</ul>
					</c:if>
					<c:if test="${username != null}">
					<ul class="nav navbar-nav navbar-right">
						<c:set var="picturePath" value="${member.picturePath}" />
						<c:if test="${picturePath == ''}"><li><span class="glyphicon glyphicon-user userColor"></span></li></c:if>
						<c:if test="${picturePath != ''}"><li style="margin-top:8px;"><ul><img id="avatar" src="picture/${picturePath}"></img></ul></li></c:if>
						<li><a id="dropbtn"><span class="glyphicon glyphicon-comment listColor" style="margin-left:10px;font-size:20px;"></span></a></li>
						<li><a href="/giftmegiveme/logout"><span class="glyphicon glyphicon-log-out logoutColor" style="font-size:20px;"></span></a></li>
					</ul>
					</c:if>
					<form action="findsearch" method="POST" class="navbar-form">
						<div class="form-group" style="display:inline;">
							<div class="input-group" style="display:table;" >
								<span class="input-group-addon" style="width:1%;"><span class="glyphicon glyphicon-search SearchIcon"></span></span>
								<input class="form-control" name="search" placeholder="ค้นหาประเทศ, และ hashtag" autocomplete="off" type="text">
							</div>
						</div>
					</form>
				</div>
			</div>
			<c:if test="${username != null}">
			<div id="myDropdown" class="dropdown-content">	
				<div class="fixed_hiddenUserMenu">
					<a href="editprofile.jsp"><span class="text_user">แก้ไขประวัติส่วนตัว</span></a>
					<a href="deposit"><span class="text_user">รายการรับฝาก</span></a>
					<a href="searchorderhistory"><span class="text_user">รายการที่สั่ง</span></a>
				</div>
			</div>
			</c:if>
		</nav>
	</body>
</html>