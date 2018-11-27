<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="domain.bean.Dish"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Administrator Dish Manage Page</title>
<script type="text/javascript">
function del() {
	var msg = "Are you sure to delete this dish？\n\nPlease Confirm！";
	if (confirm(msg)==true) { return true; }
	else { return false; }
}
</script>
<style>  
        div{  
            float: left;  
        }  
    </style>  
</head>
<body>
<div style="height:80px; width:100%;" >
	<h1 align="center">Dish Information</h1>
</div>
<div style="padding-right:50px;">
	<div style="height:400px; width:10%; padding-top:6px; text-align:center;">
		<a href="<%=request.getContextPath()%>/DishMngController?type=add">add dish</a><br/><br/><br/>
		<a href="<%=request.getContextPath()%>/admin/showOrder">show order</a>
	</div>
	<div style="height:900px; width:87%; text-align:center;">
		<table border='1' cellspacing='0' width="100%">
			<tr>
				<th><a href="<%=request.getContextPath()%>/DishMngController?type=sortByID">ID</a></th>
				<th><a href="<%=request.getContextPath()%>/DishMngController?type=sortByName">Dish_Name</a></th>
				<th>Dish_Description</th>
				<th>Dish_Picture</th>
				<th><a href="<%=request.getContextPath()%>/DishMngController?type=sortByPrice">Dish_Price</a></th>
				<th><a href="<%=request.getContextPath()%>/DishMngController?type=sortByCateory">Dish_Category</a></th>
				<th>Edit_Dish</th>
				<th>Delete_Dish</th>
			</tr>
			<tr>
			<%
				List<Dish> list = (List<Dish>)request.getAttribute("list");
				if(list != null && list.size() > 0){
					for(Dish dish : list){
						%>
						<tr id="dishID">
							<td width="10%"><%= dish.getId() %></td>
							<td width="16%"><%= dish.getName() %></td>
							<td width="14%"><%= dish.getDes() %></td>
							<td><img alt="no-image" src="<%=request.getContextPath()%>/<%=dish.getPic() %>" width="150"></td>
							<td width="8%"><%= dish.getPrice() %></td>
							<td width="10%"><%= dish.getDCId() %></td>
							<td width="12%">
								<a href="<%=request.getContextPath()%>/DishMngController?type=edit&id=<%=dish.getId()%>">edit</a>
							</td>
							<td width="12%">
								<a id="<%= dish.getId() %>" href="<%=request.getContextPath()%>/DishMngController?type=delete&id=<%=dish.getId()%>" onclick="javascript:return del();">delete</a>
							</td>
						</tr>
						<%
					}
				}
				
			%>
		 </tr>
		</table>
		<!-- <button>test</button> -->
	</div>
</div>
</body>
</html>