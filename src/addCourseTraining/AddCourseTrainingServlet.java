package addCourseTraining;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

		SimpleDateFormat fromUser = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			String courseName = request.getParameter("textcourseName");
			int courseDuration = Integer.parseInt(request.getParameter("textcourseDuration"));
			String courseRegisterStartDate = myFormat.format(fromUser.parse(request.getParameter("textcourseRegisterStartDate")));
			int courseRegisterDuration = Integer.parseInt(request.getParameter("textcourseRegisterDuration"));
			String paymentStartDate = myFormat.format(fromUser.parse(request.getParameter("textpaymentStartDate")));
			int paymentDuration = Integer.parseInt(request.getParameter("textpaymentDuration"));
			String trainingStartDate = myFormat.format(fromUser.parse(request.getParameter("texttrainingStartDate")));
			int courseRegisterCosts = Integer.parseInt(request.getParameter("textcourseRegisterCosts"));

			CourseTrainingBean courseTrainingBean = (CourseTrainingBean) session
					.getAttribute("courseTrainingBean");
			if (courseTrainingBean == null) {
				courseTrainingBean = new CourseTrainingBean();
				session.setAttribute("courseTrainingBean", courseTrainingBean);
			}

			DownLoadDocumentManager downloadDocMng = new DownLoadDocumentManager(
					courseTrainingBean);

			boolean verifyCourse = downloadDocMng.isVerifyCourseTraining(
					courseName, courseDuration);

			if (!verifyCourse) {
				boolean ckAddCourse = downloadDocMng.addCourseTraining(
						courseName, courseDuration);
				if (ckAddCourse) {
					System.out.println("Add CourseTraining Success");
				} else {
					System.out.println("Add CourseTraining Fail");
				}
			} else {
				System.out.println("Has Course " + courseName);
			}

			int courseID = downloadDocMng.searchCourseId(courseName,
					courseDuration);
			// 9 – ระบบค้นหาจำนวนการลงทะเบียนของหลักสูตรการอบรมนั้น ๆ
			// จากฐานข้อมูล
			// 10 – ระบบคืนค่าการค้นหาจากฐานข้อมูล
			int registerAmount = downloadDocMng.sumOfRegister(courseID);
			// 11 – ระบบสร้างรหัสการลงทะเบียนโดยบวกรหัสการลงทะเบียนเพิ่มขึ้น 1
			// ลำดับ
			String registerNo = downloadDocMng.createRegisterNo(registerAmount);
			// 12 – ระบบบันทึกข้อมูลการเพิ่มหลักสูตรการอบรมลงฐานข้อมูล
			// 13 – ระบบคืนค่าสถานะการตรวจสอบจากฐานข้อมูล
			boolean ckAdd = downloadDocMng.addRegister(registerNo,
					courseRegisterStartDate, courseRegisterDuration,
					paymentStartDate, paymentDuration, trainingStartDate,
					courseRegisterCosts, courseID);

			if (ckAdd) {
				courseTrainingBean = downloadDocMng.theCourseTrainingBean;
				session.setAttribute("courseTrainingBean", courseTrainingBean);
				downloadDocMng.theCourseTrainingBean = null;
				System.out.println("Add Register Success");
			} else {
				System.out.println("Add Register Fail");
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
