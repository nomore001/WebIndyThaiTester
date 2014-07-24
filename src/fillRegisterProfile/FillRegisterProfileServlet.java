package fillRegisterProfile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FillRegisterProfileServlet")
public class FillRegisterProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FillRegisterProfileServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		RegisterBean registerBean = (RegisterBean) session
				.getAttribute("registerBean");
		if (registerBean == null) {
			registerBean = new RegisterBean();
			session.setAttribute("registerBean", registerBean);
		}

		FillRegisterProfileManager fillRegisterMng = FillRegisterProfileManager
				.getInstance();
		fillRegisterMng.initFillRegisterProfileManager(registerBean);
		// ดึงข้อมูล register ณ ปัจจุบัน
		registerBean = fillRegisterMng.getRegisterNow();
		System.out.println(registerBean.getRegisterNo());

		String title = request.getParameter("radiotitle");
		String name = request.getParameter("textname");
		String education = request.getParameter("selecteducation");
		// String[] job = request.getParameterValues("checkboxjob");
		// String jobs = "";
		// String jobOther = "";
		// int count = 1;
		// for (int i = 0; i < job.length; i++) {
		// if (job[i].equals("Other")) {
		// jobOther = request.getParameter("textjobOther");
		// if (count == job.length) {
		// jobs += jobOther;
		// } else {
		// jobs += jobOther + ",";
		// }
		// } else {
		// if (count == job.length) {
		// jobs += job[i];
		// } else {
		// jobs += job[i] + ",";
		// }
		// }
		// count++;
		// }
		// Occupation occ1 = new Occupation(true, "Tester");
		// Occupation occ2 = new Occupation(false, "Administrator");
		// Occupation occ3 = new Occupation(false, "Programmer");
		// Occupation occ4 = new Occupation(false, "System analyst");
		// Occupation occ5 = new Occupation(true, "Other");
		String other = request.getParameter("textjobOther");
		String telNo = request.getParameter("texttelno");
		String email = request.getParameter("textemail");

		String workplace = request.getParameter("textworkplace");
		String addressNo = request.getParameter("textno");
		String street = request.getParameter("textstreet");
		String subDistrict = request.getParameter("textsubdistrict");
		String district = request.getParameter("textdistrict");
		String province = request.getParameter("textprovince");
		String zipcode = request.getParameter("textzipcode");

		String username = request.getParameter("textusername");
		String password = request.getParameter("textpassword");
		String confirmPassword = request.getParameter("textconfirmpassword");
		LoginBean loginBean = new LoginBean(username, password);
		boolean verifyLoginOfTrainee = fillRegisterMng.verifyLogin(loginBean);

		if (!verifyLoginOfTrainee) {
			// 13 – ระบบค้นหาจำนวนผู้เข้าอบรมของการลงทะเบียนอบรมหลักสูตรนั้น ๆ
			// จากฐานข้อมูล
			// 14 – ระบบคืนค่าการค้นหาจากฐานข้อมูล
			int sumOfTrainee = fillRegisterMng.sumOfTrainee(registerBean);
			String traineePayment = fillRegisterMng.createFrangmentPayment(sumOfTrainee);
		}
	}

}
