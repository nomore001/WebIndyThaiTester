package viewEvaluation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import evaluation.*;
import fillRegisterProfile.RegisterBean;

/**
 * Servlet implementation class ViewEvaluationServlet
 */
@WebServlet("/ViewEvaluationServlet")
public class ViewEvaluationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewEvaluationServlet() {
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
			registerBean.setRegisterNo("QTP2");
			session.setAttribute("registerBean", registerBean);
		}
		
		String name = request.getParameter("traineeName");
		
		try{
			EvaluationManager evaluationMng = EvaluationManager.getInstance();
			
			EvaluationBean evaluationBean = evaluationMng.getEvaluation(registerBean, name);
			
			session.setAttribute("evaluationBean", evaluationBean);
			response.sendRedirect("viewEvaluation.jsp");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
