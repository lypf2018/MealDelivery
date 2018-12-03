<%@page import="domain.bean.Order"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Order</title>
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
<% ArrayList<Order> list = (ArrayList<Order>) request.getAttribute("list"); 
   int a =1;
%>

<table>
  <tr>
    <th>No.</th>
    <th>Order Number</th>
    <th>Total payment</th>
    <th>Order Time</th>
    <th>Order Status</th>
  </tr>
  <% for(Order order : list){ %>
   <tr>
    <th><%= a %></th>
    <% a=a+1; %>
    <th><a href="<%=request.getContextPath()%>/ViewOrderController?orderid=<%= order.getOrderID()%>" ><%= order.getOrderID() %></a></th>
    <th><%= order.getBill() %></th>
    <th><%= order.getTime() %></th>
    <th><%= order.getStatus() %></th>
  </tr>
  <%} %>
  
</table>
<br/>
<form action="<%=request.getContextPath()%>/MenuController" method="post">
<INPUT TYPE="submit" VALUE="return">
</form>
</body>
</html>