package evaluation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fillRegisterProfile.*;

/**
 * Servlet implementation class EvaluationServlet
 */
@WebServlet("/EvaluationServlet")
public class EvaluationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EvaluationServlet() {
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

		TraineeBean traineeBean = (TraineeBean) session
				.getAttribute("traineeBean");
		if (traineeBean == null) {
			traineeBean = new TraineeBean();
			session.setAttribute("traineeBean", traineeBean);
		}

		String topicLecture = request.getParameter("topicLecture");
		String choiceLecture1 = request.getParameter("choiceLecture1");
		int lecture1 = Integer.parseInt(request.getParameter("lecture1"));
		String choiceLecture2 = request.getParameter("choiceLecture2");
		int lecture2 = Integer.parseInt(request.getParameter("lecture2"));
		String choiceLecture3 = request.getParameter("choiceLecture3");
		int lecture3 = Integer.parseInt(request.getParameter("lecture3"));
		String choiceLecture4 = request.getParameter("choiceLecture4");
		int lecture4 = Integer.parseInt(request.getParameter("lecture4"));
		String choiceLecture5 = request.getParameter("choiceLecture5");
		int lecture5 = Integer.parseInt(request.getParameter("lecture5"));

		String topicLocationAndTime = request
				.getParameter("topicLocationAndTime");
		String choiceLocationAndTime1 = request
				.getParameter("choiceLocationAndTime1");
		int locationAndTime1 = Integer.parseInt(request
				.getParameter("locationAndTime1"));
		String choiceLocationAndTime2 = request
				.getParameter("choiceLocationAndTime2");
		int locationAndTime2 = Integer.parseInt(request
				.getParameter("locationAndTime2"));
		String choiceLocationAndTime3 = request
				.getParameter("choiceLocationAndTime3");
		int locationAndTime3 = Integer.parseInt(request
				.getParameter("locationAndTime3"));

		String topicCognition = request.getParameter("topicCognition");
		String choiceCognition1 = request.getParameter("choiceCognition1");
		int cognition1 = Integer.parseInt(request.getParameter("cognition1"));
		String choiceCognition2 = request.getParameter("choiceCognition2");
		int cognition2 = Integer.parseInt(request.getParameter("cognition2"));
		String choiceCognition3 = request.getParameter("choiceCognition3");
		int cognition3 = Integer.parseInt(request.getParameter("cognition3"));
		String choiceCognition4 = request.getParameter("choiceCognition4");
		int cognition4 = Integer.parseInt(request.getParameter("cognition4"));
		String choiceCognition5 = request.getParameter("choiceCognition5");
		int cognition5 = Integer.parseInt(request.getParameter("cognition5"));
		String choiceCognition6 = request.getParameter("choiceCognition6");
		int cognition6 = Integer.parseInt(request.getParameter("cognition6"));
		String choiceCognition7 = request.getParameter("choiceCognition7");
		int cognition7 = Integer.parseInt(request.getParameter("cognition7"));

		String topicUseKnowledge = request.getParameter("topicUseKnowledge");
		String choiceUseKnowledge1 = request
				.getParameter("choiceUseKnowledge1");
		int useKnowledge1 = Integer.parseInt(request
				.getParameter("useKnowledge1"));
		String choiceUseKnowledge2 = request
				.getParameter("choiceUseKnowledge2");
		int useKnowledge2 = Integer.parseInt(request
				.getParameter("useKnowledge2"));
		String choiceUseKnowledge3 = request
				.getParameter("choiceUseKnowledge3");
		int useKnowledge3 = Integer.parseInt(request
				.getParameter("useKnowledge3"));
		String choiceUseKnowledge4 = request
				.getParameter("choiceUseKnowledge4");
		int useKnowledge4 = Integer.parseInt(request
				.getParameter("useKnowledge4"));

		String topicComment = request.getParameter("topicComment");
		String comment = request.getParameter("comment");

		if (comment == "" || comment == null) {
			comment = "-";
		}

		ChoiceBean choiceBeanLecture1 = new ChoiceBean(choiceLecture1, lecture1);
		ChoiceBean choiceBeanLecture2 = new ChoiceBean(choiceLecture2, lecture2);
		ChoiceBean choiceBeanLecture3 = new ChoiceBean(choiceLecture3, lecture3);
		ChoiceBean choiceBeanLecture4 = new ChoiceBean(choiceLecture4, lecture4);
		ChoiceBean choiceBeanLecture5 = new ChoiceBean(choiceLecture5, lecture5);

		ChoiceBean choiceBeanLocationAndTime1 = new ChoiceBean(
				choiceLocationAndTime1, locationAndTime1);
		ChoiceBean choiceBeanLocationAndTime2 = new ChoiceBean(
				choiceLocationAndTime2, locationAndTime2);
		ChoiceBean choiceBeanLocationAndTime3 = new ChoiceBean(
				choiceLocationAndTime3, locationAndTime3);

