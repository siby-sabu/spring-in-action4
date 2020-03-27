<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<body>
	<c:forEach items="${spittleList}" var="spittle">
		<li id="spittle_ <c:out value="${spittle.id}"/>">
			<div id="spittleMessage">
				<c:out value="${ spittle.message}"></c:out>
			</div>
			<div>
				<span class="spittleTime"> <c:out value="${spittle.time }"></c:out></span>
				<span class="spittleLocation">(<c:out
						value="${spittle.latitude }" />,<c:out
						value="${spittle.longitude}" /> )
				</span>
			</div>
		</li>
	</c:forEach>
</body>
</html>