<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dish Detail</title>
</head>
<body>
	<form name="insertCartForm" action="insertCartController" method="post">	
	<input type="hidden" name="did" id="did" value = 4><br>
	<input type="hidden" name="quantity" id="quantity" value = 1><br>
	<input type="submit" name="submit" value="Add not same"><br>
	</form>
	
	<form name="insertCartForm" action="insertCartController" method="post">	
	<input type="hidden" name="did" id="did" value = 2><br>
	<input type="hidden" name="quantity" id="quantity" value = 1><br>
	<input type="submit" name="submit" value="Add same"><br>
	</form>
</body>
</html>