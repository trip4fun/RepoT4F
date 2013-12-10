<%@page import="trip4fun.BeanSessione"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table width="100%" border="0" bgcolor="#ffa500">
<tr>
	<td width="80%"><h1><A HREF="./Index.jsp">Trip4Fun.com</A></h1></td>
	<td width="20%">
		<% BeanSessione app = (BeanSessione)session.getAttribute("miaSessione"); 
		if (app == null || !app.isAutentificato()){%>
		<form method="GET" action="LoginServlet">
		<table>
 			<tr>
 				<td><input type="text" name="username" placeholder="e-mail o username" size="15" /><br>
 				<input type="password" name="password" placeholder="password" size="15" />
 			</td>
 			<td><div align="center"><input type="submit" value="Login" /></div></td>
 			
 		
  		</table>
  		</form>
  		<% } else {%>
  		<form method="POST" action="LogoutServlet">
  		<table border="0" width="100%">
 			<tr>
 				<td><h2><% out.println(app.getNome()+" "+app.getCognome());%></h2></td>
 			<td><div align="center"><input type="submit" value="Logout" /></div></td>
 			
 		
  		</table>
  		</form>
  		<% } %>
</td>
	
</tr>
</table>
</body>
</html>