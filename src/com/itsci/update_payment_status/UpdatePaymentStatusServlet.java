package com.itsci.update_payment_status;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itsci.fill_register_profile.FillRegisterProfileManager;
import com.itsci.fill_register_profile.TraineeBean;

/**
 * Servlet implementation class UpdaePaymentStatusServlet
 */
@WebServlet("/UpdatePaymentStatusServlet")
public class UpdatePaymentStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdatePaymentStatusServlet() {
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
		try {
			String name = request.getParameter("traineeName");
			String status = request.getParameter("status");
			String registerNo = request.getParameter("registerNo");

			FillRegisterProfileManager fillregisterProfileMng = FillRegisterProfileManager
					.getInstance();

			fillregisterProfileMng.editTraineeStatus(name, status);

			System.out.println(name + registerNo);
			FillRegisterProfileManager fillregisterMng = FillRegisterProfileManager
					.getInstance();
			int regiserId = fillregisterMng.searchRegisterId(registerNo);
			Vector<TraineeBean> traineeVector = new Vector<TraineeBean>();
			traineeVector = fillregisterMng.listTraineeByRegisterId(regiserId);

			session.setAttribute("registerNo", registerNo);
			session.setAttribute("allTraineeBean", traineeVector);
			response.sendRedirect("listAllTrainee.jsp");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
