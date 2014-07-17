package addCourseTraining;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import downLoadDocument.CourseTrainingBean;
import downLoadDocument.DownLoadDocumentManager;

@WebServlet("/AddCourseTrainingServlet")
public class AddCourseTrainingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCourseTrainingServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String courseName = "QTP";
		int courseDuration =10;
		String courseRegisterStartDate = "2014-1-1";
		int courseRegisterDuration = 4;
		String paymentStartDate = "2014-1-6";
		int paymentDuration = 3;
		String trainingStartDate = "2014-1-10";
		int courseRegisterCosts = 2500;
		
		CourseTrainingBean courseTrainingBean = (CourseTrainingBean) session.getAttribute("courseTrainingBean"); 
		if (courseTrainingBean == null) { 
			courseTrainingBean = new CourseTrainingBean(); 
			session.setAttribute("courseTrainingBean", courseTrainingBean);
		} 
		
		DownLoadDocumentManager downloadDocMng = new DownLoadDocumentManager(courseTrainingBean);
		
		boolean verifyCourse = downloadDocMng.isVerifyCourseTraining(courseName, courseDuration);
		
		if(!verifyCourse){
			boolean ckAddCourse = downloadDocMng.addCourseTraining(courseName, courseDuration);		
			if(ckAddCourse){
				System.out.println("Add CourseTraining Success");
			}else{
				System.out.println("Add CourseTraining Fail");
			}
		}else{
			System.out.println("Has Course " + courseName);
		}
		
		int courseID = downloadDocMng.searchCourseId(courseName, courseDuration);
//		9 – ระบบค้นหาจำนวนการลงทะเบียนของหลักสูตรการอบรมนั้น ๆ  จากฐานข้อมูล
//		10 – ระบบคืนค่าการค้นหาจากฐานข้อมูล
		int registerAmount  = downloadDocMng.sumOfRegister(courseID);
//		11 – ระบบสร้างรหัสการลงทะเบียนโดยบวกรหัสการลงทะเบียนเพิ่มขึ้น 1 ลำดับ
		String registerNo = downloadDocMng.createRegisterNo(registerAmount);
//		12 – ระบบบันทึกข้อมูลการเพิ่มหลักสูตรการอบรมลงฐานข้อมูล
//		13 – ระบบคืนค่าสถานะการตรวจสอบจากฐานข้อมูล
		boolean ckAdd = downloadDocMng.addRegister(registerNo, courseRegisterStartDate, 
				courseRegisterDuration, paymentStartDate, paymentDuration, trainingStartDate, 
				courseRegisterCosts, courseID);
		
		if(ckAdd){
			System.out.println("Add Register Success");
		}else{
			System.out.println("Add Register Fail");
		}
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
