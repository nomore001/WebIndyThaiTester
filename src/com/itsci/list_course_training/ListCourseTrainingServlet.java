package com.itsci.list_course_training;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itsci.downLoad_document.CourseTrainingBean;
import com.itsci.downLoad_document.DownLoadDocumentManager;
import com.itsci.downLoad_document.TrainingDocumentBean;

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

		DownLoadDocumentManager downloadDocumentMng = DownLoadDocumentManager
				.getInstance();

		Vector<CourseTrainingBean> courseTrainingBean = downloadDocumentMng
				.listCourseTraining();

		HttpSession session = request.getSession();
		try {
			session.setAttribute("courseTrainingBean", courseTrainingBean);

			if (request.getParameter("courseID") != null) {
				Vector<TrainingDocumentBean> list = downloadDocumentMng
						.listAllDocument(request.getParameter("courseID"));
				session.setAttribute("trainingDocumentList", list);
				String courseID = request.getParameter("courseID");
				session.setAttribute("courseIDSession", courseID);

			}

			response.sendRedirect("admin.jsp");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
