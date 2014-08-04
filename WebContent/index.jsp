<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Indy Thai Tester</title>

<!-- Bootstrap core CSS -->
<!-- <link href="assets/css/bootstrap.css" rel="stylesheet"> -->
<!-- <link href="assets/css/style.css" rel="stylesheet"> -->
<link href="assets/css/jquery-ui.css" rel="stylesheet">


<link href="assets/css/bootstrap2.css" rel="stylesheet">
<link href="assets/css/style2.css" rel="stylesheet">


</head>
<body onload="setHeight()">
	<%@include file="floatpage/menu2.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-2"
				style=" height: auto;">
					<div class="panel panel-primary">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        LINK</h3>
                </div>
                
						<div class="carousel-inner2">
							
							<ul class="nav nav-pills nav-stacked">
								<li><a href="http://www.itsci.mju.ac.th"><i
										class="glyphicon glyphicon-hand-right"></i><b> เว็บไซต์หลักสาขา</b></a></li>
								<li><a href="http://www.jquery2dotnet.com"><i
										class="glyphicon glyphicon-book"></i> <b>ร้านหนังสือ IT</b></a></li>
								
							</ul>
						</div>
						</div>
					
			</div>
			<div class="col-md-9 carousel-inner2 carousel-inner3"
				style="background-color: #FFF; padding-bottom: 2px; padding: 10px 0 10px 0; margin-bottom: 10px;">
				<div class="col-md-6">
					<div class="col-md-12 registerDate ui-corner-top ui-corner-all">
						<a> <font color="red"><img
								src="assets/img/promotion.png">

								ปิดรับสมัครลงทะเบียนเข้าอบรมแล้ว </font>

						</a> <br></br> <em> <u>หมายเหตุ</u> <font color="red">

								เว็บนี้ใช้สำหรับทดสอบซอฟต์แวร์ในการอบรบเท่านั้น </font>

						</em>
					</div>

					<div class="col-md-12 picSlideShow ui-corner-top ui-corner-all">
						<div id="carousel-example-generic" class="carousel slide"
							data-ride="carousel">
							Indicators
							<ol class="carousel-indicators">
								<li data-target="#carousel-example-generic" data-slide-to="0"
									class="active"></li>
								<li data-target="#carousel-example-generic" data-slide-to="1"></li>
								<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							</ol>

							Wrapper for slides
							<div class="carousel-inner">
								<div class="item active">
									<img src="assets/img/relations.png" alt="...">
									<div class="carousel-caption">
										<h4>Heading</h4>
									</div>
								</div>
								<div class="item">
									<img src="http://placehold.it/800x400" alt="...">
									<div class="carousel-caption">
										<h4>Heading</h4>
									</div>
								</div>
								<div class="item">
									<img src="http://placehold.it/800x400" alt="...">
									<div class="carousel-caption">
										<h4>Heading</h4>
									</div>
								</div>
							</div>

							Controls <a class="left carousel-control"
								href="#carousel-example-generic" data-slide="prev"> <span
								class="glyphicon glyphicon-chevron-left"></span>
							</a> <a class="right carousel-control"
								href="#carousel-example-generic" data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right"></span>
							</a>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div id="accordion">
						<h3>บทนำ</h3>
						<div id="paragraph">
							<p>โครงการฝึกอบรมเชิงปฏิบัติการ QuickTest Professional for
								Beginner
								เป็นหลักสูตรที่ต้องการเพิ่มทักษะให้แก่นักทดสอบหรือผู้สนใจเข้าสู่อาชีพนักทดสอบซอฟต์แวร์
								ในการใช้เครื่องมือทดสอบแบบอัตโนมัติที่ได้รับความนิยมสูงสุด
								ได้แก่ Quick Test Professional
								เนื้อหาการอบรมจะเน้นด้านปฏิบัติการทดสอบเว็บแอพพลิเคชั่นเป็นหลัก
								นอกจากนั้นยังครอบคลุมหลักการสำคัญของการทดสอบอัตโนมัติ อาทิ
								เทคนิคการ Record & Playback, Data Driven Framework ตลอดจน
								Keyword Driven Framework ตามลำดับ</p>
						</div>
						<h3>ระยะเวลาการอบรม</h3>
						<div id="paragraph2">
							<p>3 วัน 27 - 29 มีนาคม 2556 ตั้งแต่ 09.00 - 16.00 น. รวม 18
								ชั่วโมง</p>
						</div>
						<h3>วิทยากร</h3>
						<div id="paragraph3">
							<p>รองศาสตราจารย์รังสิต ศิริรังษี</p>
						</div>
						<h3>ค่าใช้จ่ายในการอบรม</h3>
						<div id="paragraph4">
							<p>2,000 บาท (ไม่รวมภาษี) ต่อหนึ่งท่าน</p>
						</div>
						<h3>จำนวนการรับสมัคร</h3>
						<div id="paragraph5">
							<p>จำนวน จำกัดที่ 30 ที่นั่ง</p>
						</div>
						<h3>รายละเอียดอื่น ๆ</h3>
						<div id="paragraph6">
							<p>
								QuickTest Professional หรือเรียกสั้น ๆ ว่า QTP
								เป็นเครื่องมือทดสอบอัตโนมัติที่ปัจจุบันอยู่ภายใต้บริษัท HP
								โดยเริ่มต้นพัฒนาครั้งแรกในปี 2002
								และมีความสามารถทำงานในสภาพแวดล้อมดังต่อไปนี้

								ทำงานบนระบบปฏิบัติการ Windows สนับสนุนภาษาโปรแกรม C++, Visual
								Basic, Java, .NET สามารถทดสอบวินโดวส์และเว็บแอพพลิเคชั่น Web
								Applications, Web services, Flash
								สนับสนุนการทำงานร่วมกับเทคโนโลยีอื่น ๆ เช่น SAP, Siebel, Oracle,
								Peoplesoft, ActiveX QTP
								ถือเป็นเครื่องมือทดสอบที่ได้รับความนิยมมากที่สุดในโลก โดยในปี
								2008 เป็นเจ้าของสัดส่วนในตลาดสูงถึง 60 %
								เมื่อเปรียบเทียบกับเครื่องมือทดสอบอัตโนมัติชนิดอื่น ๆ





								นอกจากนั้นนักทดสอบที่มีทักษะในการใช้เครื่องมือทดสอบ QuickTest
								Professional ยังเป็นที่ต้องการของตลาดเป็นอันดับต้น ๆ
								ของอเมริกาจากข้อมูลของเว็บไซด์ www.indeed.com
								แสดงผลการเปรียบเทียบแนวโน้มความต้องการของตลาดในส่วนของนักทดสอบที่ใช้เครื่องมือทดสอบอัตโนมัติดังกราฟต่อไปนี้



								<br> <br> <b><u>หมายเหตุ</u>
									ผู้เข้าร่วมการอบรมจะต้องนำโน๊ตบุ๊คมาใช้ในการฝึกปฏิบัติการ
									ในกรณีที่สามารถนำ Aircard
									มาด้วยจะเป็นประโยชน์อย่างยิ่งในการอบรม
									ระบบปฏิบัติการที่เหมาะสมในการอบรมครั้งนี้ได้แก่ Windows 7 32
									bit หรือ 64 bit</b>
							</p>
						</div>
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
	<script>
		$(function() {
			$("#accordion").accordion();
		});

		function setHeight() {
			document.getElementById("paragraph").style.height = "auto";
			document.getElementById("paragraph2").style.height = "auto";
			document.getElementById("paragraph3").style.height = "auto";
			document.getElementById("paragraph4").style.height = "auto";
			document.getElementById("paragraph5").style.height = "auto";
			document.getElementById("paragraph6").style.height = "auto";
		}
	</script>
</body>
</html>