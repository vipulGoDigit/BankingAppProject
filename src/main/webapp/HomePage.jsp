<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Welcome to the bank</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
      margin: 0;
      padding: 0;
    }

    h1 {
      text-align: center;
      color: #004080;
      padding: 20px;
    }

    .welcome-message {
      text-align: center;
      color: #333333;
      font-size: 20px;
    }

    ol {
      max-width: 400px;
      margin: 0 auto;
      background-color: #ffffff;
      padding: 30px;
      border-radius: 5px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
      list-style-type: none;
    }

    li {
      margin-bottom: 20px;
    }

    a {
      color: #004080;
      text-decoration: none;
    }

    a:hover {
      color: #00264d;
      text-decoration: underline;
    }
  </style>
</head>
<body>
  <h1>Welcome to the bank</h1>
  <div class="welcome-message">
    ${sessionScope.cust_name}, Welcome to your account. Please select an operation to perform.
  </div>
  <br><br>
  <ol>
    <li><a href="checkBalance">Check Balance</a></li>
    <li><a href="changePin.html">Change Pin</a></li>
    <li><a href="loan.jsp">Apply for Loan</a></li>
    <li><a href="transfer.html">Transfer Amount</a></li>
    <li><a href="logOut">Log Out</a></li>
  </ol>
</body>
</html>
