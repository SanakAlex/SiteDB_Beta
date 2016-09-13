<%@ page language="java" contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Links</title>
</head>
<body>
<div class="container">
    <div class="row">
	<div class="col-md-8 col-md-offset-2">
		<div class="panel panel-default panel-table ">
			<div class="panel-heading">
                <div class="row">
                  <div class="col col-xs-6">
                    <h3 class="panel-title">All Directories</h3>
                  </div>
                  <div class="col col-xs-6 text-right">
                    <a href="../directories/newDirectory.html" type="button" class="btn btn-sm btn-primary btn-create">Create New</a>
                  </div>
                </div>
            </div>
        <div class="panel-body">
		<table class="table table-striped table-bordered table-list">
			<thead align="center">
				<tr align="center">
					<th></th>
					<th><a href="listOfDirectories.html">Id</a></th>
					<th><a href="sortByName.html">Name</a></th>
					<th style="text-align:center;"><em class="fa fa-cog"></em></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="directory" items="${directoryList}">
					<tr>
						<td style="text-align:center;"><i class="fa fa-folder" aria-hidden="true"></i></td>
						<td><c:out value="${directory.id}" /></td>
						<td><a href="../links/listOfLinksOfDirectory_${directory.directoryName}"><c:out value="${directory.directoryName}" /></a></td>
						<td align="center">
							<a class="btn btn-default" href="../directories/editDirectory_${directory.id}" title="Edit"><em class="fa fa-pencil"></em></a>
							<button class="btn btn-danger" data-toggle="modal" data-target=".bs-example-modal-sm${directory.id}" title="Delete"><em class="fa fa-trash"></em></button>
								<div class="modal fade bs-example-modal-sm${directory.id}" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
								  <div class="modal-dialog modal-sm">
								    <div class="modal-content">
								      <div class="alert alert-danger" role="alert">Do you really wont to delete directory <br><b>${directory.directoryName}</b><br>
								      	Also will be deleted next links:<br>
								      	<c:forEach var="link" items="${linkList}">
								      		<b><c:if test ="${link.directory.directoryName == directory.directoryName}"><c:out value="${link.linkName}" /></c:if></b>
								      	</c:forEach>
								      </div>
								      	<div class="modal-footer">
									        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
									        <a href="../directories/deleteDirectory_${directory.id}" class="btn btn-danger" title="Confirm">Delete</a>
									      </div>
								    </div>
								  </div>
								</div>
						</td>
					</tr>
				</c:forEach>	
			</tbody>
		</table>
		</div>   
</div>
</div>
</div>
</div>
 	
</body>
</html>