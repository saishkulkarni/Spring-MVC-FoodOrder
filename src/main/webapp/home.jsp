<!DOCTYPE html>
<html>
<head>
<style>
body {
  background-image: url('https://wallpapercave.com/wp/wp1874156.jpg');
	  background-repeat: no-repeat;
	background-attachment: fixed;  
  background-size: cover;
}

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
  border-right:3px solid #bbb;
}

li:last-child {
  border-right:3px solid #bbb;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 38px 60px;
  text-decoration: none;nkW   }

li a:hover:not(.active) {
  background-color: #111;
}

.active {
  background-color: #04AA6D;
}
</style>
</head>
<body>
<h1 style="color:white; font-weight:bold;font-style:italic; text-align: center;">ADMIN PAGE</h1>
<h1 style="color:green;font-style:italic;font-weight:bold">${msg}</h1>
<ul>
  <li><a class="active" href="loginUser.jsp">Login User</a></li>
  <li><a href="loadUser" >Add User</a></li>
  <li><a href="loadProduct">Add Product</a></li>
  <li><a href="productList">Product List</a></li>
  <li><a href="userList">User List</a></li>
  <li><a href="index.jsp">Logout</a></li>
</ul>

</body>
</html>
