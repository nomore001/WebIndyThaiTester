package com.itsci.printregisterProfile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.pdfbox.exceptions.COSVisitorException;
import org.pdfbox.pdmodel.PDDocument;
import org.pdfbox.pdmodel.PDPage;
import org.pdfbox.pdmodel.edit.PDPageContentStream;
import org.pdfbox.pdmodel.font.PDFont;
import org.pdfbox.pdmodel.font.PDTrueTypeFont;
import org.pdfbox.pdmodel.font.PDType1Font;

import com.itextpdf.text.pdf.codec.Base64.OutputStream;

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
		response.setContentType("text/html");

	
		
		
		
		
		
		
		
		
		
		
		
		
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
