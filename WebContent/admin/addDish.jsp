<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="domain.bean.Category"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Dish</h1>
 	

	<form method="post" action="<%=request.getContextPath()%>/admin/AdAddDishController" name="Add_Dish">
		<table frame=void rules=none border='1'>
			<tr>
				<td><label for="name">Dish_Name: </label></td>
				<td><input type="text" name="dishname" id="dish_name" value=""><br/></td>
			</tr>
			<tr>
				<td><label for="des">Dish_Description: </label></td>
				<td><textarea cols="50" rows="10" name="des" id="dish_des">please input dish description...</textarea><br/></td>
			</tr>
			<tr>
				<td><label for="pic">Dish_Picture:</label></td>
 				<td><input type="text" name="picture"/></td>
			</tr>
			<tr>
				<td><label for="price">Dish_Price: </label></td>
				<td><input type="text" name="price" id="dish_price" value=""><br/></td>
			</tr>
			<tr>
				<td><label for="category">Dish_category: </label>
				<td><select id="dish_category" name="category">
					<%
					List<Category> list = (List<Category>)request.getAttribute("category");
					if(list != null && list.size() > 0){
						for(Category cate : list){
							%>
							<option value="<%= cate.getId()%>"><%= cate.getId()%> - <%=cate.getName() %></option>
							<%
						}	
					} 
					%>
				</select>
			</td>
		</table>
		<button>Confirm Dish</button>
	</form>
 	
</body>
</html>