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

#customers tr:nth-child(even){background-color: white;}

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
<title>Bill</title>
</head>
<body>
<h1 style="text-align: center;color:green" >Bill</h1>
<table id="customers" class="w3-table-all w3-xxxlarge" border="1" style="background:azure;" >

<tr>
<th>Ordered By :</th>
<td>${foodOrder.getName()}</td>
</tr>

<tr>
<th>Mobile Number :</th>
<td>${foodOrder.getMob()}</td>
</tr>
<tr>
<td>
</td>
</tr>

<tr>
<th>Item Name</th>
<th>Item Quantity</th>
<th>Item Cost</th>
</tr>
<c:forEach var="item" items="${foodOrder.getItemDTOs()}">

<tr>
<td>${item.getName()}</td>
<td>${item.getQuantity()}</td>
<td>${item.getCost()}</td>
</tr>

</c:forEach>
<tr>
<td>
</td>
<td>
</td>
<th>
Total
</th>
</tr>

<tr>
<td>
</td>
<td>
</td>
<th>
${foodOrder.getCost()}
</th>
</tr>
</table>
<a href="logout">Logout</a>
</body>
</html>