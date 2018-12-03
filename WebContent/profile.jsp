<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Profile</title>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>
<body>
<a href="<%=request.getContextPath()%>/logout.jsp">logout</a><br>
<table>
  <tr>
    <th>Last Name</th>
    <th id="lastname">${LastName}</th>
  </tr>
  <tr>
    <td>First Name</td>
    <td id="firstname">${FirstName}</td>
  </tr>
  <tr>
    <td>Street</td>
    <td id="street">${street}</td>
  </tr>
  <tr>
    <td>City</td>
    <td id="city">${city}</td>
  </tr>
  <tr>
    <td>State</td>
    <td id="state">${state}</td>
  </tr>
  <tr>
    <td>ZipCode</td>
    <td id="zip">${zip}</td>
  </tr>
  <tr>
    <td>phone number</td>
    <td id="phone">${phone}</td>
  </tr>
</table>
<br /> 

<a href="<%=request.getContextPath()%>/profileedit.jsp" id="edit" >Edit Profile</a>

<br/>
<form action="<%=request.getContextPath()%>/MenuController" method="post">
<INPUT TYPE="submit" VALUE="return">
</form>

</body>
</html>