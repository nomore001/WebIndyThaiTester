package com.itsci.list_all_register;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itsci.fill_register_profile.FillRegisterProfileManager;
import com.itsci.fill_register_profile.RegisterBean;

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

		System.out.println(courseID);

		HttpSession session = request.getSession();

		try {
			FillRegisterProfileManager fillRegisterProfile = FillRegisterProfileManager
					.getInstance();
			Vector<RegisterBean> registerBeanVector = new Vector<RegisterBean>();

			registerBeanVector = fillRegisterProfile.listAllRegister(Integer
					.parseInt(courseID));
			session.setAttribute("registerBeanVector", registerBeanVector);

			for (int i = 0; i < registerBeanVector.size(); i++) {
				System.out.println(registerBeanVector.elementAt(i)
						.getRegisterNo());
			}

			response.sendRedirect("listAllRegister.jsp");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
