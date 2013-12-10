<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<title>Benvenuti su TRIP4FUN!</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%@ include file="css/T4F.css" %>"/>
</head>
<body>
<table border="0">
	<tr><td width="100%" Height="100%"><jsp:include page="Header.jsp" flush="true"></jsp:include></td></tr>
	<tr><td width="100%">
		<table border="0" cellspacing="0">
		<tr>
		<td width="100%"  Height="100%">
			<table  border="0">
				<tr>
					<td width="80%" Height="100%"><jsp:include page="UserImages.jsp" flush="true"></jsp:include></td>
					<td width="20%" Height="100%"><jsp:include page="NewUserEasy.jsp" flush="true"></jsp:include></td>
				</tr>
				<tr>
					<td width="80%"><jsp:include page="Statistics.jsp" flush="true"></jsp:include></td>
					<td width="20%">Simulazione</td>
				</tr>
			</table>
		</td>
		
		</tr>
		</table>
	</td></tr>
</table>
</body>
</html>