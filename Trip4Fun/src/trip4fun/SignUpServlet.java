package trip4fun;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String jspPage = "ErrorSignUp.jsp"; //conterrà la pagina su cui re-indirizzare la verifica
		
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String userName = request.getParameter("mail");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
//		String comboGiorno = request.getParameter("ComboGiorno");
//		String comboMese = request.getParameter("ComboMese");
//		String comboAnno = request.getParameter("ComboAnno");
		String radioSesso = request.getParameter("radioSesso");
		
//		String dataNascita = comboAnno+"-"+comboMese+"-"+comboGiorno;
		
		String dataNascita = request.getParameter("dataNascita");
		
		java.text.SimpleDateFormat sdfSrc = new java.text.SimpleDateFormat("dd/MM/yyyy");
		java.text.SimpleDateFormat sdfDst = new java.text.SimpleDateFormat("yyyy-MM-dd");
		try
		{
			dataNascita=sdfDst.format(sdfSrc.parse(dataNascita));

		}
		catch(Exception ex)
		{}
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
        Connection conn =
            DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test?" + "user=root&password=trip4fun"
            );
        Statement stmt;
        PreparedStatement pstmt;
        ResultSet rs;
   
        stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO test.user (username, password, nome, cognome, dataNascita, sesso) VALUES('"+userName+"','"+password1+"','"+nome+"','"+cognome+"','"+dataNascita+"','"+radioSesso+"')");
        
        jspPage = "SignUp.jsp";
        
        stmt.close(); // rilascio le risorse
        conn.close(); // termino la connessione
		}
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
		request.getRequestDispatcher( jspPage ).forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
