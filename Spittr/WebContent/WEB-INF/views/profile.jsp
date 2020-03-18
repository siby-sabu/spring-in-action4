<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>

	<div>
	<h1>Your Profile</h1>
		<span class="spitterUserName"> <c:out value="${spitter.userName}"></c:out></span><br/>
		<span class="spitterFirstName"><c:out value="${spitter.firstName}"></c:out></span><br/>
		<span class="spitterLastName"><c:out value="${spitter.lastName}"></c:out></span><br/>
	</div>

</body>
</html>