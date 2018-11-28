<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>check out</title>
</head>
<body>
<h1>this is the check out</h1><br>
<a href="<%=request.getContextPath()%>/CartController">shopping cart</a>
<%@ page import="java.util.*" %>
<%@ page import="domain.bean.*" %>
<% List<CartItem> dishes = (List) request.getAttribute("dishes"); %>
<% double totalDue = 0; %>
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
	<% totalDue += totalPrice; %>
  <tr>
    <td><%=dishName %></td>
    <td><%=CatName %></td>
    <td>$<%=price %></td>
    <td><%=quantity %></td>
    <td>$<%=totalPrice %></td>
  </tr>
<% } %>
</table>
Total Due: $<%=totalDue %>
<form action="<%=request.getContextPath()%>/PayController" method="post">
	<input type="hidden" name="cid" id="cid" value= <%= request.getAttribute("cid")%>>
	<input type="hidden" name="bill" id="bill" value= <%= totalDue%>>
  	<input type="submit" name="submit" value="Pay">
</form>
</body>
</html>