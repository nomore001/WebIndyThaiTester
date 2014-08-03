<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="evaluation.*"%>
<%@ page import="java.util.*"%>
<%
	EvaluationBean evaluationBean = (EvaluationBean) session.getAttribute("evaluationBean");
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
					<form action="EvaluationServlet" method="post" name="FormEvaluation">
						<p><%=evaluationBean.getEvaluationName() %></p>
						<div>
						<%for(int i=0 ; i<evaluationBean.getTopicVector().size() ; i++){ %>
							<strong><font color="#5A9800"><%=evaluationBean.getTopicVector().get(i).getTopicName() %> </font></strong><br>
							<%if(evaluationBean.getTopicVector().get(i).getTopicName().equals("ข้อเสนอแนะอื่นๆ")){ %>
                                &nbsp;&nbsp;&nbsp;<%=evaluationBean.getTopicVector().get(i).getSuggestion().getAnswerSuggestion() %>
								<br><br>
							<%}else{ %>
								<font>ความพึงพอใจ</font>
								<div class="table-responsive">
								  <table class="table table-hover">
								  	<thead>
								    	<tr>
								          <th></th>
								          <th><center>มากที่สุด</center></th>
								          <th><center>มาก</center></th>
								          <th><center>ปานกลาง</center></th>
								          <th><center>น้อย</center></th>
								          <th><center>น้อยที่สุด</center></th>
								        </tr>
								  	</thead>
								    <tbody>
									<%for(int j=0 ; j<evaluationBean.getTopicVector().get(i).getChoiceVector().size() ; j++){ %>
										<tr>
								          <td><%=evaluationBean.getTopicVector().get(i).getChoiceVector().get(j).getChoiceQuestion() %></td>
								          <%if(evaluationBean.getTopicVector().get(i).getChoiceVector().get(j).getSelectedValue()==5){ %>
								          	  <td><center><span class="glyphicon glyphicon-ok" style="color: #5A9800;"></span></center></td>
									          <td><center></center></td>
									          <td><center></center></td>
									          <td><center></center></td>
									          <td><center></center></td>
								          <%}else if(evaluationBean.getTopicVector().get(i).getChoiceVector().get(j).getSelectedValue()==4){%>
								          	  <td><center></center></td>
									          <td><center><span class="glyphicon glyphicon-ok" style="color: #5A9800;"></span></center></td>
									          <td><center></center></td>
									          <td><center></center></td>
									          <td><center></center></td>
								          <%}else if(evaluationBean.getTopicVector().get(i).getChoiceVector().get(j).getSelectedValue()==3){%>
								          	  <td><center></center></td>
									          <td><center></center></td>
									          <td><center><span class="glyphicon glyphicon-ok" style="color: #5A9800;"></span></center></td>
									          <td><center></center></td>
									          <td><center></center></td>
								          <%}else if(evaluationBean.getTopicVector().get(i).getChoiceVector().get(j).getSelectedValue()==2){%>
								          	  <td><center></center></td>
									          <td><center></center></td>
									          <td><center></center></td>
									          <td><center><span class="glyphicon glyphicon-ok" style="color: #5A9800;"></span></center></td>
									          <td><center></center></td>
								          <%} else{%>
								          	  <td><center></center></td>
									          <td><center></center></td>
									          <td><center></center></td>
									          <td><center></center></td>
									          <td><center><span class="glyphicon glyphicon-ok" style="color: #5A9800;"></span></center></td>
								          <%} %>
								        </tr>
									<%} %>
									</tbody>
								  </table>
								</div>
							<%} %>
						<%} %>
						
						<div align="center">
							<button class="btn btn-default" type="button" class="btn" onClick="history.go(-1);return true;">กลับ</button>
							<br><br>
						</div>
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