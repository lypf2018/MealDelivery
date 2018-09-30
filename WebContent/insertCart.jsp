<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form name="insertCartForm" action="insertCartController" method="post">	
	<input type="hidden" name="did" id="did" value = 4><br>
	<input type="hidden" name="quantity" id="quantity" value = 1><br>
	<input type="submit" name="submit" value="Add not same"><br>
	</form>
	
	<form name="insertCartForm" action="insertCartController" method="post">	
	<input type="hidden" name="did" id="did" value = 1><br>
	<input type="hidden" name="quantity" id="quantity" value = 1><br>
	<input type="submit" name="submit" value="Add same"><br>
	</form>
</body>
</html>