<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Balance Fail</title>
</head>
<body>
		<h1>
		<%
		session=request.getSession();
		out.println(session.getAttribute("cust_name"+ ",your balance could not be fetched"));
		
		%>
		
		
		</h1>
			<a href="HomePage.jsp">HomePage</a>

</body>
</html>