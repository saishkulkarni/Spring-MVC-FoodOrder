<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<style>
a:link, a:visited {
  background-color: white;
  color: black;
  border: 2px solid green;
  padding: 10px 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: green;
  color: white;
}
input[type=text], input[type=password] {
  width: 30%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 30%;
}

button:hover {
  opacity: 0.8;
}
body {
  background-image: url('https://images2.alphacoders.com/862/862730.jpg');
	  background-repeat: no-repeat;
	background-attachment: fixed;  
  background-size: cover;
}
</style>
<meta charset="ISO-8859-1">
<title>Order Food</title>
</head>
<body>
<form:form action="foodOrder2" modelAttribute="foodOrder">
<h3 style="color:yellow;">Name: <br><form:input path="name"/></h3><br>
<h3 style="color:yellow;">Phone No: <br><form:input path="mob"/></h3><br>
<form:button>Register</form:button><br>
<a href="userNavigation.jsp">Back</a>
</form:form>
</body>
</html>