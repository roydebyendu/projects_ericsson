<%@page contentType="text/html" pageEncoding="UTF-8" import = "org.apache.commons.lang3.StringUtils" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Spring 3 MVC Series - Contact Manager</title>
<link rel='stylesheet'
	href='<c:out value="/projects-spring/resources/css/myCSS.css" />'
	type='text/css' media='all' />
</head>
<body>
	<h2>Contact Manager</h2>
	<form:form method="post" action="addContact.html" commandName="contact">

		<table>
			<tr>
				<td><form:label path="firstname"><spring:message code="label.firstname" /></form:label></td>
				<td><form:input path="firstname" /><form:errors path="firstname"/></td>
			</tr>
			<tr>
				<td><form:label path="lastname">Last Name</form:label></td>
				<td><form:input path="lastname" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /><form:errors path="email"/></td>
			</tr>
			<tr>
				<td><form:label path="telephone">Telephone</form:label></td>
				<td><form:input path="telephone" /><form:errors path="telephone"/></td>
			</tr>
			<tr>
				<td><form:label path="country">Country</form:label></td>
				<td><form:select path="country">
						<form:option value="--" label="Select" />
						<form:options items="${countryList}" itemValue="id"
							itemLabel="name" />
					</form:select></td>
			</tr>
			<tr>
				<td><form:label path="course">Course</form:label></td>
				<td><form:checkboxes path="course" items="${courseList}"
						itemValue="id" itemLabel="name" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Add Contact" /></td>
			</tr>
		</table>

	</form:form>

	<h3>Contacts</h3>
	<c:if test="${!empty contactList}">
		<table class="data">
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Telephone</th>
				<th>Country</th>
				<th>Course</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${contactList}" var="contact">
				<tr>
					<td>${contact.lastname},${contact.firstname}</td>
					<td>${contact.email}</td>
					<td>${contact.telephone}</td>
					<td>${contact.country}</td>
					<td>${StringUtils.join(contact.course, ' ,')}</td>
					<td><a href="${contact.id}/delete.html">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>


</body>
</html>

