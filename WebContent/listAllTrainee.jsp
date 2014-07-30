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
	<c:out value="${fn:length(allTraineeBean)}"></c:out>
	Trainee(s)
	<br>
	<c:forEach items="${allTraineeBean}" var="obj">
		<p>${obj.title} ${obj.name}
		
		<button type="button" class="btn btn-danger btn-xs"
				id="removetraineeBtn_${obj.name}" value="${obj.name}">Remove</button>
		
		</p>
		<br>
	</c:forEach>


<script type="text/javascript">
	var registerNo = 1;
	$("button[id*='removetraineeBtn']").click(function() {
		
		var tmp = this.id.split("_");
		 		alert(tmp[1]);
		registerNo = tmp[1];
		$.ajax({
			type : 'POST',
			url : 'RemoveInvalidRegisterServlet',
			data : {
				'traineeName' : tmp[1],
			},
			success : function(data, textStatus) {
				window.location = 'ListAllTraineeServlet';	
				

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

</body>
</html>