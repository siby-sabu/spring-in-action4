<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<link ref="stylesheet" type="text/css"
	th:href="@{resources/css/style.css}">
<title>Spittr</title>
</head>
<body onload='document.f.username.focus();'>
	<!-- <div id="header" th:include="page :: header" ></div> -->
	<div id="content">
		<form name="f" method="POST" >

			<label >User
				Name: </label> <input type="text" name="username" value="" ></input> <br />
			<label >Password 
					  </label> <input type="text" name="password" value="" ></input> <br />	
			<!--  <input id="remember_me"  name="remember-me" type="checkbox" />	 -->	
			<!--  <label for="remember_me" class="inline">Remember Me</label> -->
			<input type="submit" value="Login" />
		</form>
	</div>
	<!-- <div id="footer" th:include="page :: copy" ></div> -->
</body>
</html>