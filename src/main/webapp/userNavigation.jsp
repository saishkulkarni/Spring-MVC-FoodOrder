<!DOCTYPE html>
<html>
<head>
<style>
body {
  background-image: url('https://images2.alphacoders.com/862/862730.jpg');
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
  padding: 34px 36px;
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
<h2 style="color:green;">${msg}</h2>
<ul>
  <li><a class="active" href="foodOrder1">Order Food</a></li>
  <li><a href="fetchallorder">All Food Orders</a></li>
  <li><a href="logout">Logout</a></li>
</ul>

</body>
</html>
