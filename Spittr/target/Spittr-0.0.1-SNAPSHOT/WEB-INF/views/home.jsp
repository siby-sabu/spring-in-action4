<%@ page language="java" contentType="text/html; charset=UTF-8"
	session="false" pageEncoding="UTF-8"%>
<%@ pagelib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spittr</title>
<link rel="stylesheet" type="text/css"
	href="<c:url values="/resources/style.css" />">
</head>
<body>
	<h1>Welcome to Spittr</h1>
	<a href="<c:url value="spittles" />">Spittles</a> |
	<a href="<c:url value="spittles/register" />">Register</a>
</body>
</html>