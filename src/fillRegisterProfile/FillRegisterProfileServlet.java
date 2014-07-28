package fillRegisterProfile;

import java.io.IOException;
import java.util.Calendar;
import java.util.Vector;

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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

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
		String[] job = request.getParameterValues("checkboxjob");
		String other = request.getParameter("textjobOther");
		String telNo = request.getParameter("texttelno");
		String email = request.getParameter("textemail");

		String workplace = request.getParameter("textworkplace");
		if (workplace == null || workplace == "") {
			workplace = "-";
		}
		String addressNo = request.getParameter("textno");
		String street = request.getParameter("textstreet");
		if (street == null || street == "") {
			street = "-";
		}
		String subDistrict = request.getParameter("textsubdistrict");
		String district = request.getParameter("textdistrict");
		String province = request.getParameter("textprovince");
		String zipcode = request.getParameter("textzipcode");

		String username = request.getParameter("textusername");
		String password = request.getParameter("textpassword");
		String confirmPassword = request.getParameter("textconfirmpassword");

		TraineeBean traineeBean = new TraineeBean();
		traineeBean.setTitle(title);
		traineeBean.setName(name);
		traineeBean.setEducation(education);
		traineeBean.setTelNo(telNo);
		traineeBean.setEmail(email);
		traineeBean.setTraineeStatus("ยังไม่ได้ชำระเงิน");

		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int date = calendar.get(Calendar.DATE);
		String registerDate = year + "-" + (month + 1) + "-" + date;
		traineeBean.setRegisterDate(registerDate);

		Vector<OccupationBean> occupationVector = new Vector<OccupationBean>();
		OccupationBean occ1 = new OccupationBean(false, "Tester");
		OccupationBean occ2 = new OccupationBean(false, "Administrator");
		OccupationBean occ3 = new OccupationBean(false, "Programmer");
		OccupationBean occ4 = new OccupationBean(false, "System analyst");
		OccupationBean occ5 = new OccupationBean(false, "Other");
		occupationVector.add(occ1);
		occupationVector.add(occ2);
		occupationVector.add(occ3);
		occupationVector.add(occ4);
		occupationVector.add(occ5);

		traineeBean.setOccVector(occupationVector);

		for (int i = 0; i < job.length; i++) {
			for (int j = 0; j < traineeBean.getOccVector().size(); j++) {
				if (traineeBean.getOccVector().get(j).getOccupationName()
						.equals(job[i])) {
					traineeBean.getOccVector().get(j).setSelected(true);
					if (job[i].equals("Other")) {
						traineeBean.setOther(other);
					}
					break;
				}
			}
		}

		AddressBean addressBean = new AddressBean(workplace, addressNo, street,
				subDistrict, district, province, zipcode);
		LoginBean loginBean = new LoginBean(username, password, "Trainee");

		traineeBean.setAddress(addressBean);
		traineeBean.setLogin(loginBean);
		
		try {
			boolean verifyLoginOfTrainee = fillRegisterMng.verifyLogin(traineeBean.getLogin());

			if (!verifyLoginOfTrainee) {
				// 13 – ระบบค้นหาจำนวนผู้เข้าอบรมของการลงทะเบียนอบรมหลักสูตรนั้น
				// ๆจากฐานข้อมูล
				// 14 – ระบบคืนค่าการค้นหาจากฐานข้อมูล
				String traineePayment = fillRegisterMng
						.createFrangmentPayment(registerBean);
				System.out.println(traineePayment);
				traineeBean.setTraineePayment(traineePayment);
				boolean addTrainee = fillRegisterMng.addTrainee(traineeBean);
				if (addTrainee) {
					boolean addAddress = fillRegisterMng.addAddress(traineeBean);
					boolean addLogin = fillRegisterMng.addLogin(traineeBean);
					boolean isOccExist = fillRegisterMng.isOccExist(other);
					if (!isOccExist) {
						boolean addOccupation = fillRegisterMng.addOccupation(traineeBean);
					}
					boolean addTraineeOccupation = fillRegisterMng.addTraineeOccupation(traineeBean);
				} else {
					System.out.println("เกิดข้อผิดพลาด : ไม่สามารถลงทะเบียนได้");
				}
			} else {
				System.out.println("ขออภัย   ชื่อผู้ใช้ที่ท่านกำหนดไม่สามารถใช้งานได้   เนื่องจากมีผู้ใช้งานแล้ว");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
