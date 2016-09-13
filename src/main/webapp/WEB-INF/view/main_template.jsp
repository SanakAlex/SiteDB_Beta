<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Java</title>
    <meta name="viewport" content="width=device-with, initial-scale=1.0"/>
    <style>.error{color:red; font-weight:bold;}</style>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css">
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js"/>"></script>
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'>
</head>


<body>

    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="body" />
    <tiles:insertAttribute name="footer" /> 
	
</body>
</html>