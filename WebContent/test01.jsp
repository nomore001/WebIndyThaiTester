<%@page import="downLoadDocument.CourseTrainingBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Hello :
<%-- 	<p>${sessionScope.traineeBean.name }</p> ---%>

<c:forEach items="${courseTrainingBean}" varStatus="obj">
<p>${courseTrainingBean[obj.index].courseName}
		<a href="uploadFile.jsp?courseName=${obj.index+1}">Upload Document</a>
		<a href="ListCourseTrainingServlet">List Document</a>
</p>
	</c:forEach>
	
	<a href="file/QTP/listRegisterDetail.rar">load</a>
	
	<a href="ListProfileDetailServlet">courseID</a>
</body>
</html>