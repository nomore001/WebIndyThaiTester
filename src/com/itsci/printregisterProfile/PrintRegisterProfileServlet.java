package com.itsci.printregisterProfile;



import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jasperreports.engine.JasperRunManager;

import com.itsci.fill_register_profile.TraineeBean;
import com.itsci.utility.MySQLConnectionPool;
import com.itsci.utility.ServletUtils;






/**
 * Servlet implementation class PrintRegisterProfile
 */
@WebServlet("/PrintRegisterProfileServlet")
public class PrintRegisterProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PrintRegisterProfileServlet() {
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
		
		HttpSession session = request.getSession();
		TraineeBean trainee = (TraineeBean) session.getAttribute("traineeBean");
		String username = trainee.getLogin().getUsername();
		
		System.out.println(username);

		// TODO Auto-generated method stub
		ServletOutputStream servletOutputStream = response.getOutputStream();
		byte[] bytes = null;
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			// //โหลด Driver
			Class.forName("com.mysql.jdbc.Driver");
			// ระบุฐานข้อมูลที่ใช้ในการสร้างรายงาน
			Connection conn = MySQLConnectionPool.getConnection();
			// ทำการส่งค่าพารามิเตอร์ไปยัง iReport
			param.put("username", username);
			
			// กำหนด path ของไฟล์ i-report
			System.out.print(ServletUtils.getReportFile(getServletContext(),
					"traineeProfile.jasper"));
			bytes = JasperRunManager.runReportToPdf(ServletUtils.getReportFile(
					getServletContext(), "traineeProfile.jasper"), param, conn);

			// กำหนดชนิดของไฟล์ที่ใช้แสดงผล
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			servletOutputStream.write(bytes, 0, bytes.length);
			servletOutputStream.flush();
			servletOutputStream.close();
		} catch (Exception e) {
			StringWriter stringWriter = new StringWriter();
			PrintWriter printWriter = new PrintWriter(stringWriter);
			e.printStackTrace(printWriter);
			response.setContentType("text/plain");
			response.getOutputStream().print(stringWriter.toString());
		}

	
		
		
		
		
		
		
		
		
		
		
		
		
//		String filePath = "/assets/img/logo.png";
//		File downloadFile = new File(filePath);
//		FileInputStream inStream = new FileInputStream(downloadFile);
//
//		// if you want to use a relative path to context root:
//		String relativePath = getServletContext().getRealPath("");
//		System.out.println("relativePath = " + relativePath);
//		// obtains ServletContext
//		ServletContext context = getServletContext();
//
//		// gets MIME type of the file
//		String mimeType = context.getMimeType(filePath);
//		if (mimeType == null) {
//			// set to binary type if MIME mapping not found
//			mimeType = "application/octet-stream";
//		}
//		System.out.println("MIME type: " + mimeType);
//
//		// modifies response
//		response.setContentType(mimeType);
//		response.setContentLength((int) downloadFile.length());
//
//		// forces download
//		String headerKey = "Content-Disposition";
//		String headerValue = String.format("attachment; filename=\"%s\"",
//				downloadFile.getName());
//		response.setHeader(headerKey, headerValue);
//
//		// obtains response's output stream
//		ServletOutputStream outStream = response.getOutputStream();
//
//		byte[] buffer = new byte[4096];
//		int bytesRead = -1;
//
//		while ((bytesRead = inStream.read(buffer)) != -1) {
//			outStream.write(buffer, 0, bytesRead);
//		}
//
//		inStream.close();
//		outStream.close();
	}

}
