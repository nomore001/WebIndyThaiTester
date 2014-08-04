<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset==UTF-8">
<title>Insert title here</title>

</head>
<body>
	ค้นพบ
	<c:out value="${fn:length(registerBeanVector)}"></c:out>
	 รายชื่อโครงการอบรม
	<br>
<%-- 	<c:forEach items="${registerBeanVector}" var="obj"> --%>
	
<%-- 		<p>${obj.registerNo}  ${obj.trainingStartDate}  --%>
<!-- 			<button type="button" class="btn btn-primary btn-xs" -->
<%-- 				id="viewtraineeBtn_${obj.registerNo}" value="${obj.registerNo}">ดูรายชื่อผู้เข้าอบรม</button> --%>
<!-- 				<button type="button" class="btn btn-success btn-xs" -->
<%-- 							id="viewEvaluate_${obj.registerNo}" value="">ดูผลการประเมินโครงการ</button> --%>
<!-- 		</p> -->
<%-- 	</c:forEach> --%>
	
	
	<table class="table table-striped custab">
		<thead>
			<tr>
				<th>ลำดับ</th>
				<th>รหัสการอบรม</th>
				<th>วันที่อบรม</th>
				<th></th>


			</tr>
		</thead>
		<thead>
			<c:forEach items="${registerBeanVector}" var="obj"
				varStatus="object">
				<tr>
					<td>${object.index+1}</td>
					<td><c:out value="${obj.registerNo}">
						</c:out></td>
					<td><c:out value="${obj.trainingStartDate}"></c:out> </td>	
					<td><button type="button" class="btn btn-primary btn-xs"
				id="viewtraineeBtn_${obj.registerNo}" value="${obj.registerNo}">ดูรายชื่อผู้เข้าอบรม</button>
				</td>
					<td><button type="button" class="btn btn-success btn-xs"
							id="viewEvaluate_${obj.registerNo}" value="">ดูผลการประเมินโครงการ</button>
						</td>

				</tr>
			</c:forEach>
		</thead>
	</table>

</body>
<script type="text/javascript">
	var registerNo = 1;
	$("button[id*='viewtraineeBtn']").click(function() {
		
		var tmp = this.id.split("_");
		 	
		registerNo = tmp[1];
		$.ajax({
			type : 'POST',
			url : 'LisAllTraineeServlet',
			data : {
				'registerNo' : tmp[1],
			},
			success : function(data, textStatus) {
// 				alert('done');
				window.location.href ="listAllTrainee.jsp";
				

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
	
	$("button[id*='viewEvaluate']").click(function() {
		
		var tmp = this.id.split("_");
		registerNo = tmp[1];
		$.ajax({
			type : 'POST',
			url : 'CalculateEvaluationServlet',
			data : {
				'registerNo' : tmp[1],
			},
			success : function(data, textStatus) {
				window.location.href ="viewEvaluationTotal.jsp";
				
			},
			error : function(xhr) {
				
			},
			complete : function(xhr, textStatus) {
				
			}
		});

	});
</script>

</html>