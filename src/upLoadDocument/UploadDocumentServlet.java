package upLoadDocument;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;





import downLoadDocument.DownLoadDocumentManager;

/**
 * Servlet implementation class UploadDocumentServlet
 */
@WebServlet("/UploadDocumentServlet")
public class UploadDocumentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadDocumentServlet() {
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
		String courseName=null;
		String directory="D:\\work\\3.2556\\AutomateTest\\gitWorkspace\\WebIndyThaiTester\\WebContent\\file";
		boolean resultaddDoc = false;
		DownLoadDocumentManager documentMng = DownLoadDocumentManager
				.getInstance();
	
		
		
		if (ServletFileUpload.isMultipartContent(request)) {
			try {
				List<FileItem> multiparts = new ServletFileUpload(
						new DiskFileItemFactory()).parseRequest(request);

				
				for (FileItem item : multiparts) {
					
					if (item.isFormField()) {
						if(item.getFieldName().equals("courseToUpload")){
							 courseName = new String (item.getString().getBytes ("iso-8859-1"), "UTF-8");
							 if(courseName.equals("qtp")){
								 directory += "\\QTP";
								
							 }else if(courseName.equals("selenium")){
								 directory += "\\Selenium";
								
							 }
						}
						
					} else{
						String name = new File(item.getName()).getName();
						item.write(new File(directory + File.separator
								+ name));			
						
//					resultaddDoc = 	documentMng.upLoadTrainingDocument(name, directory,courseName);
					}
					}
				System.out.println(resultaddDoc);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			

		}

	}

}
