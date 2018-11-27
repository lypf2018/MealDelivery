<%@page import="domain.bean.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% String orderId = (String)request.getAttribute("id");
   Order order = (Order)request.getAttribute("order");
   LinkedList<Dish> dishList = order.getDish();
%>

<h3>Order Number: <%=order.getOrderID() %></h3>
<div>
	<table border='1' cellspacing='0' width='100%'>
	  	<tr>
	  		<th>Dish ID</th>
	  		<th>Dish Name</th>
	  		<th>Price</th>
	  		<th>Amount</th>
	  	</tr>
	  	<% for(Dish dish : dishList){ %>
	  		<tr>
		  		<td><%= dish.getId() %></td>
		  		<td><%= dish.getName() %></td>
		  		<td><%= dish.getPrice() %></td>
		  		<td><%= dish.getDish_amount() %></td>
		  	</tr>
	  	<%} %>
  	</table>
</div>
<br>
<div>

<%-- 	
	<form action="" name = "updateStatus" method = "get">
		status: --%>
		<%--request.setAttribute("aaa",orderId); --%>
<%-- 		<select name="status">
		<%String status = "undergoing";
		  if(order.getStatus().equals("0"))
			  status = "undergoing";
		  else status = "completed";%>
			<option value=""><%= status %></option>
		    <option value="undergoing">undergoing</option>
		    <option value="completed">completed</option>
	  </select>
	  <input type="submit" value = "Submit">
	</form> 
	--%>
</div> 
<br>
<div>
<a href="<%=request.getContextPath()%>/admin/ShowOrder?id=all ">Back</a>
</div>

</body>
</html>