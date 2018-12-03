<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/logout.jsp">logout</a><br>
<a href="<%=request.getContextPath()%>/MenuController">menu</a><br>
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
    <th>-/+</th>
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
    <td>
	<form action="<%=request.getContextPath()%>/insertCartController" method="post">
	<input type="hidden" name="did" id="did" value = <%= dishes.get(i).getId() %>>
	<input type="hidden" name="quantity" id="quantity" value=1>
  	<input type="submit" name="submit" value="+" id="increase"><br>    
	</form>
	<form action="<%=request.getContextPath()%>/insertCartController" method="post">
	<input type="hidden" name="did" id="did" value = <%= dishes.get(i).getId() %>>
	<input type="hidden" name="quantity" id="quantity" value=-1>
  	<input type="submit" name="submit" value="-" id="decrease"><br>    
	</form>
	</td>
  </tr>
<% } %>

</table>
<a href="<%=request.getContextPath()%>/CheckOutController" id="checkout">Check Out</a><br>
</body>
</html>