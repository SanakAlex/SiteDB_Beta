<%@ page language="java" contentType="text/html; 	charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default navbar-static-top">
      <div class="container">
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
          	<li><a class="navbar-brand" href="http://localhost:8080"><span class="glyphicon glyphicon-home" aria-hidden="true"></span></a></li>
            <li><a href="../all/all.html">All</a></li>
            <li><a href="../directories/sortByName.html">Directories</a></li>
            <li><a href="../links/listOfLinks.html">Links</a></li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown" id="dropdownMenu1" role="button" aria-haspopup="true" aria-expanded="false">Add <span class="caret"></span></a>
              <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                <li><a href="../directories/newDirectory.html">New directory</a></li>
                <li><a href="../links/newLink.html">New link</a></li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </nav>
