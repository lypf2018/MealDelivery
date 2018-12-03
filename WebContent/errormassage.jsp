<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error message</title>
</head>
<body>
<h1> ${message} !!! </h1>

	<a href="<%=request.getContextPath()%>/login.jsp">Login</a>
</body>
</html>