<%@page import="util.MySQLJDBC"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<meta charset="UTF-8">
<title>Administrator Login Page</title>
</head>
<body>
	<%
		out.print("Hello! Administrator!");
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
		mySQLJDBC.close();
	%>
	<br/>
	
	<form name="loginform" action="AdministratorLoginController" method="post" onsubmit="return loginValidate()" >
	<br>
	${message}<br>
	${successMessage}<br>
	
	
	Username: <input type="text" name="username" id="username"><br>
	Password: <input type="password" name="password" id="password"><br>
	<input type="submit" name="submit" value="login"><br>
	<a href="login.jsp">customer login</a>
	
	</form>

</body>
</html>