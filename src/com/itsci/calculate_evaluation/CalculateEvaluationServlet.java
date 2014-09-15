package com.itsci.calculate_evaluation;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itsci.evaluation.EvaluationManager;
import com.itsci.fill_register_profile.FillRegisterProfileManager;
import com.itsci.fill_register_profile.RegisterBean;
import com.itsci.fill_register_profile.TraineeBean;

/**
 * Servlet implementation class CalculateEvaluationServlet
 */
@WebServlet("/CalculateEvaluationServlet")
public class CalculateEvaluationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculateEvaluationServlet() {
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
			String registerNo = request.getParameter("registerNo");
			
			FillRegisterProfileManager fillRegisterMng = FillRegisterProfileManager
					.getInstance();
			RegisterBean registerBean = fillRegisterMng.searchRegisterByRegisterNo(registerNo);
			int registerID = fillRegisterMng.searchRegisterId(registerNo);
			Vector<TraineeBean> traineeVector = fillRegisterMng
					.listTraineeByRegisterId(registerID);
			registerBean.setTraineeVector(traineeVector);

			int sumOfTrainee = fillRegisterMng
					.sumOfTraineeEvaluation(registerBean);

			EvaluationManager evaluationMng = EvaluationManager.getInstance();

			String[] allTopicName = evaluationMng.getAllTopic(registerBean);
			double[] totalTopic = evaluationMng.calculateTotalAllEvaluation(
					registerBean, sumOfTrainee);
			String suggestion = evaluationMng.totalSuggestion(registerBean,
					sumOfTrainee);

			System.out.println("จำนวนผู้เข้าร่วมอบรม " + sumOfTrainee);
			for (int i = 0; i < allTopicName.length; i++) {
				System.out.println(allTopicName[i]);
				if (i == (allTopicName.length - 1)) {
					System.out.println("\t" + suggestion);
				} else {
					System.out.println("\t" + totalTopic[i]);
				}
			}

			session.setAttribute("sumOfTrainee", sumOfTrainee);
			session.setAttribute("allTopicName", allTopicName);
			session.setAttribute("totalTopic", totalTopic);
			session.setAttribute("suggestion", suggestion);
			response.sendRedirect("viewEvaluationTotal.jsp");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
