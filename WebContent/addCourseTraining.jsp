<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Indy Thai Tester</title>
<link href="assets/css/bootstrap2.css" rel="stylesheet">
<link rel="stylesheet" href="assets/css/jquery-ui.css">
<script src="assets/js/jquery-1.11.1.js"></script>
<script src="assets/js/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker1").datepicker();
		$("#datepicker2").datepicker();
		$("#datepicker3").datepicker();
	});
</script>
</head>

<body>
	<form class="form-horizontal" name="formAddCourse" action="AddCourseTrainingServlet"
		method="post">		
		<div class="col-md-12">
			<div class="form-group">
				<label align="right" class="text-info col-sm-5 control-label">ชื่อหลักสูตรการอบรม
					:</label>
				<div class="col-sm-5">
					<div class="input-group input-group-sm">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-pencil"></i></span> <input class="form-control"
							type="text" name="textcourseName" id="txtname"
							placeholder="ชื่อหลักสูตรการอบรม">
					</div>
				</div>
			</div>

			<div class="form-group">
				<label align="right" class="text-info col-sm-5 control-label">วันที่เปิดลงทะเบียน
					:</label>
				<div class="col-sm-5">
					<div class="input-group input-group-sm">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-calendar"></i></span> <input class="form-control"
							type="date" name="textcourseRegisterStartDate" id="datepicker1"
							placeholder="วันที่เปิดลงทะเบียน">
					</div>
				</div>
			</div>

			<div class="form-group">
				<label align="right" class="text-info col-sm-5 control-label">จำนวนวันที่เปิดลงทะเบียน
					:</label>
				<div class="col-sm-5">
					<div class="input-group input-group-sm">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-time"></i></span> <input class="form-control"
							type="text" name="textcourseRegisterDuration" id="txtname"
							placeholder="จำนวนวันที่เปิดลงทะเบียน">
					</div>
				</div>
			</div>

			<div class="form-group">
				<label align="right" class="text-info col-sm-5 control-label">วันที่เริ่มชำระเงินค่าอบรม
					:</label>
				<div class="col-sm-5">
					<div class="input-group input-group-sm">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-calendar"></i></span> <input class="form-control"
							type="text" name="textpaymentStartDate" id="datepicker2"
							placeholder="วันที่เริ่มชำระเงินค่าอบรม">
					</div>
				</div>
			</div>

			<div class="form-group">
				<label align="right" class="text-info col-sm-5 control-label">จำนวนวันที่ชำระเงิน
					:</label>
				<div class="col-sm-5">
					<div class="input-group input-group-sm">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-time"></i></span> <input class="form-control"
							type="text" name="textpaymentDuration" id="txtname"
							placeholder="จำนวนวันที่ชำระเงิน">
					</div>
				</div>
			</div>

			<div class="form-group">
				<label align="right" class="text-info col-sm-5 control-label">วันที่เริ่มการอบรม
					:</label>
				<div class="col-sm-5">
					<div class="input-group input-group-sm">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-calendar"></i></span> <input class="form-control"
							type="text" name="texttrainingStartDate" id="datepicker3"
							placeholder="วันที่เริ่มการอบรม">
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<label align="right" class="text-info col-sm-5 control-label">จำนวนวันที่เปิดอบรม
					:</label>
				<div class="col-sm-5">
					<div class="input-group input-group-sm">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-time"></i></span> <input class="form-control"
							type="text" name="textcourseDuration" id="txtname"
							placeholder="จำนวนวันที่เปิดอบรม">
					</div>
				</div>
			</div>

			<div class="form-group">
				<label align="right" class="text-info col-sm-5 control-label">จำนวนเงินค่าอบรม
					:</label>
				<div class="col-sm-5">
					<div class="input-group input-group-sm">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-tag"></i></span> <input class="form-control"
							type="text" name="textcourseRegisterCosts" id="txtname"
							placeholder="จำนวนเงินค่าอบรม">
					</div>
				</div>
			</div>

			<div align="center">
				<button class="btn btn-success" type="submit" class="btn btn-success"
					onclick="return validate(formAddCourse)">ยืนยัน</button>
				<button class="btn btn-default" type="reset" class="btn" data-dismiss="modal">ยกเลิก</button>

			</div>
		</div>
	</form>
</body>
</html>