package trip4fun;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.text.SimpleDateFormat;

import java.sql.*;

/**
 * Servlet implementation class NewTripServlet
 */
@WebServlet("/NewTripServlet")
public class NewTripServlet extends HttpServlet {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String jspPage = "HomePage.jsp"; //conterrà la pagina su cui re-indirizzare la verifica
		
		//ricavo i parametri inseriti dall'utente
		
		String destinazione = request.getParameter("destinazione");
		int idDestinazione;
		HttpSession session = request.getSession(true);
		BeanSessione miaSessione = new BeanSessione();
		
//		String comboGiornoA = request.getParameter("ComboGiornoA");
//		String comboMeseA = request.getParameter("ComboMeseA");
//		String comboAnnoA = request.getParameter("ComboAnnoA");
		
	//	String comboGiornoR = request.getParameter("ComboGiornoR");
//		String comboMeseR = request.getParameter("ComboMeseR");
//		String comboAnnoR = request.getParameter("ComboAnnoR");
//		
		miaSessione = (BeanSessione)session.getAttribute("miaSessione");
		
//		String checkIn1 = comboAnnoA+"-"+comboMeseA+"-"+comboGiornoA;
//		String checkOut1 = comboAnnoR+"-"+comboMeseR+"-"+comboGiornoR;
		String checkIn = request.getParameter("dataCheckin");
		String checkOut = request.getParameter("dataCheckout");
		
		java.text.SimpleDateFormat sdfSrc = new java.text.SimpleDateFormat("dd/MM/yyyy");
		java.text.SimpleDateFormat sdfDst = new java.text.SimpleDateFormat("yyyy-MM-dd");
		try
		{
			checkIn=sdfDst.format(sdfSrc.parse(checkIn));
			checkOut=sdfDst.format(sdfSrc.parse(checkOut));
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
    //    PreparedStatement pstmt;
        ResultSet rs;
        

        stmt = conn.createStatement();
        rs = stmt.executeQuery("SELECT * FROM test.destinazione where citta = '"+destinazione+"'");
        rs.next();

        if (rs.getRow()==1) {
        	idDestinazione = rs.getInt("idDestinazione");
        }
        else 
        	{ 
        		stmt.executeUpdate("INSERT INTO test.destinazione (citta) VALUES('"+destinazione+"')");
        		rs = stmt.executeQuery("SELECT * FROM test.destinazione where citta = '"+destinazione+"'");
        		rs.next();
        		idDestinazione = rs.getInt("idDestinazione");
        		//stmt.executeUpdate("INSERT INTO test.bacheca (idDestinazione, date) VALUES("+idDestinazione+"),CURDATE()");
        	}
        stmt.executeUpdate("INSERT INTO test.trip (idUser,idDestinazione,checkIn,checkOut) VALUES("+miaSessione.getIdUser()+","+idDestinazione+",'"+checkIn+"','"+checkOut+"')");
       
        
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

}
