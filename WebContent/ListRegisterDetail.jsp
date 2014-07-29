<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Bootstrap core CSS -->
<link href="assets/css/bootstrap2.css" rel="stylesheet">
<link href="assets/css/style2.css" rel="stylesheet">
<link href="assets/css/jquery-ui.css" rel="stylesheet">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Indy Thai Tester</title>
</head>
<body>
	<c:out value="${courseID}"></c:out>
	<%@include file="floatpage/menu.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="col-md-2"></div>
				<div class="col-md-8" style="background-color: #ffffff;">
					<form class="form-horizontal" name="formListRegisterDetail"
						action="" method="post">
						<div class="page-header">
							<strong><font color="#5A9800">ส่วนที่ 1
									ข้อมูลส่วนตัว</font></strong>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label align="right" class="text-info col-sm-6">คำนำหน้าชื่อ:</label>
								<div class="col-sm-6">
									<p>
										<c:out value="${traineeBean.title}"></c:out>
									</p>
								</div>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-6">ชื่อ-นามสกุล:</label>
								<div class="col-sm-6">
									<p>
										<c:out value="${traineeBean.name}"></c:out>
									</p>
								</div>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-6">วุฒิการศึกษา:</label>
								<div class="col-sm-6">
									<p>
										<c:out value="${traineeBean.education}"></c:out>
									</p>
								</div>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-6">ตำแหน่งงาน:</label>
								<div class="col-sm-6">
									<c:forEach items="${traineeBean.occVector}" var="occupation">
										<c:if test="${occupation.selected == true}">
											<c:choose>
												<c:when test="${occupation.occName.equals('Other')}">
													<c:out value="${traineeBean.other}"></c:out>
													<br />
												</c:when>
												<c:otherwise>
													<c:out value="${occupation.occName}"></c:out>
													<br />
												</c:otherwise>
											</c:choose>
										</c:if>
									</c:forEach>
								</div>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-6 ">เบอร์โทรศัพท์:</label>
								<div class="col-sm-6">
									<p>
										<c:out value="${traineeBean.telNo}"></c:out>
									</p>
								</div>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-6 ">อีเมล์:</label>
								<div class="col-sm-6">
									<p>
										<c:out value="${traineeBean.email}"></c:out>
									</p>
								</div>
							</div>

							<div class="page-header">
								<strong><font color="#5A9800">ส่วนที่ 2
										ข้อมูลที่ทำงานหรือที่อยู่ปัจจุบัน</font></strong>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-6 ">ที่ทำงาน/ที่อยู่ปัจจุบัน:</label>
								<div class="col-sm-6">
									<p>
										<c:out value="${traineeBean.address.workplace}"></c:out>
									</p>
								</div>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-6 ">เลขที่:</label>
								<div class="col-sm-6">
									<p>
										<c:out value="${traineeBean.address.addressNo}"></c:out>
									</p>
								</div>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-6 ">ถนน:</label>
								<div class="col-sm-6">
									<p>
										<c:out value="${traineeBean.address.street}"></c:out>
									</p>
								</div>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-6 ">ตำบล/แขวง:</label>
								<div class="col-sm-6">
									<p>
										<c:out value="${traineeBean.address.subDistrict}"></c:out>
									</p>
								</div>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-6 ">อำเภอ/เขต:</label>
								<div class="col-sm-6">
									<p>
										<c:out value="${traineeBean.address.district}"></c:out>
									</p>
								</div>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-6 ">จังหวัด:</label>
								<div class="col-sm-6">
									<p>
										<c:out value="${traineeBean.address.province}"></c:out>
									</p>
								</div>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-6 ">รหัสไปรษณีย์:</label>
								<div class="col-sm-6">
									<p>
										<c:out value="${traineeBean.address.zipcode}"></c:out>
									</p>
								</div>
							</div>

							<div class="page-header">
								<strong><font color="#5A9800">ส่วนที่ 3
										ข้อมูลการเข้าสู่ระบบ</font></strong>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-6 ">ชื่อผู้ใช้:</label>
								<div class="col-sm-6">
									<p>
										<c:out value="${traineeBean.login.username}"></c:out>
									</p>
								</div>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-6 ">รหัสผ่าน:</label>
								<div class="col-sm-6">
									<p>
										<c:out value="${traineeBean.login.password}"></c:out>
									</p>
								</div>
							</div>

							<div class="page-header">
								<strong><font color="#5A9800">ส่วนที่ 4
										ข้อมูลการชำระเงิน</font></strong>
							</div>

							<div class="form-group">
								<label align="right" class="text-info col-sm-6 ">สถานะการชำระเงิน:</label>
								<div class="col-sm-6">
									<p>
										<c:out value="${traineeBean.traineeStatus}"></c:out>
									</p>
								</div>
							</div>
							<br> <br>
						</div>
					</form>

					<div align="center">
						<button class="btn btn-default" type="button" class="btn" onclick="window.location.href='EditRegisterProfileServlet'">แก้ไข</button>
						<button class="btn btn-default" type="button" class="btn">พิมพ์</button>
					</div>

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
</body>
</html>