		ChoiceBean choiceBeanCognition1 = new ChoiceBean(choiceCognition1,
				cognition1);
		ChoiceBean choiceBeanCognition2 = new ChoiceBean(choiceCognition2,
				cognition2);
		ChoiceBean choiceBeanCognition3 = new ChoiceBean(choiceCognition3,
				cognition3);
		ChoiceBean choiceBeanCognition4 = new ChoiceBean(choiceCognition4,
				cognition4);
		ChoiceBean choiceBeanCognition5 = new ChoiceBean(choiceCognition5,
				cognition5);
		ChoiceBean choiceBeanCognition6 = new ChoiceBean(choiceCognition6,
				cognition6);
		ChoiceBean choiceBeanCognition7 = new ChoiceBean(choiceCognition7,
				cognition7);

		ChoiceBean choiceBeanUseKnowledge1 = new ChoiceBean(
				choiceUseKnowledge1, useKnowledge1);
		ChoiceBean choiceBeanUseKnowledge2 = new ChoiceBean(
				choiceUseKnowledge2, useKnowledge2);
		ChoiceBean choiceBeanUseKnowledge3 = new ChoiceBean(
				choiceUseKnowledge3, useKnowledge3);
		ChoiceBean choiceBeanUseKnowledge4 = new ChoiceBean(
				choiceUseKnowledge4, useKnowledge4);

		SuggestionBean suggestionComment = new SuggestionBean(comment);

		TopicBean topicBeanLecture = new TopicBean(topicLecture);
		topicBeanLecture.getChoiceVector().add(choiceBeanLecture1);
		topicBeanLecture.getChoiceVector().add(choiceBeanLecture2);
		topicBeanLecture.getChoiceVector().add(choiceBeanLecture3);
		topicBeanLecture.getChoiceVector().add(choiceBeanLecture4);
		topicBeanLecture.getChoiceVector().add(choiceBeanLecture5);

		TopicBean topicBeanLocationAndTime = new TopicBean(topicLocationAndTime);
		topicBeanLocationAndTime.getChoiceVector().add(
				choiceBeanLocationAndTime1);
		topicBeanLocationAndTime.getChoiceVector().add(
				choiceBeanLocationAndTime2);
		topicBeanLocationAndTime.getChoiceVector().add(
				choiceBeanLocationAndTime3);

		TopicBean topicBeanCognition = new TopicBean(topicCognition);
		topicBeanCognition.getChoiceVector().add(choiceBeanCognition1);
		topicBeanCognition.getChoiceVector().add(choiceBeanCognition2);
		topicBeanCognition.getChoiceVector().add(choiceBeanCognition3);
		topicBeanCognition.getChoiceVector().add(choiceBeanCognition4);
		topicBeanCognition.getChoiceVector().add(choiceBeanCognition5);
		topicBeanCognition.getChoiceVector().add(choiceBeanCognition6);
		topicBeanCognition.getChoiceVector().add(choiceBeanCognition7);

		TopicBean topicBeanUseKnowledge = new TopicBean(topicUseKnowledge);
		topicBeanUseKnowledge.getChoiceVector().add(choiceBeanUseKnowledge1);
		topicBeanUseKnowledge.getChoiceVector().add(choiceBeanUseKnowledge2);
		topicBeanUseKnowledge.getChoiceVector().add(choiceBeanUseKnowledge3);
		topicBeanUseKnowledge.getChoiceVector().add(choiceBeanUseKnowledge4);

		TopicBean topicBeanComment = new TopicBean(topicComment);
		topicBeanComment.setSuggestion(suggestionComment);
		try {
			FillRegisterProfileManager fillRegisterMng = FillRegisterProfileManager
					.getInstance();
			// String evaluationName = "แบบประเมิน_" +
			// fillRegisterMng.searchRegisterByUsername(traineeBean.getLogin().getUsername());
			RegisterBean registerBean = fillRegisterMng.searchRegisterByUsername("unchalee");
			String evaluationName = "แบบประเมิน_"
					+ registerBean.getRegisterNo();

			EvaluationBean evaluation = new EvaluationBean(evaluationName);
			evaluation.getTopicVector().add(topicBeanLecture);
			evaluation.getTopicVector().add(topicBeanLocationAndTime);
			evaluation.getTopicVector().add(topicBeanCognition);
			evaluation.getTopicVector().add(topicBeanUseKnowledge);
			evaluation.getTopicVector().add(topicBeanComment);

			traineeBean.setEvaluation(evaluation);

			EvaluationManager evaluationMng = EvaluationManager.getInstance();

			// int traineeID =
			// fillRegisterMng.searchTraineeId(traineeBean.getLogin().getUsername());
			int traineeID = fillRegisterMng.searchTraineeId("unchalee");
			boolean addEvaluation = evaluationMng.addEvaluation(evaluation,
					traineeID);
			if (addEvaluation) {
				System.out.println("success");
				response.sendRedirect("ListDocumentServlet");
			} else {
				System.out.println("Fail");
				response.sendRedirect("Evaluation.jsp");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
