package trip4fun;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.PrintWriter;

/**
 * Servlet implementation class WallServlet
 */
@WebServlet("/WallServlet")
public class WallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jspPage = "HomePage.jsp"; 
		HttpSession session = request.getSession(true);

		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
		out.println("Sono nella parte centrale Servlet");
	    
		session.setAttribute("provenienza", "WallServlet");
		//request.getRequestDispatcher( jspPage ).forward(request,response);
	}

}
