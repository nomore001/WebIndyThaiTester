package login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fillRegisterProfile.LoginBean;
import fillRegisterProfile.TraineeBean;

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
		// Connection conn = MySQLConnectionPool.getConnection();
		// try {
		// String query = "SELECT * FROM coursetraining";
		//
		// // create the java statement
		//
		// PreparedStatement st = conn.prepareStatement(query);
		//
		// // execute the query, and get a java resultset
		// ResultSet rs = st.executeQuery(query);
		//
		// // iterate through the java resultset
		// while (rs.next())
		// {
		// String cn = rs.getString("courseName");
		// System.out.println(cn);
		// }
		// st.close();
		// conn.close();
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

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
		LoginManager loginMgr = LoginManager.getInstance();

		if (loginMgr.verifyLogin(login)) {
			TraineeBean trainee = loginMgr.searchTraineeByUsername(login
					.getUsername());
			HttpSession session = request.getSession();
			session.setAttribute("traineeBean", trainee);
			if (loginMgr.searchUserAccessStatus(login.getUsername()).equals(
					"admin")) {
				response.sendRedirect("admin.jsp");
			} else {
				response.sendRedirect("test01.jsp");
			}
			System.out.println("pass");
		} else {
			System.out.println("fail");
			response.getWriter().print("fail");
			response.sendRedirect("index.jsp");
		}

	}
}
