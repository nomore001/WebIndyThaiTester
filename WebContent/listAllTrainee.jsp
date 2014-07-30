<<<<<<< HEAD
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
	<c:out value="${fn:length(allTraineeBean)}"></c:out>
	Trainee(s)
	<br>

	<table class="table table-striped custab">
		<thead>
			<tr>
				<th>ลำดับ</th>
				<th>ชื่อ - สกุล</th>
				<th>สถานที่ทำงาน</th>
				<th>หมายเลขโทรศัพท์</th>
				<th>จำนวนเงินที่ต้องจ่าย</th>
				<th>สถานะการจ่ายเงิน</th>


			</tr>
		</thead>

		<c:forEach items="${allTraineeBean}" var="obj" varStatus="status">
			<thead>
				<tr>
					<td>${status.index+1}</td>
					<td>${obj.name}</td>
					<td>${obj.address.workplace}</td>
					<td>${obj.telNo}</td>
					<td>${obj.traineePayment}</td>
					<td>${obj.traineeStatus}</td>

					<td>
						<!-- Button trigger modal -->
						<button class="btn btn-primary btn-lg" data-toggle="modal"
							data-target="#myModal" id="editBtn_${status.index} ">Edit</button>
						<!-- Modal -->
						<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">
											<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
										</button>
										<h4 class="modal-title" id="myModalLabel">แก้ไขสถานะการชำระเงิน</h4>
									</div>
									<div class="modal-body">

										<div class="form-group">
											<label align="right" class="text-info col-sm-4 control-label">ชื่อ
												- สกุล :</label> <label class="radio-inline" id="trainee_Name"
												value=""></label>
										</div>
										<div class="form-group">
											<label align="right" class="text-info col-sm-4 control-label">สถานที่ทำงาน
												:</label> <label class="radio-inline"> keaw </label>
										</div>
										<div class="form-group">
											<label align="right" class="text-info col-sm-4 control-label">หมายเลขโทรศัพท์:</label>
											<label class="radio-inline"> keaw </label>
										</div>
										<div class="form-group">
											<label align="right" class="text-info col-sm-4 control-label">จำนวนเงินที่ต้องชำระ:</label>
											<label class="radio-inline"> keaw </label>
										</div>
										<div class="form-group">
											<label align="right" class="text-info col-sm-4 control-label">สถานะการชำระเงิน
												:</label> <label class="radio-inline"> <select
												class="form-control">
													<option value="ยังไม่ได้ชำระเงิน">ยังไม่ได้ชำระเงิน</option>
													<option value="ชำระเงินเรียบร้อยแล้ว">ชำระเงินเรียบร้อยแล้ว</option>

											</select></label>
										</div>



									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
										<button type="button" class="btn btn-primary">Save
											changes</button>
									</div>
								</div>
							</div>
						</div>

						<button type="button" class="btn btn-danger btn-xs"
							id="removetraineeBtn_${obj.name}" value="${obj.name}">Remove</button>
					</td>
				</tr>
			</thead>
		</c:forEach>

	</table>
	<!-- Small modal -->



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

		var indexToEdit = 1;
		
		$("button[id*='editBtn']").click(function() {
			
			var tmp = this.id.split("_");
			alert(tmp[1]);
			indexToEdit = tmp[1];
// 			var kk = "${allTraineeBean["+indexToEdit+"].name}";
			$("#trainee_Name").val();
			
			// 			$.ajax({
			// 				type : 'POST',
			// 				url : 'RemoveInvalidRegisterServlet',
			// 				data : {
			// 					'traineeName' : tmp[1],
			// 				},
			// 				success : function(data, textStatus) {
			// 					window.location = 'ListAllTraineeServlet';

			// 				},
			// 				error : function(xhr) {
			// 					// alert("Error");
			// 				},
			// 				complete : function(xhr, textStatus) {
			// 					// $("#mySubModal").remove();
			// 					// $("#editAttendanceBtn").bind();
			// 					// alert("Complete");
			// 				}
			// 			});

		});
	</script>

</body>
=======
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
>>>>>>> branch 'master' of https://github.com/nomore001/WebIndyThaiTester.git
</html>
