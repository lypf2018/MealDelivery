<%@page import="domain.bean.OrderItem"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Detail</title>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>



</head>
<body>
<a href="<%=request.getContextPath()%>/logout.jsp">logout</a><br>
<% ArrayList<OrderItem> list = (ArrayList<OrderItem>) request.getAttribute("list"); 
   int a =1;
%>

<table>
  <tr>
    <th>No.</th>
    <th>Dish Name</th>
    <th>Description</th>
    <th>Picture</th>
    <th>Amount</th>
    <th>Price</th>
    <th>Total</th>
  </tr>
  <% for(OrderItem order : list){ %>
   <tr>
    <th><%= a %></th>
    <% a=a+1; %>
    <th><%= order.getName()%></th>
    <th><%= order.getDesc() %></th>
    <th><img src="<%=request.getContextPath()%>/<%=order.getImage() %>"/></th>
    <th><%= order.getQuantity() %></th>
    <th><%= order.getPrice() %></th>
    <th><%= order.getTotal() %></th>
  </tr>
  <%} %>
  
</table>

<br />
<form action="<%=request.getContextPath()%>/ViewOrderController" method="post">
<INPUT TYPE="submit" VALUE="return">
</form>




</body>
</html>