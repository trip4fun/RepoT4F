<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="Javascript/calendar.js"></script>
<title>Insert title here</title>
</head>
<body>
<table border="0" bgcolor="#ffa500">
<tr >
<td width="100%" Height="10%"><h2>Non hai mai trippato viaggi?!</h2><h1>Registrati!</h1></td>

</tr>
<tr>
<td  Height="90%">
<form method="GET" action="SignUpServlet">
		<table>
 			<tr>
 				<td><input type="text" name="nome" placeholder="nome" size="20" /><br>
 				<input type="text" name="cognome" placeholder="cognome" size="20" /><br>
 				<input type="text" name="mail" placeholder="e-mail" size="20" /><br>
 				<input type="password" name="password1" placeholder="password" size="20" /><br>
 				<input type="password" name="password2" placeholder="re-inserisci password" size="20" /><br>
 				
 				<input type="text" name="dataNascita" id="dataNascita" placeholder="data nascita" size="10" />
 				<img src="img/CalendarImg/select.gif" alt="seleziona la data" onclick="Calendar.show(document.getElementById('dataNascita'), '%d/%m/%Y', false)" style="cursor:pointer;" /><br>
 			 	<!-- <select name="ComboGiorno" > 
 					<option value="gg">gg</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					<option value="13">13</option>
					<option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>
					<option value="21">21</option>
					<option value="22">22</option>
					<option value="23">23</option>
					<option value="24">24</option>
					<option value="25">25</option>
					<option value="26">26</option>
					<option value="27">27</option>
					<option value="28">28</option>
					<option value="29">29</option>
					<option value="30">30</option>
					<option value="31">31</option>
					
				</select> -->
				<!-- <select name="ComboMese" >
 					<option value="mm">mm</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
					
				</select>
				<select name="ComboAnno" >
 					<option value="aaaa">aaaa</option>
					<option value="1980">1980</option>
					<option value="1981">1981</option>
					<option value="1982">1982</option>
					<option value="1983">1983</option>
					<option value="1984">1984</option>
				</select> -->
				
				<input type="radio" name="radioSesso" value="M">uomo
				<input type="radio" name="radioSesso" value="F">donna<br>
				<input type="submit" value="Registrati" />
 			</td>
  		</table>
  		
</form>
</td>
</tr>
</table>
</body>
</html>