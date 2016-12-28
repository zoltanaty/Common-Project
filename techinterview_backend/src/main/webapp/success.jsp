<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="success.css">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Where to now</title>
	</head>

	<body>
		<div id="menu">
			<ul class="topnav" id="myTopnav">	
				<li><a href="http://localhost:8080/techinterview-backend/logout.do">Log out</a></li>
				<li><a href="http://localhost:8080/techinterview-backend/contact.jsp">Contact</a></li>
				<li><a href="http://localhost:8080/techinterview-backend/about.jsp">About</a></li>
				<li><a href="http://localhost:8080/techinterview-backend/index.jsp">Home</a></li>
			</ul>
		</div>
	
	<%
		String user = "";
		String privilege = "";

		if ((Boolean) session.getAttribute("ok") != null) {			
			if ((Boolean) session.getAttribute("ok")) {
				user = (String) session.getAttribute("user");
				privilege = (String) session.getAttribute("privilege");
	%>	
		<div id="main">
			<p id="login">Login successful</p><br><br>
			<p id="credentials">Welcome back </p>
			<p id="user"><%= user %></p><br>
			<p id="privilege">You are:</p>
	<% 			
				if(privilege.equals("admin")) { 
	%> 
			<em id="admin"><%= privilege%></em>
	<%
				} else {
	%>
			<em id="manager"><%= privilege%></em>
	<% 
				}
	%>
			<br><br>
	
	<%
				if(privilege.equals("admin")) {
	%>
			<br>
			<div id="form-buttons">
				<form class="buttons" method="GET" action="results.do">
					<input type="submit" value="Results">
				</form>
	
				<form class="buttons" method="GET" action="manage.do">
					<input type="submit" value="Manage site">
				</form>
				
	<%
				} else {
	%>
	
				<form class="buttons" method="GET" action="results.do">
				<input type="submit" value="Results">
				</form>
			</div>
	<%
				}
			} else {
	%>
			<em>Login failed</em>			
	<%
			}
		} else {
	%>
			<em>Error</em>	
	<%
		}
	%>
		</div>
	</body>
</html>