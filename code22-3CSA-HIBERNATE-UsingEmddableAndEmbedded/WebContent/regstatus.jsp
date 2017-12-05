<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Status</title>
</head>
<body>
	<h1>Successful Registration</h1>
	
	<p>ID: ${student.id}</p>
	<p>Last Name: ${student.lastName}</p>
	<p>First Name: ${student.firstName}</p>
	<p>Course: ${student.course}</p>
	<p>Year Level: ${student.yearLevel}</p>
	<p>Sreet: ${student.address.street}</p>
	<p>City: ${student.address.city}</p>
	<p>Zip Postal Code: ${student.address.zipCode}</p>
</body>
</html>