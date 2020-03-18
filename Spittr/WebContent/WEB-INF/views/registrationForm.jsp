<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<title><s:message code="spitter.code" /> </title>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/css/style.css"></c:url>' />
</head>
<body>
	<h1>Register</h1>
	<sf:form method="POST" modelAttribute="spitter"
		action="/Spittr/spitter/register">

		<sf:errors path="*" element="div" cssClass="errors" />
		<br />
		<sf:label path="firstName" cssErrorClass="error">First Name:</sf:label>
		<sf:input path="firstName" cssErrorClass="error"/>
			<br />
		<sf:label path="lastName" cssErrorClass="error">Last name</sf:label> 
		<sf:input path="lastName"  cssErrorClass="error"/>
			<br />
		Username: <sf:input path="userName" />
			<br />
		Password: <sf:password path="password" />
		<br />
		<input type="submit" value="Register" />
	</sf:form>


</body>
</html>