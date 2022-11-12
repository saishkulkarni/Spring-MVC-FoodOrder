<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
body {
  background-image: url('https://www.expatrio.com/sites/default/files/styles/image_slider/public/2022-05/hermes-rivera-Ww8eQWjMJWk-unsplash_3.jpg?itok=aqyA4cvZ');
	  background-repeat: no-repeat;
	background-attachment: fixed;  
  background-size: cover;
}
#customers {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 20px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
}
</style>
<meta charset="ISO-8859-1">
<title>Menu</title>
</head>
<body>
<h2 style="color:green; font-weight:bold;font-style:italic; text-align: center">${msg}</h2>
<h1 style="color:blue; font-weight:bold;font-style:italic; text-align: center">MENU</h1>
<table id="customers" class="w3-table-all w3-xxxlarge" border="1" style="background:azure;" >
<tr>
<th>Product Id</th>
<th>Product Name</th>
<th>Product Type</th>
<th>Product Cost</th>
<th>Add</th>
</tr>

<c:forEach var="product" items="${products}">

<tr>
<td>${product.getId()}</td>
<td>${product.getName()}</td>
<td>${product.getType()}</td>
<td>${product.getCost()}</td>
<td><a href="addOrder?Id=${product.getId()}">Add</a>
</tr>

</c:forEach>
</table>
<a href="submitOrder">Submit</a><br>	
<a href="userNavigation.jsp">Back</a><br>
<a href="logout">Logout</a>
</body>
</html>