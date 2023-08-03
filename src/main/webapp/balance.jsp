<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Balance Page</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
      margin: 0;
      padding: 0;
    }

    h3 {
      text-align: center;
      color: #004080;
      margin: 50px 0;
    }

    a {
      display: block;
      max-width: 200px;
      margin: 20px auto;
      text-align: center;
      color: #ffffff;
      background-color: #004080;
      padding: 10px 20px;
      text-decoration: none;
      border-radius: 3px;
    }

    a:hover {
      background-color: #00264d;
    }
  </style>
</head>
<body>
  <h3>
    Balance: ${sessionScope.balance}
  </h3>
  <a href="HomePage.jsp">Homepage</a>
</body>
</html>
