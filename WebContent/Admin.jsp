
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Indy Thai Tester</title>
<link href="assets/css/bootstrap2.css" rel="stylesheet">

<link href="assets/css/admin.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/jquery-ui.css">


<script src="assets/js/jquery-1.11.1.js"></script>
<script src="assets/js/jquery-ui.js"></script>
<script src="assets/js/bootstrap.js"></script>
<script>
	$(function() {
		$("#datepicker1").datepicker().se;
		$("#datepicker2").datepicker();
		$("#datepicker3").datepicker();
	});
</script>
</head>
<body>
	<%@include file="floatpage/adminHeader.jsp"%>



	<div class="container">
		<div class="row">
			<div class="co-md-12"></div>
			<h3>Admin Manager</h3>
			<div class="col-md-12 contentBody">

				<div class="col-md-6 contentLeft_admin ">
					<div class="col-md-12">
						<div class="col-md-12 contentBody itemMenu">
							<div align="center">
								<input type="image" src="assets/img/document-add-icon.png"
									name="addCourse" width="120px;" height="120px;"
									data-toggle="modal" data-target="#addCourseModal" /><br>เพิ่มการอบรม
							</div>

						</div>
					</div>
					<div class="col-md-4">
						<div class="col-md-11 contentBody itemMenu">
							<div align="center">
								<input type="image"
									src="assets/img/Actions-view-list-details-icon.png"
									name="listCourse" width="120px;" height="120px;"
									data-toggle="modal" data-target="#listCourseModal" /><br>รายละเอียดโครงการอบรม
							</div>


						</div>
					</div>
<!-- 					<div class="col-md-4"> -->
<!-- 						<div class="col-md-11 contentBody itemMenu"> -->

<!-- 							<input type="image" src="assets/img/document-add-icon.png" -->
<!-- 								name="addCourse" width="120px;" height="120px;" -->
<!-- 								data-toggle="modal" href="#stack1" /><br>test stack modal -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="col-md-4"> -->
<!-- 						<div class="col-md-11 contentBody itemMenu">menu4</div> -->
<!-- 					</div> -->
<!-- 					<div class="col-md-4"> -->
<!-- 						<div class="col-md-11 contentBody itemMenu">menu5</div> -->
<!-- 					</div> -->
<!-- 					<div class="col-md-4"> -->
<!-- 						<div class="col-md-11 contentBody itemMenu">menu6</div> -->
<!-- 					</div> -->
				</div>
				<div class="col-md-6 contentLeft_admin">
					<div class="col-md-12  itemMenu">right</div>

				</div>
			</div>
		</div>
	</div>





	<!--modal upload -->
	<div class="modal fade" id="uploadModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		style="z-index: 100000;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">จัดการเอกสารการอบรม
					</h4>
				</div>
				<div class="modal-body">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-12">
								<div class="col-md-6" id="list01"></div>
								<div class="col-md-6" id="list02">
									<p>
										<br>
									</p>
									<b><p>อัพโหลด เอกสาร</p></b>
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




	<!-- list course Modal -->
	<div class="modal fade" id="listCourseModal" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">
						หลักสูตรที่อยู่ในระบบ ค้นพบ
						<c:out value="${fn:length(courseTrainingBean)}"></c:out>
						หลักสูตร
					</h4>
				</div>

				<div class="modal-body">
					<table class="table table-striped custab">
						<thead>
							<tr>
								<th>ลำดับ</th>
								<th>ชื่อหลักสูตร</th>
								<th></th>
								<th></th>


							</tr>
						</thead>
						<thead>
							<c:forEach items="${courseTrainingBean}" varStatus="obj">
								<tr>
									<td>${obj.index+1}</td>
									<td>${courseTrainingBean[obj.index].courseName}</td>
									<td><button class="btn btn-primary btn-sm"
											data-toggle="modal" data-target="#uploadModal"
											id="initUploadBtn_${obj.index+1}">
											<i class="glyphicon glyphicon-book"></i> จัดการเอกสารการอบรม
										</button>
										<button class="btn btn-primary btn-sm" data-toggle="modal"
											data-target="#listRegister"
											id="viewRegisterBtn_${obj.index+1}">
											<i class="glyphicon glyphicon-list-alt"></i>
											รายชื่อโครงการอบรม
										</button></td>


								</tr>
							</c:forEach>
						</thead>
					</table>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>

				</div>
			</div>
		</div>

	</div>
	<!-------------------------------------------------------------------------------------------->
	
	
	<!--modal listRegister-->
	<div class="modal fade" id="listRegister" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		style="z-index: 100000;">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">รายชื่อโครงการอบรม
					</h4>
				</div>
				<div class="modal-body">
					<div class="container-fluid">
						<div class="row">
							
								<div class="col-md-12" id="listAllRegister"></div>
							
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					
				</div>
			</div>
		</div>
	</div>


	<!-- ---------------------------------- -->
	<!--modal addcourse-->
	<div class="modal fade" id="addCourseModal" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">
						<i class="glyphicon glyphicon-plus"></i>Add Course Training
					</h4>
				</div>

				<div class="modal-body">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">

									<%@include file="/AddCourseTraining.jsp"%>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
	</div>
	<!-- --------------------------------------------------------- -->

























































	<%@include file="floatpage/footer.jsp"%>

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
		};

		var courseId = 1;
		$("button[id*='viewRegisterBtn']").click(function() {

			var tmp = this.id.split("_");

			courseId = tmp[1];

			$.ajax({
				type : 'POST',
				url : 'ListAllRegisterServlet',
				data : {
					'courseID' : courseId,
				},
				success : function(data, textStatus) {
					// 					window.location.href = "listAllRegister.jsp";
					 					$("#listAllRegister").load("listAllRegister.jsp");
					 				

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
