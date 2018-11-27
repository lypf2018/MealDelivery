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
<table>
  <tr>
    <th>Last Name</th>
    <th>${LastName}</th>
  </tr>
  <tr>
    <td>First Name</td>
    <td>${FirstName}</td>
  </tr>
  <tr>
    <td>Street</td>
    <td>${street}</td>
  </tr>
  <tr>
    <td>City</td>
    <td>${city}</td>
  </tr>
  <tr>
    <td>State</td>
    <td>${state}</td>
  </tr>
  <tr>
    <td>ZipCode</td>
    <td>${zip}</td>
  </tr>
  <tr>
    <td>phone number</td>
    <td>${phone}</td>
  </tr>
</table>
<br /> 

<a href="<%=request.getContextPath()%>/profileedit.jsp">Edit Profile</a>

</body>
</html>