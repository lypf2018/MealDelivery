<%@page import="util.MySQLJDBC"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<%
		out.print("Hello!");
	%>

	<%=new java.util.Date()%>

	<%
		MySQLJDBC mySQLJDBC = new MySQLJDBC();
		Connection conn = mySQLJDBC.getConnection();
		if(conn == null) {
			out.print("failed");
		} else {
			out.print("succeeded");
		}
	%>
	<a href="administratorlogin.jsp">Administrator Login</a>
	<br/>
	
	<form name="loginform" action="LoginController" method="post" onsubmit="return loginValidate()" >
	<br>
	${message}<br>
	${successMessage}<br>
	
	
	Email: <input type="text" name="email" id="email"><br>
	Password: <input type="password" name="password" id="password"><br>
	<input type="submit" name="submit" value="login"><br>
	<a href="register.jsp">Registration</a>
	
	</form>

</body>
</html>