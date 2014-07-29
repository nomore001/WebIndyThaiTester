package deleteDocument;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import downLoadDocument.DownLoadDocumentManager;

/**
 * Servlet implementation class DeleteDocumentServlet
 */
@WebServlet("/DeleteDocumentServlet")
public class DeleteDocumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteDocumentServlet() {
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
		String documentID = request.getParameter("documentID");
		String documentPath = request.getParameter("documentPath");
		String documentName = request.getParameter("documentName");
		DownLoadDocumentManager documentMng = DownLoadDocumentManager
				.getInstance();
		
		documentMng.deleteDocument(documentID,documentPath,documentName);
		
		
		response.sendRedirect("listDocument.jsp");

	}

}
