<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset==UTF-8">
<title>Insert title here</title>
</head>
<body>
	found
	<c:out value="${fn:length(registerBean)}"></c:out>
	Register(s)
	<br>
	<c:forEach items="${registerBean}" var="obj">

		<c:out value="${obj.registerNo}"> </c:out>
		<c:out value="${obj.trainingStartDate}"> </c:out>
		<c:out value="${obj.courseRegisterCosts}"> </c:out>

		<br>
	</c:forEach>

</body>
	
</html>