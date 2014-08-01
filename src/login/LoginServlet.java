
package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fillRegisterProfile.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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

		LoginBean login = new LoginBean();
		login.setUsername(request.getParameter("username_login"));
		login.setPassword(request.getParameter("password_login"));
		FillRegisterProfileManager loginMgr = FillRegisterProfileManager.getInstance();

		if (loginMgr.verifyLogin(login)) {
			TraineeBean trainee = loginMgr.searchTraineeByUsername(login
					.getUsername());
			HttpSession session = request.getSession();
			session.setAttribute("traineeBean", trainee);
			if (loginMgr.searchUserAccessStatus(login.getUsername()).equals(
					"admin")) {
				response.sendRedirect("ListCourseTrainingServlet");
			} else {
				response.sendRedirect("ListRegisterDetail.jsp");
			}
			System.out.println("pass");
		} else {
			System.out.println("fail");
			response.getWriter().print("fail");
			response.sendRedirect("index.jsp");
		}

	}
}