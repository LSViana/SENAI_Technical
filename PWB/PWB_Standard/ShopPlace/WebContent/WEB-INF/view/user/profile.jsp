<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/user/login" var="userLogin"></c:url>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sign In</title>
</head>
<body>
	<h1>Profile of ${user.name}</h1>
	<section>
		<div>
			<h3>Name:</h3>
			<p>${user.name}</p>
		</div>
		<div>
			<h3>E-mail:</h3>
			<p>${user.email}</p>
		</div>
		<div>
			<h3>E-mail:</h3>
			<p>${user.formattedDateOfBirth}</p>
		</div>
	</section>
</body>
</html>