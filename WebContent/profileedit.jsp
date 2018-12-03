<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edit profile</title>
</head>
<body>
	<a href="<%=request.getContextPath()%>/logout.jsp">logout</a><br>
	<form name="proflieform" action="<%=request.getContextPath()%>/ProfileController?edit=1" method="post" >

	Last Name: <br><input type="text" name="LastName" id="lastname" required><br>
	First Name: <br><input type="text" name="FirstName" id="firstname" required><br>
	Street: <br><input type="text" name="Street" id="street" required><br>
	City: <br><input type="text" name="City" id="city" required><br>
	State: <br><input type="text" name="State" id="state" required><br>
	ZipCode: <br><input type="number" name="ZipCode" id="zipcode" required><br>
	Phone Number: <br><input type="text" name="Phone" id="phone" required><br>
	<br>
	<input type="submit" name="submit" value="submit"><br>
	</form>
	
	<form action="<%=request.getContextPath()%>/ProfileController" method="post">
      <INPUT TYPE="submit" VALUE="return">
    </form>

</body>
</html>