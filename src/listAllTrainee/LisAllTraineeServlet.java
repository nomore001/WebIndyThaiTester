package listAllTrainee;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fillRegisterProfile.FillRegisterProfileManager;
import fillRegisterProfile.TraineeBean;

/**
 * Servlet implementation class LisAllTrainee
 */
@WebServlet("/LisAllTraineeServlet")
public class LisAllTraineeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LisAllTraineeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String registerNo = request.getParameter("registerNo");
		System.out.print("KK" + registerNo);
		FillRegisterProfileManager fillregisterMng = FillRegisterProfileManager
				.getInstance();
		int regiserId = fillregisterMng.searchRegisterId(registerNo);
		Vector<TraineeBean> traineeVector = new Vector<TraineeBean>();
		traineeVector = fillregisterMng.listTraineeByRegisterId(regiserId);

		System.out.println(traineeVector.elementAt(0).getName());
		session.setAttribute("allTraineeBean", traineeVector);
		response.sendRedirect("listAllTrainee.jsp");
		
	}

}
