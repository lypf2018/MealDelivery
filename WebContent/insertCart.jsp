<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="" method="post">
  <table >
  <tr>
    <td>dish 4</td><td>numbers:</td>
    <td>
    <input type="hidden" name="did" id="did" value = 4><br>
    <input type="button" value="+" onclick="this.form.c1.value++"/>
    <input type="text" name="quantity" id="quantity" value=0 size="4"/>
    <input type="button"  value="-" onclick="this.form.c1.value--"/>
    </td>
  </tr>
  </table>
  <input type="submit" name="submit" value="Add same"><br>    
  </form> 
</body>
</html>