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
	<c:out value="${fn:length(trainingDocumentList)}"></c:out>
	file(s)
	<br>
	<input type="hidden" id="courseIDUpload" value="${courseIDSession }">
	<c:forEach items="${trainingDocumentList}" var="obj">

		<c:out value="${obj.documentName}">
		</c:out>
		<button type="button"
			class="btn btn-danger btn-xs glyphicon glyphicon-remove"
			id="deleteDocumentBtn" value="${obj.documentId}"></button>
		<input type="hidden" id="docPath" value="${obj.documentPath}">
		<br>
	</c:forEach>


	<script type="text/javascript">
		$("button[id*='deleteDocumentBtn']").click(function() {

			$.ajax({
				type : 'POST',
				url : 'DeleteDocumentServlet',
				data : {
					'documentID' : $(this).val(),
				// 					'documentPath' : $('#docPath').val(),
				},
				success : function(data, textStatus) {
					//$("#list01").load("listDocument.jsp");
					$.ajax({
						type : 'POST',
						url : 'ListCourseTrainingServlet',
						data : {
							'courseID' : $("#courseIDUpload").val(),
						},
						success : function(data, textStatus) {
							$("#list01").load("listDocument.jsp");

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