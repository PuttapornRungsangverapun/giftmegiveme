<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.lang.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
 <head>
   <title>Buy | รับฝากซื้อสินค้าจากต่างประเทศเป็นเรื่องง่ายๆ</title>
   <meta charset="utf-8">
   <meta http-equiv="Content-Language" content="th">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="shortcut icon" href="img/title-3.ico" />
   <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
   <link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
   <link rel="stylesheet" type="text/css" href="css/style.css">

   <style>
     #content {
       margin-top: 10%;
     }

     #tagbar {
       background-color: black;
       margin: 0;
     }
     #tags {
       padding-top: 2%;
     }
	 #row_detail {
		background-color:#F5F5F5;
		border-radius: 5px;
	 }
   </style>

 </head>
 <body style="overflow: scroll">
  <%@ include file ="header.jsp" %>
   <% int position= Integer.parseInt(request.getParameter("index")); %>
    <div class="container" id="content">
	<a href="index.jsp">หน้าแรก</a> >
	<a href="search">อยากได้อะไร</a>
	<span>> รายละเอียดอยากได้อะไร</span><br/></br>
    <c:forEach items="${list}" var="searchlist" begin="<%=position%>" end ="<%=position%>" step="1" >
      <div class="row" id="row_detail">
        <div class="col-sm-1" >
        </div>
        <div class="col-sm-4">
          <div class="row">
          <div class="w3-light-grey" style="width:50%">
            <div class="w3-container w3-center" style="margin-top:15%;background-color:#337ab7;color:white;border-radius:5px;">
              <h4 style="padding-top:2%;padding-bottom:2%"></h4>
              <img src= "${searchlist.picturePath}" class="img-responsive" alt="Avatar" style="width:150; height:150; margin-bottom:5%">
                <div style="padding: 1px;">
                <h4 class="text-capitalize">${searchlist.firstName}</h4></div>
            </div>
          </div>
          </div>
          <div class="row">
            <img src= "img\phone.svg" style="width:10%; height: 10%;"/><span style="font-size: 1.5em "> ${searchlist.phoneNumber}</span></br>
          </div>
          <div class="row">
            <img src= "img\line-logo.svg" style="width:10%; height: 10%;"/><span style="font-size: 1.5em"> ${searchlist.lineId}</span></br></br>
          </div>
          </div>
        <div class="col-sm-6">
          <div class="well well-sm" style="margin-top:2%;background-color:#337ab7;color:white;border-radius:5px;">
            <center>Information</center>
          </div></br>
          <h4 style="padding-left: 5%">Country: <span style ="padding-left:5%"\> ${searchlist.country}</h4></br>
          <h4 style="padding-left: 5%">Go:      <span style ="padding-left:12%"\>${searchlist.startDate}</h4></br>
          <h4 style="padding-left: 5%">Back:    <span style ="padding-left:9%"\>${searchlist.endDate}</h4></br>
          <h4 style="padding-left: 5%">Details: <span style ="padding-left:6%"\>${searchlist.detail}</h4></br>
          <div>
            <div class="navbar-header">
              <a class="navbar-brand"><span class="glyphicon glyphicon-tags"></span></a>
            </div>
            <div id="tags">
              <c:forEach items="${tagList}" var="count">
                <input type="submit" class="btn btn-primary btn-xs" value="#${count.tagName}" onclick="location.href='searchpopular?popular=${count.tagName}'"/>
              </c:forEach>
            </div>
          </div></br></br>
			<div style="float:right;">
				<form id='formBack' action="search" method="POST"></form>
				<form  action="orderProduct.jsp" method="POST">
          <c:set var="memberID" value="${member.idCard}"/>
          <c:set var="searchID" value="${searchlist.idCard}"/>
          <c:choose>
            <c:when test="${memberID == null}">
            </c:when>
            <c:when test="${!memberID.equals(searchID)}">
              <button type="submit" class="btn btn-info" name="buyProduct" value="${searchlist.travelId}">Order</button>
            </c:when>
          </c:choose>
			<button type="submit" value="Cancel" form="formBack" class="btn btn-info">Cancel</button>
			</form>
			</div>
		</div>
       </div>
    </c:forEach>
   </form>
  </table>
 </body>
</html>
