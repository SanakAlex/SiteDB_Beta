<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" 	prefix="cf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style>.error{color:red; font-weight:bold;}</style>
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css">
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css">
</head>
<body>
	
		     <cf:form method="POST" action="addLink"  modelAttribute="link">
		     	<cf:hidden path="linkId" />
		     	<cf:hidden path="additionDate" />
		     	<table>
				<tr>
					
				     <td><cf:label path="linkName">Name</cf:label></td>
				     <td><cf:input path="linkName" /> <cf:errors path="linkName" cssClass="error"/></td>
				</tr>
				<tr>
				     <td><cf:label path="url">url</cf:label></td>
				     <td><cf:input path="url" /> <cf:errors path="url" cssClass="error"/></td>
				</tr>
				<tr>
				     <td><cf:label path="description">Description</cf:label></td>
				     <td><cf:textarea  path="description" /> <cf:errors path="description" cssClass="error"/></td>
				</tr>
				<tr>
				     <td><cf:label path="status">Status</cf:label></td>
				     <td>
				     	 <form:radiobutton path="status" value="true" label="checked" /> 
			             <form:radiobutton path="status" value="false" label="unchecked" />
			         </td>
				</tr>
				<tr>
				     <td><cf:label path="utility">Utility</cf:label></td>
				     <td>
				     	<form:select path="utility">
			   				<form:option value="${1}" label="1"/>
			   				<form:option value="${2}" label="2"/>
			   				<form:option value="${3}" label="3"/>
			   				<form:option value="${4}" label="4"/>
			   				<form:option value="${5}" label="5"/>
						</form:select><cf:errors path="utility" cssClass="error"/></td>
				</tr>
				<tr>
				     <td><cf:label path="directory">Directory</cf:label></td>
				     <td>
				     	<form:select path="directory.id">
			   				<form:option value="${null}" label="--- Select ---"/>
			   				<c:forEach var="directory" items="${directoryList}">
				     			<form:option value="${directory.id}">${directory.directoryName}</form:option>
				     		</c:forEach>
						</form:select>
					</td>
				</tr>
				<tr>
				     <td colspan="2">
						<input type="submit" value="Submit"/>
				     </td>
				     <td><div class="form-group ">
							<button type="submit" class="btn btn-primary btn-lg btn-block login-button">Submit</button>
					</div></td>
				</tr>
				</table>
		     </cf:form>
     
</body>
</html>