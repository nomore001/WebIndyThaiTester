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
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="col-md-2"></div>
				<div class="col-md-8" style="background-color: #ffffff;">
					<form action="EvaluationServlet" method="post" name="FormEvaluation">
						<p>แบบประเมินการเข้าอบรม</p>
						<div>
						<strong><font color="#5A9800"><input type="hidden" name="topicLecture" value="ด้านวิทยากร">ด้านวิทยากร </font></strong><font color="red" size="4px">*</font><br>
						<font>ความพึงพอใจ</font>
						</div>
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
						        <tr>
						          <td><input type="hidden" name="choiceLecture1" value="การเตรียมตัวและความพร้อมของวิทยากร">การเตรียมตัวและความพร้อมของวิทยากร</td>
						          <td><center><input type="radio" value="5" name="lecture1"></center></td>
						          <td><center><input type="radio" value="4" name="lecture1"></center></td>
						          <td><center><input type="radio" value="3" name="lecture1"></center></td>
						          <td><center><input type="radio" value="2" name="lecture1"></center></td>
						          <td><center><input type="radio" value="1" name="lecture1"></center></td>
						        </tr>
						        <tr>
						          <td><input type="hidden" name="choiceLecture2" value="การถ่ายทอดของวิทยากร">การถ่ายทอดของวิทยากร</td>
						          <td><center><input type="radio" value="5" name="lecture2"></center></td>
						          <td><center><input type="radio" value="4" name="lecture2"></center></td>
						          <td><center><input type="radio" value="3" name="lecture2"></center></td>
						          <td><center><input type="radio" value="2" name="lecture2"></center></td>
						          <td><center><input type="radio" value="1" name="lecture2"></center></td>
						        </tr>
						        <tr>
						          <td><input type="hidden" name="choiceLecture3" value="สามารถอธิบายเนื้อหาได้ชัดเจนและตรงประเด็น">สามารถอธิบายเนื้อหาได้ชัดเจนและตรงประเด็น</td>
						          <td><center><input type="radio" value="5" name="lecture3"></center></td>
						          <td><center><input type="radio" value="4" name="lecture3"></center></td>
						          <td><center><input type="radio" value="3" name="lecture3"></center></td>
						          <td><center><input type="radio" value="2" name="lecture3"></center></td>
						          <td><center><input type="radio" value="1" name="lecture3"></center></td>
						        </tr>
						        <tr>
						          <td><input type="hidden" name="choiceLecture4" value="ใช้ภาษาที่เหมาะสมและเข้าใจง่าย">ใช้ภาษาที่เหมาะสมและเข้าใจง่าย</td>
						          <td><center><input type="radio" value="5" name="lecture4"></center></td>
						          <td><center><input type="radio" value="4" name="lecture4"></center></td>
						          <td><center><input type="radio" value="3" name="lecture4"></center></td>
						          <td><center><input type="radio" value="2" name="lecture4"></center></td>
						          <td><center><input type="radio" value="1" name="lecture4"></center></td>
						        </tr>
						        <tr>
						          <td><input type="hidden" name="choiceLecture5" value="การตอบคำถามของวิทยากร">การตอบคำถามของวิทยากร</td>
						          <td><center><input type="radio" value="5" name="lecture5"></center></td>
						          <td><center><input type="radio" value="4" name="lecture5"></center></td>
						          <td><center><input type="radio" value="3" name="lecture5"></center></td>
						          <td><center><input type="radio" value="2" name="lecture5"></center></td>
						          <td><center><input type="radio" value="1" name="lecture5"></center></td>
						        </tr>
						    </tbody>
						  </table>
						</div>
						
						<div>
						<strong><font color="#5A9800"><input type="hidden" name="topicLocationAndTime" value="ด้านสถานที่ / ระยะเวลา">ด้านสถานที่ / ระยะเวลา </font></strong><font color="red" size="4px">*</font><br>
						<font>ความพึงพอใจ</font>
						</div>
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
						        <tr>
						          <td><input type="hidden" name="choiceLocationAndTime1" value="สถานที่สะอาดและมีความเหมาะสม">สถานที่สะอาดและมีความเหมาะสม</td>
						          <td><center><input type="radio" value="5" name="locationAndTime1"></center></td>
						          <td><center><input type="radio" value="4" name="locationAndTime1"></center></td>
						          <td><center><input type="radio" value="3" name="locationAndTime1"></center></td>
						          <td><center><input type="radio" value="2" name="locationAndTime1"></center></td>
						          <td><center><input type="radio" value="1" name="locationAndTime1"></center></td>
						        </tr>
						        <tr>
						          <td><input type="hidden" name="choiceLocationAndTime2" value="ความพร้อมของอุปกรณ์โสตทัศนูปกรณ์">ความพร้อมของอุปกรณ์โสตทัศนูปกรณ์</td>
						          <td><center><input type="radio" value="5" name="locationAndTime2"></center></td>
						          <td><center><input type="radio" value="4" name="locationAndTime2"></center></td>
						          <td><center><input type="radio" value="3" name="locationAndTime2"></center></td>
						          <td><center><input type="radio" value="2" name="locationAndTime2"></center></td>
						          <td><center><input type="radio" value="1" name="locationAndTime2"></center></td>
						        </tr>
						        <tr>
						          <td><input type="hidden" name="choiceLocationAndTime3" value="ระยะเวลาในการอบรม / สัมมนามีความเหมาะสม">ระยะเวลาในการอบรม / สัมมนามีความเหมาะสม</td>
						          <td><center><input type="radio" value="5" name="locationAndTime3"></center></td>
						          <td><center><input type="radio" value="4" name="locationAndTime3"></center></td>
						          <td><center><input type="radio" value="3" name="locationAndTime3"></center></td>
						          <td><center><input type="radio" value="2" name="locationAndTime3"></center></td>
						          <td><center><input type="radio" value="1" name="locationAndTime3"></center></td>
						        </tr>
						     </tbody>
						   </table>
						 </div>
						 
						 <div>
						<strong><font color="#5A9800"><input type="hidden" name="topicCognition" value="ด้านความรู้ความเข้าใจ">ด้านความรู้ความเข้าใจ </font></strong><font color="red" size="4px">*</font><br>
						<font>ความพึงพอใจ</font>
						</div>
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
						        <tr>
						          <td><input type="hidden" name="choiceCognition1" value="ความรู้ ความเข้าใจในเรื่องนี้ก่อนการอบรม">ความรู้ ความเข้าใจในเรื่องนี้ก่อนการอบรม</td>
						          <td><center><input type="radio" value="5" name="cognition1"></center></td>
						          <td><center><input type="radio" value="4" name="cognition1"></center></td>
						          <td><center><input type="radio" value="3" name="cognition1"></center></td>
						          <td><center><input type="radio" value="2" name="cognition1"></center></td>
						          <td><center><input type="radio" value="1" name="cognition1"></center></td>
						        </tr>
						        <tr>
						          <td><input type="hidden" name="choiceCognition2" value="ความรู้ ความเข้าใจในเรื่องนี้หลังการอบรม">ความรู้ ความเข้าใจในเรื่องนี้หลังการอบรม</td>
						          <td><center><input type="radio" value="5" name="cognition2"></center></td>
						          <td><center><input type="radio" value="4" name="cognition2"></center></td>
						          <td><center><input type="radio" value="3" name="cognition2"></center></td>
						          <td><center><input type="radio" value="2" name="cognition2"></center></td>
						          <td><center><input type="radio" value="1" name="cognition2"></center></td>
						        </tr>
						        <tr>
						          <td><input type="hidden" name="choiceCognition3" value="สามารถบอกประโยชน์ ได้">สามารถบอกประโยชน์ ได้</td>
						          <td><center><input type="radio" value="5" name="cognition3"></center></td>
						          <td><center><input type="radio" value="4" name="cognition3"></center></td>
						          <td><center><input type="radio" value="3" name="cognition3"></center></td>
						          <td><center><input type="radio" value="2" name="cognition3"></center></td>
						          <td><center><input type="radio" value="1" name="cognition3"></center></td>
						        </tr>
						        <tr>
						          <td><input type="hidden" name="choiceCognition4" value="สามารถบอกข้อดีได้">สามารถบอกข้อดีได้</td>
						          <td><center><input type="radio" value="5" name="cognition4"></center></td>
						          <td><center><input type="radio" value="4" name="cognition4"></center></td>
						          <td><center><input type="radio" value="3" name="cognition4"></center></td>
						          <td><center><input type="radio" value="2" name="cognition4"></center></td>
						          <td><center><input type="radio" value="1" name="cognition4"></center></td>
						        </tr>
						        <tr>
						          <td><input type="hidden" name="choiceCognition5" value="สามารถอธิบายรายละเอียดได้">สามารถอธิบายรายละเอียดได้</td>
						          <td><center><input type="radio" value="5" name="cognition5"></center></td>
						          <td><center><input type="radio" value="4" name="cognition5"></center></td>
						          <td><center><input type="radio" value="3" name="cognition5"></center></td>
						          <td><center><input type="radio" value="2" name="cognition5"></center></td>
						          <td><center><input type="radio" value="1" name="cognition5"></center></td>
						        </tr>
						        <tr>
						          <td><input type="hidden" name="choiceCognition6" value="สามารถจัดระบบความคิด/ประมวลความคิดสู่การพัฒนางานอย่างเป็นระบบ">สามารถจัดระบบความคิด/ประมวลความคิดสู่การ<br>พัฒนางานอย่างเป็นระบบ</td>
						          <td><center><input type="radio" value="5" name="cognition6"></center></td>
						          <td><center><input type="radio" value="4" name="cognition6"></center></td>
						          <td><center><input type="radio" value="3" name="cognition6"></center></td>
						          <td><center><input type="radio" value="2" name="cognition6"></center></td>
						          <td><center><input type="radio" value="1" name="cognition6"></center></td>
						        </tr>
						        <tr>
						          <td><input type="hidden" name="choiceCognition7" value="บูรณาการทางความคิดสู่การทำงานเป็นทีม/การปรับตัวของบุคลากร/การปฏิรูประบบการทำงานในการปฏิบัติงาน">บูรณาการทางความคิดสู่การทำงานเป็นทีม<br>/การปรับตัวของบุคลากร/การปฏิรูประบบ<br>การทำงานในการปฏิบัติงาน</td>
						          <td><center><input type="radio" value="5" name="cognition7"></center></td>
						          <td><center><input type="radio" value="4" name="cognition7"></center></td>
						          <td><center><input type="radio" value="3" name="cognition7"></center></td>
						          <td><center><input type="radio" value="2" name="cognition7"></center></td>
						          <td><center><input type="radio" value="1" name="cognition7"></center></td>
						        </tr>
						     </tbody>
						   </table>
						 </div>
						 
						 <div>
						<strong><font color="#5A9800"><input type="hidden" name="topicUseKnowledge" value="ด้านการนำความรู้ไปใช้">ด้านการนำความรู้ไปใช้ </font></strong><font color="red" size="4px">*</font><br>
						<font>ความพึงพอใจ</font>
						</div>
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
						        <tr>
						          <td><input type="hidden" name="choiceUseKnowledge1" value="สามารถนำความรู้ที่ได้รับไปประยุกต์ใช้ในการปฏิบัติงานได้">สามารถนำความรู้ที่ได้รับไปประยุกต์ใช้ในการปฏิบัติ<br>งานได้</td>
						          <td><center><input type="radio" value="5" name="useKnowledge1"></center></td>
						          <td><center><input type="radio" value="4" name="useKnowledge1"></center></td>
						          <td><center><input type="radio" value="3" name="useKnowledge1"></center></td>
						          <td><center><input type="radio" value="2" name="useKnowledge1"></center></td>
						          <td><center><input type="radio" value="1" name="useKnowledge1"></center></td>
						        </tr>
						        <tr>
						          <td><input type="hidden" name="choiceUseKnowledge2" value="สามารถนำความรู้ไปเผยแพร่ / ถ่ายทอดแก่ชุมชนได้">สามารถนำความรู้ไปเผยแพร่ / ถ่ายทอดแก่ชุมชนได้</td>
						          <td><center><input type="radio" value="5" name="useKnowledge2"></center></td>
						          <td><center><input type="radio" value="4" name="useKnowledge2"></center></td>
						          <td><center><input type="radio" value="3" name="useKnowledge2"></center></td>
						          <td><center><input type="radio" value="2" name="useKnowledge2"></center></td>
						          <td><center><input type="radio" value="1" name="useKnowledge2"></center></td>
						        </tr>
						        <tr>
						          <td><input type="hidden" name="choiceUseKnowledge3" value="สามารถให้คำปรึกษาแก่เพื่อนร่วมงานได้">สามารถให้คำปรึกษาแก่เพื่อนร่วมงานได้</td>
						          <td><center><input type="radio" value="5" name="useKnowledge3"></center></td>
						          <td><center><input type="radio" value="4" name="useKnowledge3"></center></td>
						          <td><center><input type="radio" value="3" name="useKnowledge3"></center></td>
						          <td><center><input type="radio" value="2" name="useKnowledge3"></center></td>
						          <td><center><input type="radio" value="1" name="useKnowledge3"></center></td>
						        </tr>
						        <tr>
						          <td><input type="hidden" name="choiceUseKnowledge4" value="มีความมั่นใจและสามารถนำความรู้ที่ได้รับไปใช้ได้">มีความมั่นใจและสามารถนำความรู้ที่ได้รับไปใช้ได้</td>
						          <td><center><input type="radio" value="5" name="useKnowledge4"></center></td>
						          <td><center><input type="radio" value="4" name="useKnowledge4"></center></td>
						          <td><center><input type="radio" value="3" name="useKnowledge4"></center></td>
						          <td><center><input type="radio" value="2" name="useKnowledge4"></center></td>
						          <td><center><input type="radio" value="1" name="useKnowledge4"></center></td>
						        </tr>
						    </tbody>
						  </table>
						</div>
						
						<div>
						<strong><font color="#5A9800"><input type="hidden" name="topicComment" value="ข้อเสนอแนะอื่นๆ">ข้อเสนอแนะอื่นๆ</font></strong>
						</div>
						<div><textarea class="form-control" rows="3" name="comment"></textarea><br></div>
						<div>
							<b>หมายเหตุ </b><font color="red">ผู้เข้าอบรมสามารถดาวน์โหลดเอกสารประกอบการอบรม หลังจากประเมินการอบรมเรียบร้อยแล้ว</font>
						</div>
						<br>
						<div align="center">
							<button class="btn btn-default" type="submit" class="btn">ตกลง</button>
							<button class="btn btn-default" type="reset" class="btn">ยกเลิก</button>
							
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