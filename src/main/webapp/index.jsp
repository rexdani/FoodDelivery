<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <link rel="stylesheet" href="login.css">
</head>
<body>
  <form action="CallingLogin" method="post" class="form-box">
    <h1>Login</h1>

    <p>Email</p>
    <input type="text" name="userName" required>

    <p>Password</p>
    <input type="password" name="password" required>
     <h5 >${message}</h5>

    <input type="submit" value="Login">

    <div class="link-box">
      <a href="Registeration.jsp">Create an Account</a> 
      </div>
  </form>
</body>
</html>

