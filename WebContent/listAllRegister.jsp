<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset==UTF-8">
<title>Insert title here</title>
<link href="assets/css/jquery-ui.css" rel="stylesheet">
<link href="assets/css/bootstrap2.css" rel="stylesheet">
<link href="assets/css/style2.css" rel="stylesheet">
<script src="assets/js/jquery-1.11.1.js"></script>
<script src="assets/js/jquery-ui.js"></script>
<script src="assets/js/bootstrap.js"></script>
</head>
<body>
	found
	<c:out value="${fn:length(registerBeanVector)}"></c:out>
	Register(s)
	<br>
	<c:forEach items="${registerBeanVector}" var="obj">
	
		<p>${obj.registerNo}
			<button type="button" class="btn btn-primary btn-xs"
				id="viewtraineeBtn_${obj.registerNo}" value="${obj.registerNo}">ดูรายชื่อผู้เข้าอบรม</button>
				<button type="button" class="btn btn-success btn-xs"
							id="viewEvaluate_${obj.registerNo}" value="">ดูผลการประเมินโครงการ</button>
		</p>
	</c:forEach>

</body>
<script type="text/javascript">
	var registerNo = 1;
	$("button[id*='viewtraineeBtn']").click(function() {
		
		var tmp = this.id.split("_");
		 	
		registerNo = tmp[1];
		$.ajax({
			type : 'POST',
			url : 'LisAllTraineeServlet',
			data : {
				'registerNo' : tmp[1],
			},
			success : function(data, textStatus) {
// 				alert('done');
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
	
	$("button[id*='viewEvaluate']").click(function() {
		
		var tmp = this.id.split("_");
		registerNo = tmp[1];
		$.ajax({
			type : 'POST',
			url : 'CalculateEvaluationServlet',
			data : {
				'registerNo' : tmp[1],
			},
			success : function(data, textStatus) {
				window.location.href ="viewEvaluationTotal.jsp";
				
			},
			error : function(xhr) {
				
			},
			complete : function(xhr, textStatus) {
				
			}
		});

	});
</script>

</html>