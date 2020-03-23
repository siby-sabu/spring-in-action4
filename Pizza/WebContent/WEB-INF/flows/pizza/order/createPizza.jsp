<div xmlns:form="http://www.springframework.org/tags/form"
	xmlns:jsp="http://java.sun.com/JSP/Page">
	<jsp:output omit-xml-declaration="yes" />
	<jsp:directive.page contentType="text/html;charset=UTF-8" />
	<h2>Create Pizza</h2>
	<form:form commandName="pizza">
		<input type="hidden" name="_flowExecutionKey"
			value="${flowExecutionKey}" />
		<b>Size:</b>
		<br />
		<form:radiobutton path="size" label="Small (12-inch)" value="SMALL" />
		<br />
		<form:radiobutton path="size" label="Medium (14-inch)" value="MEDIUM" />
		<br />
		<form:radiobutton path="size" label="Large (16-inch)" value="LARGE" />
		<br />
		<br />
		<br />
		<b>Toppings:</b>
		<form:checkboxes items="${toppingsList}" path="toppings"
			delimiter="&lt;br/&gt;" />
		<br />
		<br />
		<input type="submit" class="button" name="_eventId_addPizza"
			value="Continue">
		<input type="submit" class="button" name="_eventId_cancel"
			value="Cancel">

	</form:form>
</div>