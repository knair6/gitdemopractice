<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<tilte></tilte>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>
<!--  <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>-->
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM</h2>
		</div>
	</div>
	 <div class="container">
		   <div id="content">
		  <input type="button" value="Add Customer" onClick="window.location.href='showFormForAdd'; return false;"
		  class="add-button" />
	<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
				   
		<c:forEach var="customer" items="${customer}">
				<c:url var="update" value="/customer/showFormForUpdate">
				
				<c:param name="custId" value="${customer.id}"/>
				</c:url>
				
				<c:url var="delete" value="/customer/delete">
				
				<c:param name="custId" value="${customer.id}"/>
				</c:url>
				<tr>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.email}</td>
					<td>
					<a href="${update}">Update</a>
					|
					<a href="${delete}" onClick="if(!(confirm('Are you sure you want to delete this?'))) return false">Delete</a>
					</td>
				</tr>
		</c:forEach>
					   
			   </table>
		   </div>
	 </div>
</body></html>