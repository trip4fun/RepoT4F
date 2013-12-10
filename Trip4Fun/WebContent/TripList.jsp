<%@page import="trip4fun.BeanSessione"
        import="trip4fun.Trip"
        import="java.util.ArrayList"
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
<table  border="0" bgcolor="#ffa500" width="100%">
	<% BeanSessione app = (BeanSessione)session.getAttribute("miaSessione");
	   ArrayList<Trip> tripList = app.getTripList();
	   for(int i=1; i<=tripList.size();i++){ %>
	<tr>
		<td Height="100%" width="100%"><a href="HomePage.jsp?Trip=<%out.println(tripList.get(i-1).getIdDestinazione());%>"><% out.println(tripList.get(i-1).getDestinazione()); out.println(tripList.get(i-1).getCheckIn());out.println(tripList.get(i-1).getCheckOut());  %></a></td>
	</tr>
	<%} %>
</table>
</body>
</html>