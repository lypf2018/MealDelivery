<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>${name} this is the cart</h1>
<%@ page import="java.util.*" %>
<% List<Integer> dishes = (List) request.getAttribute("dishes"); %>
<% for ( int i = 0; i < dishes.size(); i++) { %>
	<% int d = dishes.get(i); %>

	<h2><%=d %></h2>
<% } %>


</body>
</html>