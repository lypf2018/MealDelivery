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

	<a href="<%=request.getContextPath()%>/ProfileController">profile</a><br>
	<a href="<%=request.getContextPath()%>/CartController">shopping cart</a>
	
	<style>
		.container {
    		overflow-x: auto;
    		overflow-x: visible;
    		white-space: nowrap;
		}
	</style>
	
	<div class="container">
		<h2>Menu</h2>
		<% List<Category> categoryList = (List<Category>)request.getAttribute("categoryList"); %>
		<% for(Category category : categoryList){ %>
			
  			<a data-toggle="pill" href="#<%= category.getName() %>" ><%= category.getName() %></br></a>		
  		<%} %>
		
		<div class="tab-content">
			<% for(Category category : categoryList){ %>
				
  				<tr>
  					<td><h3 id = "<%= category.getName() %>"><%= category.getName() %></h3></td>
  				</tr>
  				
  				<%List<Dish> dishList = (List<Dish>)request.getAttribute("dishList");%>
  				<%for(Dish dish : dishList){%>
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
  							<figcaption><a href = "<%=request.getContextPath()%>/DishDetailController?id=<%=dish.getId()%>" id = <%=dish.getId()%> ><%=dish.getName()%></a></figcaption>
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
