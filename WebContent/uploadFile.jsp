<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>:: อัพโหลดนะสาด ::</title>
</head>
<body>
	<form action="UploadDocumentServlet" method="post"
		enctype="multipart/form-data">
		<input type="hidden" name="courseName" value="<%=request.getParameter("courseName") %>">
		
		<input type="file" name="file"> <br> <input
			type="submit" value="อัพโหลดนะจ๊ะ">
	</form>


	<br>
	<span>${text}</span>
	<br>
	<span>${message}</span>
	<br>
	<a href="">Download</a>
</body>
</html>