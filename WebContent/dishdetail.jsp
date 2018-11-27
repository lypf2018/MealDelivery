<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="domain.bean.Dish"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type ="text/javascript">
function del(){
    var num=parseInt($('#quantity').val())-1;
    if(num<1){
        $('#quantity').val(1);
    }else{
        $('#quantity').val(num);
    }

}


function add(){
    var num=parseInt($('#quantity').val())+1;
    $('#quantity').val(num);

}
</script>
<meta charset="UTF-8">
<title>Dish Detail</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/ProfileController">profile</a><br>
<a href="<%=request.getContextPath()%>/CartController">shopping cart</a><br>
			<%
				List<Dish> list = (List<Dish>)request.getAttribute("list");
				if(list != null && list.size() > 0){
					for(Dish dish : list){
						%>
<td>dish <%= dish.getId() %></td>
<div float='right' width='60%'>
		<table border='1' cellspacing='0' width='60%'>
			<tr>
				<td>Dish_Name</td>
				<td>Dish_Description</td>
				<td>Dish_Picture</td>
				<td>Dish_Price</td>
			</tr>
			<tr>

						<tr>
							<td><%= dish.getName() %></td>
							<td><%= dish.getDes() %></td>
							<td><img src="<%=request.getContextPath()%>/image/<%=dish.getPic() %>"/></td>
							<td><%= dish.getPrice() %></td>
						</tr>

		 </tr>
		</table>
		<!-- <button>test</button> -->
	</div>
	<td>numbers:</td><br/>
<form action="<%=request.getContextPath()%>/insertCartController" method="post">
    <input type="hidden" name="did" id="did" value = <%= dish.getId() %>><br>
    <input type="button" value="-"  id = "decrease" onclick="del()"/>
	<input type="text" name="quantity" id="quantity" value=1 size="4"/>
	<input type="button" value="+"  id = "increase" onclick="add()"/>
  <input type="submit" name="submit" value="Add to cart"><br>    
</form><br/>
  						<%
					}
				}
				
			%> 

</body>
</html>
