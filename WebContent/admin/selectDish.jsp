<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="domain.bean.Dish"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function del() {
	var msg = "Are you sure to delete this dish？\n\nPlease Confirm！";
	if (confirm(msg)==true) { return true; }
	else { return false; }
}
</script>
</head>
<body>
<div>
	<div float='left' width='20%' background-color='red'">
		<a href="<%=request.getContextPath()%>/admin/AdAddDishController">add dish</a><br/>
		<a href="<%=request.getContextPath()%>/admin/ShowOrder?id=all ">show order</a>
	</div>
	<div float='right' width='60%'>
		<table border='1' cellspacing='0' width='60%'>
			<tr>
				<td>ID</td>
				<td>Dish_Name</td>
				<td>Dish_Description</td>
				<td>Dish_Picture</td>
				<td>Dish_Price</td>
				<td>Dish_Category</td>
				<td>Edit_Dish</td>
				<td>Delete_Dish</td>
			</tr>
			<tr>
			<%
				List<Dish> list = (List<Dish>)request.getAttribute("list");
				if(list != null && list.size() > 0){
					for(Dish dish : list){
						%>
						<tr>
							<td><%= dish.getId() %></td>
							<td><%= dish.getName() %></td>
							<td><%= dish.getDes() %></td>
							<td><img src="<%=request.getContextPath()%>/image/<%=dish.getPic() %>"/></td>
							<td><%= dish.getPrice() %></td>
							<td><%= dish.getDCId() %></td>
							<td>
								<a href="<%=request.getContextPath()%>/admin/AdEditDishController?id=<%=dish.getId()%>">edit</a>
							</td>
							<td>
								<a href="<%=request.getContextPath()%>/admin/AdDeleteDishController?id=<%=dish.getId()%>" onclick="javascript:return del();">delete</a>
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