package listAllRegister;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fillRegisterProfile.FillRegisterProfileManager;
import fillRegisterProfile.RegisterBean;

/**
 * Servlet implementation class ListAllRegisterServlet
 */
@WebServlet("/ListAllRegisterServlet")
public class ListAllRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListAllRegisterServlet() {
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
		String courseID = request.getParameter("courseID");

		HttpSession session = request.getSession();

		FillRegisterProfileManager fillRegisterProfile = FillRegisterProfileManager
				.getInstance();
		Vector<RegisterBean> registerBeanVector = new Vector<RegisterBean>();

		registerBeanVector = fillRegisterProfile.listAllRegister(Integer
				.parseInt(courseID));
		session.setAttribute("registerBean", registerBeanVector);

		System.out.println(registerBeanVector.elementAt(0).getRegisterNo());

		response.sendRedirect("listAllRegister.jsp");
	}

}
