<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BENVENUTO SU TRIP4FUN!</title>
</head>
<body>
<table width="100%" border="0" >
	<tr><td width="100%" Height="20%"><jsp:include page="Header.jsp" flush="true"></jsp:include></td></tr>
	<tr><td width="100%" Height="80%">
		<table border="0">
		<tr>
		<td width="20%" Height="100%">
			<table>
				<tr><td><jsp:include page="NewTrip.jsp" flush="true"></jsp:include></td></tr>
				<tr><td><jsp:include page="TripList.jsp" flush="true"></jsp:include></td></tr>
			</table>
		</td>
		<td width="80%" Height="100%">
			<table>
				<tr><td width="100%" Height="100%"><jsp:include page="CentralHome.jsp" flush="true"></jsp:include></td></tr>
			</table>
		</td>
		</tr>
		</table>
	</td>	
	</tr>
</table>
</body>
</html>