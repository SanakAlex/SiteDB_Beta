<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" 	prefix="cf"%>

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
	               	<h1 class="title">New Directory</h1>
	               	<hr />
	               </div>
	        </div> 
	        <div class="main-login main-center">
		        <cf:form class="form-horizontal" method="POST" action="addDirectory"  modelAttribute="directory">
	     			<cf:hidden path="id" />
			     	<div class="form-group">
						    <cf:label class="cols-sm-2 control-label" path="directoryName">Name</cf:label>
						    <div class="cols-sm-10">
							    <div class="input-group">
								    <span class="input-group-addon"><i class="fa fa-folder" aria-hidden="true"></i></span>
								    <cf:input class="form-control" path="directoryName" placeholder="Enter directory Name" /> 
							    </div>
						    <cf:errors path="directoryName" cssClass="error"/>
						    </div>
							
					</div>	
					<div class="form-group ">     
						<input type="submit" value="Submit" class="btn btn-primary-outline btn-lg btn-block login-button"/>
					</div>	
	     		</cf:form>
     		</div>
     		</div>
     	</div>
</div>
</body>
</html>