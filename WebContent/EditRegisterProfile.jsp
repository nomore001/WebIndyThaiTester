<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="fillRegisterProfile.*"%>
<%@ page import="java.util.*"%>
<%
	TraineeBean trainee = (TraineeBean) session
			.getAttribute("traineeBean");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Indy Thai Tester</title>

<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap2.css" rel="stylesheet">
<link href="assets/css/style2.css" rel="stylesheet">
<link href="assets/css/jquery-ui.css" rel="stylesheet">
</head>
<body>

	<%@include file="floatpage/menu.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="col-md-2"></div>
				<div class="col-md-8" style="background-color: #ffffff;">
					<form class="form-horizontal" name="formEditRegisterProfile"
						action="EditRegisterProfileServlet" method="post">
						<div class="page-header">
							<strong><font color="#5A9800">ส่วนที่ 1
									ข้อมูลส่วนตัว</font></strong>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label align="right" class="text-info col-sm-4 control-label">คำนำหน้าชื่อ:</label>
								<label class="radio-inline"> <input type="radio"
									name="radiotitle" id="title1" value="นาย"
									<%if (trainee.getTitle().equals("นาย")) {%> checked="checked"
									<%}%>> นาย
								</label> <label class="radio-inline"> <input type="radio"
									name="radiotitle" id="title1" value="นาง"
									<%if (trainee.getTitle().equals("นาง")) {%> checked="checked"
									<%}%>> นาง
								</label> <label class="radio-inline"> <input type="radio"
									name="radiotitle" id="title1" value="นางสาว"
									<%if (trainee.getTitle().equals("นางสาว")) {%> checked="checked"
									<%}%>> นางสาว
								</label>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-4 control-label">ชื่อ-นามสกุล:</label>
								<div class="col-sm-4">
									<div class="input-group input-group-sm">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-user"></i></span> <input
											class="form-control" type="text" name="textname"
											id="textname" value="<%=trainee.getName()%> ">
									</div>
								</div>
								<font color="red" size="4px">*</font>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-4 control-label">วุฒิการศึกษา:</label>
								<div class="col-sm-3">
									<select name="selecteducation" class="form-control">
										<option value="ต่ำกว่าปริญญาตรี"
											<%if (trainee.getEducation().equals("ต่ำกว่าปริญญาตรี")) {%>
											selected="selected" <%}%>>ต่ำกว่าปริญญาตรี</option>
										<option value="ปริญญาตรี"
											<%if (trainee.getEducation().equals("ปริญญาตรี")) {%>
											selected="selected" <%}%>>ปริญญาตรี</option>
										<option value="ปริญญาโท"
											<%if (trainee.getEducation().equals("ปริญญาโท")) {%>
											selected="selected" <%}%>>ปริญญาโท</option>
									</select>
								</div>
								<font color="red" size="4px">*</font>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-4 control-label">ตำแหน่งงาน:</label>
								<div class="col-sm-5">
									<div class="checkbox">
										<label> <input type="checkbox" name="checkboxjob"
											id="checkboxjob" value="Tester"
											<%if (trainee.getOccVector().get(0).getSelected()) {%>
											checked="checked" <%}%>>Tester
										</label>
									</div>
									<div class="checkbox">
										<label> <input type="checkbox" name="checkboxjob"
											id="checkboxjob" value="Administrator" <%if (trainee.getOccVector().get(1).getSelected()) {%>
											checked="checked" <%}%>>Administrator
										</label>
									</div>
									<div class="checkbox">
										<label> <input type="checkbox" name="checkboxjob"
											id="checkboxjob" value="Programmer" <%if (trainee.getOccVector().get(2).getSelected()) {%>
											checked="checked" <%}%>>Programmer
										</label>
									</div>
									<div class="checkbox">
										<label> <input type="checkbox" name="checkboxjob"
											id="checkboxjob" value="System analyst" <%if (trainee.getOccVector().get(3).getSelected()) {%>
											checked="checked" <%}%>>System
											analyst
										</label>
									</div>
									<div class="checkbox row">
										<label class="col-md-1"> <input type="checkbox"
											name="checkboxjob" id="jobEtc" value="Other" <%if (trainee.getOccVector().get(4).getSelected()) {%>
											checked="checked" <%}%>>Etc
										</label>
										<div class="col-md-8">
											<input class="input-medium form-control" type="text"
												name="textjobOther" id="textjobOther" <%if(trainee.getOccVector().get(4).getSelected()){%>value="<%=trainee.getOther()%>"<%}%>>
										</div>
									</div>
								</div>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-4 control-label">เบอร์โทรศัพท์:</label>
								<div class="col-sm-4">
									<div class="input-group input-group-sm">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-earphone"></i></span> <input
											class="form-control" type="text" name="texttelno"
											id="texttelno" value="<%=trainee.getTelNo()%>">
									</div>
								</div>
								<font color="red" size="4px">*</font>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-4 control-label">อีเมล์:</label>
								<div class="col-sm-5">
									<div class="input-group input-group-sm">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-envelope"></i></span> <input
											class="form-control" type="text" name="textemail"
											id="textemail" value="<%=trainee.getEmail()%>">
									</div>
								</div>
								<font color="red" size="4px">*</font>
							</div>

							<div class="page-header">
								<strong><font color="#5A9800">ส่วนที่ 2
										ข้อมูลที่ทำงานหรือที่อยู่ปัจจุบัน</font></strong>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-4 control-label">ที่ทำงาน/ที่อยู่ปัจจุบัน:</label>
								<div class="col-sm-5">
									<div class="input-group input-group-sm">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-pencil"></i></span> <input
											class="form-control" type="text" name="textworkplace"
											id="textworkplace" value="<%=trainee.getAddress().getWorkplace()%>">
									</div>
								</div>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-4 control-label">เลขที่:</label>
								<div class="col-sm-3">
									<div class="input-group input-group-sm">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-pencil"></i></span> <input
											class="form-control" type="text" name="textno" id="textno"
											value="<%=trainee.getAddress().getAddressNo()%>">
									</div>
								</div>
								<font color="red" size="4px">*</font>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-4 control-label">ถนน:</label>
								<div class="col-sm-4">
									<div class="input-group input-group-sm">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-road"></i></span> <input
											class="form-control" type="text" name="textstreet"
											id="textstreet" value="<%=trainee.getAddress().getStreet()%>">
									</div>
								</div>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-4 control-label">ตำบล/แขวง:</label>
								<div class="col-sm-4">
									<div class="input-group input-group-sm">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-pencil"></i></span> <input
											class="form-control" type="text" name="textsubdistrict"
											id="textsubdistrict"
											value="<%=trainee.getAddress().getSubDistrict()%>">
									</div>
								</div>
								<font color="red" size="4px">*</font>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-4 control-label">อำเภอ/เขต:</label>
								<div class="col-sm-4">
									<div class="input-group input-group-sm">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-pencil"></i></span> <input
											class="form-control" type="text" name="textdistrict"
											id="textdistrict" value="<%=trainee.getAddress().getDistrict()%>">
									</div>
								</div>
								<font color="red" size="4px">*</font>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-4 control-label">จังหวัด:</label>
								<div class="col-sm-4">
									<div class="input-group input-group-sm">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-pencil"></i></span> <input
											class="form-control" type="text" name="textprovince"
											id="textprovince" value="<%=trainee.getAddress().getProvince()%>">
									</div>
								</div>
								<font color="red" size="4px">*</font>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-4 control-label">รหัสไปรษณีย์:</label>
								<div class="col-sm-3">
									<div class="input-group input-group-sm">
										<span class="input-group-addon"><i
											class="glyphicon glyphicon-pencil"></i></span> <input
											class="form-control" type="text" name="textzipcode"
											id="textzipcode" value="<%=trainee.getAddress().getZipcode()%>">
									</div>
								</div>
								<font color="red" size="4px">*</font>
							</div>

							<div align="center">
								<button class="btn btn-default" type="submit" class="btn">ยืนยัน</button>
								<button class="btn btn-default" type="reset" class="btn">ยกเลิก</button>

							</div>
							<br> <br>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>

	<%@include file="floatpage/footer.jsp"%>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="assets/js/jquery-1.11.1.js"></script>
	<script src="assets/js/bootstrap.js"></script>
	<script src="assets/js/jquery-ui.js"></script>
	<script src="assets/js/checkInputFillRegisterProfile.js"></script>
</body>
</html>