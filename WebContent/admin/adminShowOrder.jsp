<%@page import="domain.bean.Order"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Food Delivery</title>
<script type="text/javascript">
/*	function updateStatus(Stirng s){
		var xhttp;
		xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
		    	document.getElementById("txtHint").innerHTML = this.responseText;
		    }
		};
		xhttp.open("GET", "updateStatus.jsp?s="+str, true);
		xhttp.send();
	}*/
</script>
</head>
<h2>All orders information</h2>
<body>
<% ArrayList<Order> list = (ArrayList)request.getAttribute("list"); %>
	<table border='1' cellspacing='0' width='100%'>
  	<tr>
  		<th>Order Number</th>
  		<th>Customer ID</th>
  		<th>Bill</th>
  		<th>Time</th>
  		<th>Status</th>
  	</tr>
  	<% for(Order order : list){ %>
  			<tr>
  				<% String url = request.getContextPath() + "/admin/ShowOrder?id=" + order.getOrderID(); %>
  				<td><a href = <%=url %>><%= order.getOrderID() %></a></td>
  				<td><%= order.getCustomerID() %></td>
  				<td><%= order.getBill() %></td>
  				<td><%= order.getTime() %></td>
  				<td>
  					<%--= order.getStatus() --%>
  					 <%-- <input type = "text" value = <%= order.getStatus()%> name = "status"/>--%>
  					 <form action="<%=request.getContextPath()%>/admin/ShowOrder" name = "updateStatus" method = "post"> 
  					<input type = "hidden" name = "orderId" value = "<%=order.getOrderID() %>">
	  				<select name="status" onchange="">
							<option value=""><%= order.getStatus() %></option>
							<option value="undergoing">undergoing</option>
							<option value="completed">completed</option>
						</select>
	  					<input type = "submit" value = "update"/> 
  					</form>
  				</td>
  			</tr>
  		
  	<%} %>
  </table>
  <div>
  <a href = "<%=request.getContextPath()%>/admin/AdSelectDishController">Back</a>
  </div>
</body>
</html>