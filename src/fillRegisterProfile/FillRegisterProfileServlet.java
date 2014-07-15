package fillRegisterProfile;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FillRegisterProfileServlet")
public class FillRegisterProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FillRegisterProfileServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		FillRegisterProfileManager fillRegisterMng = new FillRegisterProfileManager();
		//session.setAttribute("productList", listProductMng.listProduct());
		//response.sendRedirect("viewproduct.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
