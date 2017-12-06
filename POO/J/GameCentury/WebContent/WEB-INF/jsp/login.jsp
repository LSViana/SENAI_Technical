<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome to GameCentury! | Home</title>
	<link rel="stylesheet" href="/GameCentury/css/common.css">
	<link rel="stylesheet" href="/GameCentury/css/style.css">
</head>
<body>
	<%@ include file="common/header.jsp" %>
	<form action="login" method="post">
		<label for="username">Username:</label>
		<input type="text" name="username" />
		<label for="password">Password:</label>
		<input type="password" name="password" />
		<button type="submit">Login</button>
	</form>
	<%@ include file="common/footer.jsp" %>
</body>
</html>