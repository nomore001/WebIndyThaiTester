package calculateEvaluation;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import evaluation.EvaluationManager;
import fillRegisterProfile.FillRegisterProfileManager;
import fillRegisterProfile.RegisterBean;
import fillRegisterProfile.TraineeBean;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		HttpSession session = request.getSession();
		
		RegisterBean registerBean = (RegisterBean) session
				.getAttribute("registerBean");
		if (registerBean == null) {
			registerBean = new RegisterBean();
			session.setAttribute("registerBean", registerBean);
		}
		
		FillRegisterProfileManager fillRegisterMng = FillRegisterProfileManager
				.getInstance();
//		int registerID = fillRegisterMng.searchRegisterId(registerBean.getRegisterNo());
		int registerID = fillRegisterMng.searchRegisterId(registerBean.getRegisterNo());
		Vector<TraineeBean> traineeVector = fillRegisterMng.listTraineeByRegisterId(registerID);
		registerBean.setTraineeVector(traineeVector);
		
		int sumOfTrainee = fillRegisterMng.sumOfTrainee(registerBean);
		
		EvaluationManager evaluationMng = EvaluationManager.getInstance();
		
		double[] totalTopic = evaluationMng.calculateTotalAllEvaluation(registerBean, sumOfTrainee);

		System.out.println("จำนวนผู้เข้าร่วมอบรม " + sumOfTrainee);
		for(int i=0 ; i<totalTopic.length ; i++){
			System.out.println("หัวข้อที่ " + (i+1));
			System.out.println("\t" + totalTopic[i]);
		}
		System.out.println("ข้อเสนอแนะอื่น ๆ");
		System.out.println("\t" + evaluationMng.totalSuggestion(registerBean, sumOfTrainee));
	}

}
