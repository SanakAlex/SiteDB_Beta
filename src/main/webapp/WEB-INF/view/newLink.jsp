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
</head>
<body>

	<div class="container"><div class="col-md-4 col-md-offset-4">
		<div class="row main">
			<div class="panel-heading">
	              <div class="panel-title text-center">
	               	<h1 class="title">New Link</h1>
	               	<hr />
	               </div>
	        </div> 
	        <div class="main-login main-center">
		     <cf:form class="form-horizontal" method="POST" action="addLink"  modelAttribute="link">
		     	<cf:hidden path="linkId" />
		     	<cf:hidden path="additionDate" />
					<div class="form-group">
				     	<cf:label class="cols-sm-2 control-label" path="linkName">Link Name</cf:label>
				     	<div class="cols-sm-10">
							<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-bookmark" aria-hidden="true"></i></span>
				     		<cf:input class="form-control" path="linkName" placeholder="Enter link Name" /> 
				     		</div>
				     		<cf:errors path="linkName" cssClass="error"/>
						</div>
					</div>
					<div class="form-group">
				     	<cf:label class="cols-sm-2 control-label" path="url">Link URL</cf:label>
				     	<div class="cols-sm-10">
							<div class="input-group">
							<span class="input-group-addon"><i class="glyphicon glyphicon-paperclip" aria-hidden="true"></i></span>
				     		<cf:input class="form-control" path="url" placeholder="Enter link URL" /> 
				     		</div>
				     		<cf:errors path="url" cssClass="error"/>
						</div>
					</div>
					
				    <div class="form-group">
				     	<cf:label path="description">Description</cf:label>
				     	<div class="cols-sm-10">
							<div class="input-group">
							<span class="input-group-addon"><i class="fa fa-comment" aria-hidden="true"></i></span>
				     		<cf:textarea class="form-control"  path="description" placeholder="Enter description of link"/>
				     		</div>
				     		 <cf:errors path="description" cssClass="error"/>
						</div>
					</div>
					
					<div class="form-group">
				     	<cf:label path="status">Status</cf:label>
				     	<div class="cols-sm-10">
							<div class="input-group">
				     		<form:radiobutton  path="status" value="true" label="checked" />    
			             	<form:radiobutton  path="status" value="false" label="unchecked" />	
				     		</div>
						</div>
					</div>
				     
			         <div class="form-group">
				     <cf:label path="utility">Utility</cf:label>
				     
				     	<form:select class="form-control" path="utility">
			   				<form:option value="${1}" label="1"/>
			   				<form:option value="${2}" label="2"/>
			   				<form:option value="${3}" label="3"/>
			   				<form:option value="${4}" label="4"/>
			   				<form:option value="${5}" label="5"/>
						</form:select><cf:errors path="utility" cssClass="error"/>
					</div>
					<div class="form-group">
					
				     <cf:label path="directory">Directory</cf:label>
				     
				     	<form:select class="form-control" path="directory.id">
			   				<form:option value="${null}" label="--- Select ---"/>
			   				<c:forEach var="directory" items="${directoryList}">
				     			<form:option value="${directory.id}">${directory.directoryName}</form:option>
				     		</c:forEach>
						</form:select>
					</div>
				     <div class="form-group ">
							<button type="submit" class="btn btn-primary btn-lg btn-block login-button">Submit</button>
					</div>
				
		     </cf:form>
		     </div>
     	</div>
     
    
			
</div>
</div>
</body>
</html>