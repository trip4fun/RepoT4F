<%@page import="trip4fun.BeanSessione"
import="java.sql.Connection"
import="java.sql.DriverManager"
import="java.sql.Statement"
import="java.sql.PreparedStatement"
import="java.sql.ResultSet"
import="java.sql.SQLException"

%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>

		<%-- <form method="POST" action="WallServlet" name="form"><input type="hidden" name="loadPage" /></form>
		<script type="text/javascript">
		function loadPage() {
			document.form.loadPage.value="loadPage";
			document.form.submit();
		}
		<% String redirect = (String)session.getAttribute("provenienza");
		if(redirect == null || !((String)session.getAttribute("provenienza")).equals("WallServlet")){%>
		loadPage();
		<% }%>
		</script> --%>
		<% String trip = request.getParameter("Trip");
		BeanSessione app = (BeanSessione)session.getAttribute("miaSessione");
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
	        rs = stmt.executeQuery("SELECT * FROM test.destinazione where idDestinazione = "+trip);
	        if(rs.next()) %> <h1>SEI NELLA BACHECA DI 
	        <%out.println(rs.getString("Citta")+" - "+rs.getString("Nazione"));%></h1>
	        <% rs = stmt.executeQuery("SELECT * from test.bacheca where idDestinazione = "+trip+" order by date desc");
	        while(rs.next()){
			%>		
			<tr><td width="100%" Height="100%"><div><hr><%out.println(rs.getString("TextMessage")); %></div></td></tr>
			<%}
			} catch(SQLException e){}%>
</table>

</body>
</html>