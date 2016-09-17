<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
	<head>
		<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Welcome</title>
		<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" type="text/css">
		<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.11.0.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.js"/>"></script>
		<style type="text/css">
			body {
	    		background: url(http://blackrockdigital.github.io/startbootstrap-stylish-portfolio/img/bg.jpg) no-repeat center center scroll;
			}
		</style>
	</head> 
	<body>
		<div class="navbar navbar-default navbar-static-top">
	      <div class="container">
	        
	        <div class="collapse navbar-collapse navHeaderCollapse">
	          <ul class="nav navbar-nav">
	          	<li><a class="navbar-brand" href="http://localhost:8080"><span class="glyphicon glyphicon-home" aria-hidden="true"></span></a></li>
	            <li><a href="all/all.html">All</a></li>
	            <li><a href="directories/sortByName.html">Directories</a></li>
	            <li><a href="links/listOfLinks.html">Links</a></li>
	            <li class="dropdown">
		            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Add <b class="glyphicon glyphicon-plus"></b></a>
		            <ul class="dropdown-menu">
		            	<li><a href="directories/newDirectory.html">New directory</a></li>
		                <li><a href="links/newLink.html">New link</a></li>
					</ul>
	            </li>
	          </ul>
	        </div>
	      </div>
	    </div>
	    <header id="top" class="header">
        <div class="text-vertical-center"><br><br><br><br><br><br><br><br>
            <h1 style="text-align:center;"><kbd>Hello</kbd></h1>
            <br><br><br>
            <h3 style="text-align:center;"><a href="all/all.html" class="btn btn-primary btn-lg dropdown-toggle">Let's start</a></h3>
        </div>
    </header>
	</body>
</html>
