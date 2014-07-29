package editRegisterProfile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fillRegisterProfile.*;

/**
 * Servlet implementation class EditRegisterProfile
 */
@WebServlet("/EditRegisterProfileServlet")
public class EditRegisterProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditRegisterProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		FillRegisterProfileManager manager = new FillRegisterProfileManager();
		TraineeBean traineeBean = (TraineeBean) session.getAttribute("traineeBean");
		session.setAttribute("traineeBean", traineeBean);
		response.sendRedirect("EditRegisterProfile.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		TraineeBean traineeBean = (TraineeBean) session
				.getAttribute("traineeBean");
		if (traineeBean == null) {
			traineeBean = new TraineeBean();
			session.setAttribute("traineeBean", traineeBean);
		}
		
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
		String traineeStatus = request.getParameter("texttraineestatus");

		traineeBean.setTitle(title);
		traineeBean.setName(name);
		traineeBean.setEducation(education);
		traineeBean.setTelNo(telNo);
		traineeBean.setEmail(email);
		traineeBean.setTraineeStatus(traineeStatus);
	}

}
