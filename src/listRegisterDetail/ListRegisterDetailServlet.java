package listRegisterDetail;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import fillRegisterProfile.*;

/**
 * Servlet implementation class ListProfileDetailServlet
 */
@WebServlet("/ListRegisterDetailServlet")
public class ListRegisterDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListRegisterDetailServlet() {
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

		TraineeBean traineeBean = (TraineeBean) session.getAttribute("traineeBean");
		if (traineeBean == null) {
			traineeBean = new TraineeBean();
			session.setAttribute("traineeBean", traineeBean);
		}
		try {
			FillRegisterProfileManager fillMng = new FillRegisterProfileManager();
			String username = "unchalee";
			traineeBean = fillMng.searchTraineeByUsername(username);
			session.setAttribute("traineeBean", traineeBean);
			response.sendRedirect("ListRegisterDetail.jsp");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
