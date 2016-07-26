<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="userId" value="${user.userId}" />
<c:set var="username" value="${user.username}" />
<c:set var="password" value="${user.password}" />
<c:if test="${username == null && password == null}">
	<meta http-equiv="refresh" content="0; url=../giftmegiveme/index.jsp" />
</c:if>