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
<title>Update User</title>
</head>
<body>
<form:form action="updateuser1" modelAttribute="user">
<h3 style="color:indigo;">User Name: <form:input path="name"/></h3><br>
<h3 style="color:indigo;">User Email: <form:input path="email"/></h3><br>
<h3 style="color:indigo;">User Password: <form:input path="password"/></h3><br>
<h3 style="color:indigo;">User Id: <form:input path="id" readonly="true"/></h3><br>
<form:button>Submit</form:button>
</form:form>
</body>
</html>