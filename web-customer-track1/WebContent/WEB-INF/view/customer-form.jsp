<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<title>Form</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
</head>
<body>

<div id="wrapper">
<div id="header">
<h2> CRM</h2>
</div>
</div>
<div id="container">
<h2>Save</h2>
<form:form action="saveCustomer" modelAttribute="add" method="POST">
<form:hidden path="id"/>
<table><tbody>
<tr>
<td><label>First name:</label>
<td><form:input path="firstName"/>
</td>
</tr>
<tr>
<td><label>Last name:</label>
<td><form:input path="lastName"/>
</td>
</tr>

<tr>
<td><label>email:</label>
<td><form:input path="email"/>
</td>
</tr>
<tr>
<td><label></label>
<td><input type="submit" value="Save" class="save"/>
</td>
</tr>


</tbody>
</table>


</form:form>
<div style="clear;both;">
</div>
<p>
<a href="${pageContext.request.contextPath}/customer/list">Back To List</a>

</body>
</html>