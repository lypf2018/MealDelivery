<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Login Confirm Page</title>
</head>
<body>
	<h1 id="msg"> ${msg}</h1>
	<br/>
	<a href="<%=request.getContextPath()%>/DishMngController?type=menu">Back to dish list</a>
	
</body>
</html>