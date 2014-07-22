package listDocument;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import downLoadDocument.DownLoadDocumentManager;
import downLoadDocument.TrainingDocumentBean;

/**
 * Servlet implementation class ListDocumentServlet
 */
@WebServlet("/ListDocumentServlet")
public class ListDocumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListDocumentServlet() {
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

		DownLoadDocumentManager documentMng = DownLoadDocumentManager
				.getInstance();

		Vector<TrainingDocumentBean> trainingDoc = documentMng
				.listAllDocument();
		HttpSession session = request.getSession();
		session.setAttribute("trainingDocumentBean", trainingDoc);

		for (int i = 0; i < trainingDoc.size(); i++) {
			System.out.println(trainingDoc.elementAt(i).getDocumentName() + " "
					+ trainingDoc.elementAt(i).getDocumentPath());
		}
	}

}
