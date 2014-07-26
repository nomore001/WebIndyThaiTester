<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset==UTF-8">
<title>User Document</title>

</head>
<body>

	found
	<c:out value="${fn:length(trainingDocumentBean)}"></c:out>
	file(s)
	<br>

	<c:forEach items="${trainingDocumentBean}" var="obj">

		<c:out value="${obj.documentName}">
		</c:out>
		<button type="button"
			
			id="abc_${obj.documentId}" value="${obj.documentId}">DownLoad</button>

		<br>
	</c:forEach>
	
	
</body>
<script src="assets/js/jquery-1.11.1.js"></script>
<script src="assets/js/jquery-ui.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script type="text/javascript">

	$("button[id*='abc']").click(function() {
		
		alert( $(this).val());
		$.ajax({
			type : 'POST',
			url : 'DownLoadDocumentServlet',
			data : {
				'documentID' : $(this).val(),

			},
			success : function(data, textStatus) {
				window.load(this);

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