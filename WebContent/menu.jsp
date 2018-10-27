<%@ page import="java.util.*" %>
<%@ page import="domain.bean.*" %>
<%@ page import="domain.dao.*" %>
<%@page import="util.MySQLJDBC"%>
<%@page import="java.sql.Connection"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
  	
	<a href="<%=request.getContextPath()%>/ProfileController">Profile</a><br>
	<a href="<%=request.getContextPath()%>/CartController">Shopping Cart</a><br>
	<a href="<%=request.getContextPath()%>/ShowOrderController">Show Order</a>
	
	<% CategoryDao categoryDao = new CategoryDao(); %>
	<% List<Category> categories = categoryDao.selectCategory(); %>
	<% DishDao dishDao = new DishDao(); %>
	<% List<Dish> dishes = dishDao.selectDish(); %>
	
	<style>
		.container {
    		overflow-x: auto;
    		overflow-x: visible;
    		white-space: nowrap;
		}
	</style>
	
	<div class="container">
		<h2>Menu</h2>
		<% for(Category category : categories){ %>
			
  			<a data-toggle="pill" href="#<%= category.getName() %>" ><%= category.getName() %></br></a>		
  		<%} %>
	
		<div class="tab-content">
			<% for(Category category : categories){ %>
				
  				<tr>
  					<td><h3 id = <%= category.getName() %>><%= category.getName() %></h3></td>
  				</tr>
  				
  				<%for(Dish dish : dishes){%>
  					<%if(dish.getDCId() == category.getId()){%>
						<tr>
						<style>
						div.figure {
      						display:inline-block;
    					}

    					p {
      						text-align:center;
    					}
						</style>
						
						<div class="figure">
						<figure>
 							<p><img src="<%=request.getContextPath()%>/image/<%=dish.getPic() %>"
    							alt="<%=dish.getName()%>">
  							<figcaption><a href = "dishdetail.jsp"><%=dish.getName()%></a></figcaption>
						</figure>
						</div>
  						</tr>
  					<%} %>
  				<%} %>
  				<tr></br></tr>
			<%} %> 		
		</div>
	</div>
</body>
</html>
