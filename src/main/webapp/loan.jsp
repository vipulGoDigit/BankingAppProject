<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Apply for Loan</title>
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

    h2 {
      text-align: center;
      color: #333333;
      margin-bottom: 20px;
    }

    form {
      max-width: 400px;
      margin: 0 auto;
      background-color: #ffffff;
      padding: 30px;
      border-radius: 5px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }

    ol {
      list-style-type: none;
      padding: 0;
    }

    li {
      margin-bottom: 20px;
    }

    label {
      font-weight: bold;
      color: #333333;
    }

    input[type="radio"] {
      margin-right: 10px;
    }

    input[type="submit"] {
      background-color: #004080;
      color: #ffffff;
      padding: 10px 20px;
      border: none;
      border-radius: 3px;
      cursor: pointer;
    }

    input[type="submit"]:hover {
      background-color: #00264d;
    }
  </style>
</head>
<body>
  <h1>Apply For Loan</h1>
  <h2>
    ${sessionScope.cust_name}, Welcome to your account. Please select a Loan type.
  </h2>
  <form action="bankloan">
    <ol>
      <li>
        <label for="homeLoan">Home Loan</label>
        <input type="radio" id="homeLoan" name="ltype" value="Home">
      </li>

      <li>
        <label for="educationLoan">Education Loan</label>
        <input type="radio" id="educationLoan" name="ltype" value="Education">
      </li>

      <li>
        <label for="vehicleLoan">Vehicle Loan</label>
        <input type="radio" id="vehicleLoan" name="ltype" value="Vehicle">
      </li>

      <li>
        <label for="goldLoan">Gold Loan</label>
        <input type="radio" id="goldLoan" name="ltype" value="Gold">
      </li>

      <li>
        <label for="personalLoan">Personal Loan</label>
        <input type="radio" id="personalLoan" name="ltype" value="Personal">
      </li>

      <li>
        <input type="submit" value="Apply">
      </li>
    </ol>
  </form>
</body>
</html>
