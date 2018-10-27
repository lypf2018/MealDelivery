<%@page import="domain.bean.Order"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food Delivery</title>
</head>
<h2>All orders information</h2>
<body>
<% ArrayList<Order> list = (ArrayList)request.getAttribute("list"); %>
	<table border='1' cellspacing='0' width='60%'>
  	<tr>
  		<th>Order Number</th>
  		<th>Customer ID</th>
  		<th>Bill</th>
  		<th>Status</th>
  		<th>Time</th>
  	</tr>
  	<% for(Order order : list){ %>
  			<tr>
  				<td><%= order.getOrderID() %></td>
  				<td><%= order.getCustomerID() %></td>
  				<td><%= order.getBill() %></td>
  				<td><%= order.getStatus() %></td>
  				<td>
  					<form>
  					<input type = "text" value = <%= order.getTime() %> name = "status"/>
  					<input type = "submit" value = "update"/>
  					</form>
  				</td>
  			</tr>
  		
  	<%} %>
  </table>
</body>
</html>