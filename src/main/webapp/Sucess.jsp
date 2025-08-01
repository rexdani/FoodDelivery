<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Registration Successful</title>
  <link rel="stylesheet" href="newStyle.css">
  <style>
    body {
      background: #ececec;
      color: #385170;
      font-family: 'Segoe UI', sans-serif;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      text-align: center;
    }

    .success-box {
      background-color: #9fd3c7;
      padding: 40px;
      border-radius: 12px;
      box-shadow: 0 0 20px rgba(56, 81, 112, 0.08);
      max-width: 500px;
    }

    h1 {
      margin-bottom: 20px;
      color: #142d4c;
    }

    p {
      font-size: 18px;
      color: #385170;
    }

    .btn {
      margin-top: 25px;
      padding: 12px 20px;
      border: none;
      border-radius: 6px;
      background: #385170;
      color: #ececec;
      font-weight: bold;
      cursor: pointer;
      transition: 0.3s;
    }

    .btn:hover {
      background: #142d4c;
      box-shadow: 0 0 12px #385170;
    }
  </style>
</head>
<body>
  <div class="success-box">
    <h1>🎉 Registration Successful!</h1>
    <p>Hi <strong>${name}</strong>, your registration is complete.</p>
    <p>Your <strong>Username</strong> is: <code>${userName}</code></p>
    <a href="Login.jsp"><button class="btn">Go to Login</button></a>
  </div>
</body>
</html>
