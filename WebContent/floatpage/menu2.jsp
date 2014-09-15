<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.itsci.fill_register_profile.*"%>
<%@ page import="java.util.*"%>
<%
	TraineeBean traineeBean = (TraineeBean) session.getAttribute("traineeBean");
%>
<div class="">
	<div class="navbar navbar-default navbar-static-top setBgmenu">

		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.jsp"><span
					class="glyphicon glyphicon-home"></span> หน้าแรก</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="#"><span
							class="glyphicon glyphicon-asterisk"></span> รายละเอียดการฝึกอบรม</a></li>
					<li><a href="#"><span
							class="glyphicon glyphicon-asterisk"></span> วิธีการชำระเงิน</a></li>
					<%if(traineeBean==null){ %>
					<li><a href="FillRegisterProfile.jsp"><span
							class="glyphicon glyphicon-user"></span> ลงทะเบียนอบรม</a></li>
					<%} %>
					<%if(traineeBean!=null){ %>
						<li><a href="Evaluation.jsp"><span
							class="glyphicon glyphicon-pencil"></span> ประเมินการอบรม</a></li>
					<%} %>
					<li><a href="#"><span
							class="glyphicon glyphicon-map-marker"></span> ติดต่อสอบถาม</a></li>

				</ul>
				<ul class="nav navbar-nav navbar-right">
				<%if(traineeBean==null){ %>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" id="login_li"> <span
							class="glyphicon glyphicon-log-in"></span> เข้าสู่ระบบ<b
							class="caret"></b></a>
						<ul class="dropdown-menu" style="padding: 15px; min-width: 250px;">
							<li>
								<div class="row">
									<div class="col-md-12">
										<form class="form" id="login_form" action="LoginServlet" method="Post">
											<div class="form-group">
												<label class='control-label text-muted'>ชื่อผู้ใช้</label>
												<div class="input-group input-group-md">
													<span class="input-group-addon"><i
														class="glyphicon glyphicon-user"></i></span> <input type="text"
														name="username_login" id="username_login"
														class="form-control input-md" placeholder="ชื่อผู้ใช้" />
												</div>
												<div class="form-group">
													<label class='control-label text-muted'>รหัสผ่าน</label>
													<div class="input-group input-group-md">
														<span class="input-group-addon"><i
															class="glyphicon glyphicon-lock"></i></span> <input
															type="password" name="password_login" id="password_login"
															class="form-control input-md" placeholder="รหัสผ่าน" />
													</div>
												</div>
												<div class="form-group">
													<button type="submit" class="btn btn-success btn-block"
														id="login_button">เข้าสู่ระบบ</button>
												</div>
											</div>
										</form>
									</div>
								</div>
							</li>
						</ul></li>
					<%} %>
					<%if(traineeBean!=null){ %>
						<li><a href="LogoutServlet"><span
							class="glyphicon glyphicon-log-out"></span> ออกจากระบบ</a></li>
					<%} %>
				</ul>

				<!--/.nav-collapse -->
			</div>
		</div>

	</div>
	<div class="container header-top-page carousel-inner2">
		<img src="assets/img/logo.png" style="padding-top: -50px;">

	</div>


</div>




