<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Loan Application</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f2f2f2;
      margin: 0;
      padding: 0;
    }

    .header {
      color: blue;
      text-align: center;
      padding: 20px;
    }

    .content {
      max-width: 600px;
      margin: 0 auto;
      background-color: #ffffff;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }
  </style>
</head>
<body>
  <h1 class="header">
    ${sessionScope.cust_name}, Thanks For Applying ${sessionScope.ltype} Loan from Our Bank.
  </h1>

  <div class="content">
    <p>
      ${sessionScope.description}
    </p>
  </div>
</body>
</html>
