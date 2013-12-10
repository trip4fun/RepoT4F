package trip4fun;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		
		String jspPage = ""; //conterrà la pagina su cui re-indirizzare la verifica
		boolean login = false;
		//ricavo i parametri inseriti dall'utente
		String userName = request.getParameter("Email");
		String pwd = request.getParameter("password");
		
		HttpSession session = request.getSession(true);
		BeanSessione miaSessione = new BeanSessione();
		//System.out.println(userName);
		//System.out.println(pwd);
		//System.out.println("SELECT * from test.user where username = '"+userName+"' and password = '"+pwd+"'");
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
        rs = stmt.executeQuery("SELECT * from t4f.utenti where Email = '"+userName+"' and password = '"+pwd+"'");
        rs.next();

        if (rs.getRow()==1) {
        	login = true;
        	miaSessione.setAutentificato(true);
        	//miaSessione.setUserName(rs.getString("userName"));
        	miaSessione.setNome(rs.getString("nome"));
        	miaSessione.setCognome(rs.getString("cognome"));
        	//miaSessione.setIdUser(rs.getInt("idUser"));
        	
        	session.setAttribute("miaSessione", miaSessione);
        	
        	jspPage ="index.jsp";
        }
        else jspPage = "ErrorLogin.jsp";
        
        /*if(login) {
        	ArrayList<Trip> tripList = new ArrayList<Trip> ();
        	
        	rs = stmt.executeQuery("SELECT * from t4f.trip a inner join test.destinazione b on a.idDestinazione = b.idDestinazione where a.idUser = '"+miaSessione.getIdUser()+"'");
            //rs.next();
        	while(rs.next()){
        		Trip iterTrip = new Trip();
        		//iterTrip.setDestinazione(rs.getString("Nazione")+" - "+rs.getString("Citta"));
        		iterTrip.setCheckIn(rs.getDate("DataInizio"));
        		iterTrip.setCheckOut(rs.getDate("DataFine"));
        		iterTrip.setIdDestinazione(rs.getInt("idDestinazione_fk"));
        		tripList.add(iterTrip);
        	}
        	miaSessione.setTripList(tripList);
        	session.setAttribute("miaSessione", miaSessione);
        }*/
        	
        
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
