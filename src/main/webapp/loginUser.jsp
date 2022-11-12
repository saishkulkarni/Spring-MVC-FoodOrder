<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login User</title>
<style>
body {
  background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS8hoszhoBY8kd1jDW19QRwybegU10PNjFHkw&usqp=CAU	');
	  background-repeat: no-repeat;
	background-attachment: fixed;  
  background-size: cover;
}
body {font-family: Arial, Helvetica, sans-serif;}
form {border: 3px solid #f1f1f1;}

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

.cancelbtn {
  width: auto;
  padding: 10px 18px;
  background-color: #f44336;
}

.imgcontainer {
  text-align: center;
  margin: 24px 0 12px 0;
}

img.avatar {
  width: 30%;
  border-radius: 50%;
}

.container {
  padding: 16px;
}

span.psw {
  float: right;
  padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
  span.psw {
     display: block;
     float: none;
  }
  .cancelbtn {
     width: 100%;
  }
}
</style>
</head>
<body>
<h1 style="color:blue; text-align: center">User Login Form</h1>

<form action="loginUser" method="post">
<div class="imgcontainer">
    <img src="https://cdn.pixabay.com/photo/2020/07/01/12/58/icon-5359553_1280.png" height="400"  alt="Avatar" class="avatar">
  </div>
  <h3 style="color:red;">${msg}</h3>
  <div class="container">
    <label for="uname"><b>Email</b></label><br>
    <input type="text" placeholder="Enter Email" name="email" required>
<br>
    <label for="psw"><b>Password</b></label><br>
    <input type="password" placeholder="Enter Password" name="password" required>
        <br>
    <button type="submit">Login</button>
   
  </div>

</form>
</body>
</html>