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
<%@ page import="domain.bean.*" %>
<% List<CartItem> dishes = (List) request.getAttribute("dishes"); %>
<table border="1">
  <tr>
    <th>Name</th>
    <th>Category</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Total</th>
  </tr>

<% for ( int i = 0; i < dishes.size(); i++) { %>
	<% int quantity = dishes.get(i).getQuantity(); %>
	<% String dishName = dishes.get(i).getName(); %>
	<% String CatName = dishes.get(i).getCategoryName(); %>
	<% double price = dishes.get(i).getPrice(); %>
	<% double totalPrice = quantity * price; %>
  <tr>
    <td><%=dishName %></td>
    <td><%=CatName %></td>
    <td>$<%=price %></td>
    <td><%=quantity %></td>
    <td>$<%=totalPrice %></td>
  </tr>
<% } %>

</table>
</body>
</html>