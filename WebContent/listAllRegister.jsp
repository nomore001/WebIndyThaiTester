<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset==UTF-8">
<title>Insert title here</title>
<script src="assets/js/jquery-1.11.1.js"></script>
<script src="assets/js/jquery-ui.js"></script>
<script src="assets/js/bootstrap.js"></script>
</head>
<body>
	found
	<c:out value="${fn:length(registerBean)}"></c:out>
	Register(s)
	<br>
	<c:forEach items="${registerBean}" var="obj">
	
		<p>${obj.registerNo}

			<button type="button" class="btn btn-danger btn-xs"
				id="viewtraineeBtn_${obj.registerNo}" value="${obj.registerNo}">ABC</button>
		</p>
		<br>
	</c:forEach>

</body>
<script type="text/javascript">
	var registerNo = 1;
	$("button[id*='viewtraineeBtn']").click(function() {
		
		var tmp = this.id.split("_");
		 		alert(tmp[1]);
		registerNo = tmp[1];
		$.ajax({
			type : 'POST',
			url : 'LisAllTraineeServlet',
			data : {
				'registerNo' : tmp[1],
			},
			success : function(data, textStatus) {
				alert('done');
				window.location.href ="listAllTrainee.jsp";
				

			},
			error : function(xhr) {
				// alert("Error");
			},
			complete : function(xhr, textStatus) {
				// $("#mySubModal").remove();
				// $("#editAttendanceBtn").bind();
				// alert("Complete");
			}
		});

	});
</script>

</html>