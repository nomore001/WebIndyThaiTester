<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<form class="form-horizontal" name="frm" action="FillRegisterProfileServlet" method="post">
					<div class="page-header">
						<strong><font color="#5A9800">ส่วนที่ 1
								ข้อมูลส่วนตัว</font></strong>
					</div>
					<div class="col-md-12">
						<div class="form-group">
							<label align="right" class="text-info col-sm-4 control-label">คำนำหน้าชื่อ:</label>
							<label class="radio-inline"> <input type="radio"
								name="radiotitle" id="title1" value="นาย"> นาย
							</label> <label class="radio-inline"> <input type="radio"
								name="radiotitle" id="title2" value="นาง"> นาง
							</label> <label class="radio-inline"> <input type="radio"
								name="radiotitle" id="title3" value="นางสาว"> นางสาว
							</label>
						</div>

						<div class="form-group">
							<label align="right" class="text-info col-sm-4 control-label">ชื่อ-นามสกุล:</label>
							<div class="col-sm-4">
								<div class="input-group input-group-sm">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input
										class="form-control" type="text" name="textname" id="textname"
										placeholder="ชื่อ-นามสกุล">
								</div>
							</div>
							<font color="red" size="4px">*</font>
						</div>

						<div class="form-group">
							<label align="right" class="text-info col-sm-4 control-label">วุฒิการศึกษา:</label>
							<div class="col-sm-3">
								<select name="selecteducation" class="form-control">
									<option value="0" selected="selected" disabled="disabled">กรุณาเลือก</option>
									<option value="ต่ำกว่าปริญญาตรี">ต่ำกว่าปริญญาตรี</option>
									<option value="ปริญญาตรี">ปริญญาตรี</option>
									<option value="ปริญญาโท">ปริญญาโท</option>
									<option value="ปริญญาเอก">ปริญญาเอก</option>
								</select>
							</div>
							<font color="red" size="4px">*</font>
						</div>

						<div class="form-group">
							<label align="right" class="text-info col-sm-4 control-label">ตำแหน่งงาน:</label>
							<div class="col-sm-5">
								<div class="checkbox">
									<label> <input type="checkbox" name="checkboxjob" id="checkboxjob"
										value="Tester">Tester
									</label>
								</div>
								<div class="checkbox">
									<label> <input type="checkbox" name="checkboxjob" id="checkboxjob"
										value="Administrator">Administrator
									</label>
								</div>
								<div class="checkbox">
									<label> <input type="checkbox" name="checkboxjob" id="checkboxjob"
										value="Programmer">Programmer
									</label>
								</div>
								<div class="checkbox">
									<label> <input type="checkbox" name="checkboxjob" id="checkboxjob"
										value="System analyst">System analyst
									</label>
								</div>
								<div class="checkbox row">
									<label class="col-md-1"> <input type="checkbox"
										name="checkboxjob" id="jobEtc" value="Other">Etc
									</label>
									<div class="col-md-8">
										<input class="input-medium form-control" type="text"
											name="textjobOther" id="textjobOther"><span
											id="isKPass"></span>
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
										class="form-control" type="text" name="texttelno" id="texttelno"
										placeholder="เบอร์โทรศัพท์">
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
										class="form-control" type="text" name="textemail" id="textemail"
										placeholder="อีเมล์">
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
										id="textworkplace" placeholder="ที่ทำงาน/ที่อยู่ปัจจุบัน">
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
										placeholder="เลขที่">
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
										id="textstreet" placeholder="ถนน">
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
										id="textsubdistrict" placeholder="ตำบล/แขวง">
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
										id="textdistrict" placeholder="อำเภอ/เขต">
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
										id="textprovince" placeholder="จังหวัด">
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
										class="form-control" type="text" name="textzipcode" id="textzipcode"
										placeholder="รหัสไปรษณีย์">
								</div>
							</div>
							<font color="red" size="4px">*</font>
						</div>

						<div class="page-header">
							<strong><font color="#5A9800">ส่วนที่ 3
									ข้อมูลการเข้าสู่ระบบ</font></strong>
						</div>

						<div class="form-group">
							<label align="right" class="text-info col-sm-4 control-label">ชื่อผู้ใช้:</label>
							<div class="col-sm-4">
								<div class="input-group input-group-sm">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input
										class="form-control" type="text" name="textusername"
										id="textusername" placeholder="Username">
								</div>
							</div>
							<font color="red" size="4px">*</font>
						</div>

						<div class="form-group">
							<label align="right" class="text-info col-sm-4 control-label">รหัสผ่าน:</label>
							<div class="col-sm-4">
								<div class="input-group input-group-sm">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-lock"></i></span> <input
										class="form-control" type="password" name="textpassword"
										id="textpassword" placeholder="Password">
								</div>
							</div>
							<font color="red" size="4px">*</font>
						</div>

						<div class="form-group">
							<label align="right" class="text-info col-sm-4 control-label">ยืนยันรหัสผ่าน:</label>
							<div class="col-sm-4">
								<div class="input-group input-group-sm">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-lock"></i></span> <input
										class="form-control" type="password" name="textconfirmpassword"
										id="textconfirmpassword" placeholder="Confirm Password">
								</div>
							</div>
							<font color="red" size="4px">*</font>
						</div>

						<div align="center">
							<button class="btn btn-default" type="submit" class="btn">ลงทะเบียน</button>
							<button class="btn btn-default" type="reset" class="btn">ยกเลิก</button>
							
						</div>
						<br><br>
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