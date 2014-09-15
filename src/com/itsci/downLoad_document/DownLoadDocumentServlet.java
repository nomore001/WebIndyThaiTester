
package com.itsci.downLoad_document;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DownLoadDocumentServlet")
public class DownLoadDocumentServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DownLoadDocumentManager documentMng = DownLoadDocumentManager.getInstance();

	/**
	 * @roseuid 53C24272022B
	 * @J2EE_METHOD -- DownLoadDocumentServlet
	 */
	public DownLoadDocumentServlet() {

	}

	/**
	 * @throws javax.servlet.ServletException
	 * @throws java.io.IOException
	 * @roseuid 53C24272022C
	 * @J2EE_METHOD -- doGet Called by the server (via the service method) to
	 *              allow a servlet to handle a GET request. The servlet
	 *              container must write the headers before committing the
	 *              response, because in HTTP the headers must be sent before
	 *              the response body. The GET method should be safe and
	 *              idempotent. If the request is incorrectly formatted, doGet
	 *              returns an HTTP 'Bad Request' message.
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @throws javax.servlet.ServletException
	 * @throws java.io.IOException
	 * @roseuid 53C24272022F
	 * @J2EE_METHOD -- doPost Called by the server (via the service method) to
	 *              allow a servlet to handle a POST request. The HTTP POST
	 *              method allows the client to send data of unlimited length to
	 *              the Web server a single time and is useful when posting
	 *              information such as credit card numbers. If the HTTP POST
	 *              request is incorrectly formatted, doPost returns an HTTP
	 *              'Bad Request' message.
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");

		HttpSession session = request.getSession();
		Integer courseId = (Integer) session.getAttribute("courseID");

		DownLoadDocumentManager documentMng = DownLoadDocumentManager
				.getInstance();

		Vector<TrainingDocumentBean> trainingDoc = documentMng
				.listAllDocument("" + courseId);

		session.setAttribute("trainingDocumentBean", trainingDoc);

		Vector<TrainingDocumentBean> partToLoadFile = new Vector<TrainingDocumentBean>();
		partToLoadFile = documentMng.downloadTrainingDocument(trainingDoc);

		session.setAttribute("partToLoad", partToLoadFile);

		response.sendRedirect("UserList&downloadDocument.jsp");

	}

}
