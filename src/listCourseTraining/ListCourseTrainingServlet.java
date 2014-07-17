package listCourseTraining;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import downLoadDocument.CourseTrainingBean;
import downLoadDocument.DownLoadDocumentManager;

/**
 * Servlet implementation class ListCourseTrainingServlet
 */
@WebServlet("/ListCourseTrainingServlet")
public class ListCourseTrainingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCourseTrainingServlet() {
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
		
		DownLoadDocumentManager downloadDocumentMng = new DownLoadDocumentManager();
		
		Vector<CourseTrainingBean> courseTrainingBean = downloadDocumentMng.listCourseTraining();
		
		HttpSession session = request.getSession();
		session.setAttribute("courseTrainingBean", courseTrainingBean);
		
		for(int i = 0;i<courseTrainingBean.size();i++){
			System.out.println(courseTrainingBean.elementAt(i).getCourseTrainingName() +" "+courseTrainingBean.elementAt(i).getCourseTrainingDuration());
		}
		
		
	}

}
