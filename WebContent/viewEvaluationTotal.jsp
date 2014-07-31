<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="evaluation.*"%>
<%@ page import="java.util.*"%>
<%
	int sumOfTrainee = (Integer) session.getAttribute("sumOfTrainee");
	String[] allTopicName = (String[]) session
			.getAttribute("allTopicName");
	double[] totalTopic = (double[]) session.getAttribute("totalTopic");
	String suggestion = (String) session.getAttribute("suggestion");
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
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="col-md-2"></div>
				<div class="col-md-8" style="background-color: #ffffff;">
					<form action="" method="post" name="FormEvaluation">
						<div class="page-header">
							<strong><font color="#5A9800">จำนวนผู้เข้าอบรมที่กรอกแบบประเมิน : <%=sumOfTrainee %></font></strong>
						</div>
						<%
							for (int i = 0; i < allTopicName.length; i++) {
						%>
						<div class="form-group">
							<label align="right" class="text-info col-sm-6"><%=allTopicName[i]%> : </label>
							<div class="col-sm-6">
								<%
									if (i == (allTopicName.length - 1)) {
								%>
								<p><%=suggestion%></p>
								<%
									} else {
								%>
								<p><%=totalTopic[i]%></p>
								<%
									}
								%>
							</div>
						</div>
						<%
							}
						%>
					</form>
				</div>
				<div class="col-md-2"></div>
			</div>
		</div>
	</div>

<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="assets/js/jquery-1.11.1.js"></script>
	<script src="assets/js/bootstrap.js"></script>
	<script src="assets/js/jquery-ui.js"></script>
</body>
</html>