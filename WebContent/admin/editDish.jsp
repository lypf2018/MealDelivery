<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="domain.bean.Dish"%>
<%@page import="domain.bean.Category"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Dish Page</title>
</head>
<body>
	<a href="<%=request.getContextPath()%>/logout.jsp">logout</a><br>
	<h1>Edit Dish</h1>
	<% Dish dish = (Dish)request.getAttribute("list"); %>
	<form method="post" action="<%=request.getContextPath()%>/DishMngController?type=editPic&id=<%=dish.getId() %>" enctype="multipart/form-data">
 		<label for="pic">Dish_Picture:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
 		<input type="file" name="pic"/>
 		<input type="submit" value="upload_picture"/><br>
 	</form>
 	<%
 		String img = dish.getPic() != null ? dish.getPic() : "";
 		String msgPic = request.getAttribute("msg") != null ? request.getAttribute("msg").toString() : "";
 		String filePath = request.getAttribute("filePath") != null ? request.getAttribute("filePath").toString() : dish.getPic();
 	%>
	<div>
		<table frame=void rules=none border='1'>
			<tr>
				<td><label>Original Picture:&nbsp;&nbsp;&nbsp;</label></td>
				<td><img src="<%=request.getContextPath()%>/<%=img %>" width="150"></td>
 			</tr>
 			<tr>
				<td></td>
				<td><label>${ msg }</label></td>
			</tr>
		</table>
	</div>
	
	<form method="post" action="<%=request.getContextPath()%>/DishMngController?type=edit" name="Edit_Dish">
		<input type="hidden" name="filePath" value="<%=filePath %>"><br/>
		<input type="hidden" name="dishid" id="dish_id" value="<%=dish.getId()%>">
		<table>
			<tr>
				<td><label for="name">Dish_Name: </label></td>
				<td><input type="text" name="dishname" id="dish_name" value="<%=dish.getName()%>"></td>
			</tr>
			<tr>
				<td><label for="des">Dish_Description: </label></td>
				<td><textarea cols="50" rows="10" name="des" id="dish_des"><%=dish.getDes() %></textarea></td>
			</tr>
			<tr>
				<td><label for="price">Dish_Price: </label></td>
				<td><input type="text" name="price" id="dish_price" value="<%=dish.getPrice()%>"></td>
			</tr>
			<tr>
				<td><label for="category">Dish_category:</label></td>
				<td><select id="dish_category" name="category">
					<%
					List<Category> list = (List<Category>)request.getAttribute("category");
					if(list != null && list.size() > 0){
						for(Category cate : list){
							if(cate.getId() == dish.getDCId()) {
							%>
							<option value="<%= cate.getId()%>" selected="selected"><%= cate.getId()%> - <%= cate.getName() %></option>
							<%
							} else {
								%>
								<option value="<%= cate.getId()%>"><%= cate.getId()%> - <%=cate.getName() %></option>
								<%
							}
						}	
					} 
					%>
				</select>
				</td>
			</tr>
		</table>
		<button name="submit" value="edit">Confirm Dish</button>
	</form>
</body>
</html>