<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<style>
body {
  background-image: url('https://www.pixelstalk.net/wp-content/uploads/2016/08/Download-Images-Food-HD.jpg');
	  background-repeat: no-repeat;
	background-attachment: fixed;  
  background-size: cover;
}
</style>
<meta charset="ISO-8859-1">
<title>Update Product</title>
</head>
<body>
<form:form action="updateproduct1" modelAttribute="product">
<h3 style="color:indigo;">Product Name: <form:input path="name"/></h3><br>
<h3 style="color:indigo;">Product Type: <form:input path="type"/></h3><br>
<h3 style="color:indigo;">Product Cost: <form:input path="cost"/></h3><br>
<h3 style="color:indigo;">Product Id: <form:input path="id" readonly="true"/></h3><br>
<form:button>Submit</form:button>
</form:form>
</body>
</html>