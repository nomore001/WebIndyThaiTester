<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Indy Thai Tester</title>
<link href="assets/css/bootstrap2.css" rel="stylesheet">
<link href="assets/css/style2.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/jquery-ui.css">

<script src="assets/js/jquery-1.11.1.js"></script>
<script src="assets/js/jquery-ui.js"></script>
<script src="assets/js/bootstrap.js"></script>
</head>
<body>
	<h3>Admin Manager</h3>
	<div class="col-md-12">
		<c:forEach items="${courseTrainingBean}" varStatus="obj">
			<p>${courseTrainingBean[obj.index].courseName}
				<button class="btn btn-primary btn-lg" data-toggle="modal"
					data-target="#uploadModal" id="initUploadBtn_${obj.index+1}">Document
					Management</button>

			</p>
		</c:forEach>

	</div>
	<!-- Button trigger modal -->


	<!-- Modal -->
	<div class="modal fade" id="uploadModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Document Management</h4>
				</div>
				<div class="modal-body">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-12">
								<div class="col-md-6" id="list01"></div>
								<div class="col-md-6" id="list02">
									<form action="UploadDocumentServlet" method="post"
										enctype="multipart/form-data" id="uploadForm">
										<input type="hidden" name="courseName" id="courseName"
											value="${obj.index+1}"> <input type="file"
											name="fileID" id="fileID">
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="uploadBtn"
						value="upload">Upload</button>
				</div>
			</div>
		</div>
	</div>

	<script>
		var courseID = 1;
		$("button[id*='initUploadBtn']").click(function() {
			var tmp = this.id.split("_");
			// 		alert(tmp[1]);
			courseID = tmp[1];
			$.ajax({
				type : 'POST',
				url : 'ListCourseTrainingServlet',
				data : {
					'courseID' : tmp[1],
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

		});

		var client = new XMLHttpRequest();

		$("#uploadBtn").click(function() {
			upload();
		});
		function upload() {

			var file = document.getElementById("fileID");
			/* Create a FormData instance */
			var formData = new FormData();
			/* Add the file */
			formData.append("courseName", courseID);
			formData.append("fileID", file.files[0]);

			client.open("post", "UploadDocumentServlet", true);
			// 			client.setRequestHeader("Content-Type", "multipart/form-data");
			client.send(formData); /* Send to server */

		}
		
		/* Check the response status */
		client.onreadystatechange = function() {
			if (client.readyState == 4 && client.status == 200) {
				$('#uploadForm')[0].reset();
				$("#list01").load("listDocument.jsp");

				// 				alert(client.statusText);
			}
		}
		
		
		
		
		
	</script>
</body>
</html>