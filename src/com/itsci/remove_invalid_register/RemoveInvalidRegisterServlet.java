package com.itsci.remove_invalid_register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itsci.fill_register_profile.FillRegisterProfileManager;

/**
 * Servlet implementation class RemoveInvalidRegister
 */
@WebServlet("/RemoveInvalidRegisterServlet")
public class RemoveInvalidRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveInvalidRegisterServlet() {
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
		try {
			String name = request.getParameter("traineeName");
			System.out.println(name);
			FillRegisterProfileManager registerMng = FillRegisterProfileManager
					.getInstance();

			registerMng.removeInvalidTrainee(name);

			response.sendRedirect("ListAllTraineeServlet");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
