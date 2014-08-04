package com.itsci.cancel_register;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itsci.fill_register_profile.FillRegisterProfileManager;
import com.itsci.fill_register_profile.TraineeBean;

/**
 * Servlet implementation class CancleRegisterServlet
 */
@WebServlet("/CancelRegisterServlet")
public class CancelRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CancelRegisterServlet() {
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
		String status = request.getParameter("editBtn");
		HttpSession session = request.getSession();
		TraineeBean trainee = (TraineeBean) session.getAttribute("traineeBean");

		FillRegisterProfileManager registerProfileMng = FillRegisterProfileManager
				.getInstance();

		registerProfileMng.editTraineeStatus(trainee.getName(),status);

		System.out.println("cancle : " + trainee.getName());
	}

}
