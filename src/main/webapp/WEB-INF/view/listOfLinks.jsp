<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
	<div class="col-md-10 col-md-offset-1">
		<div class="panel panel-default panel-table ">
			<div class="panel-heading">
                <div class="row">
                  <div class="col col-xs-6">
                    <h1 class="panel-title">All Links</h1>
                  </div>
                  <div class="col col-xs-6 text-right">
                    <a href="../links/newLink.html" type="button" class="btn btn-sm btn-primary btn-create">Create New</a>
                  </div>
                </div>
            </div>
        <div class="panel-body">
			<table class="table table-striped table-bordered table-list">
			<thead align="center">
				<tr>
					<th></th>
					<th><a href="listOfLinks.html" title="Sort by id">Id</a></th>
					<th><a href="sortByName.html" title="Sort by name">Name</a></th>
					<th>Description</th>
					<th><a href="sortByAdditionDate.html" title="Sort by addiotionTime">AddiotionTime</a></th>
					<th><a href="sortByUtility.html" title="Sort by utility">Utility</a></th>
					<th><a href="sortByDirectory.html" title="Sort by directory">Directory</a></th>
					<th><a href="sortByStatus.html" title="Sort by status">Status</a></th>
					<th style="text-align:center;"><em class="fa fa-cog"></em></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="link" items="${linkList}">
					<tr>
						<td><i class="fa fa-file" aria-hidden="true"></i></td>
						<td><c:out value="${link.linkId}" /></td>
						<td><a href="${link.url}" title="Go to link ${link.url}"><c:out value="${link.linkName}" /></a></td>
						<td><c:out value="${link.description}" /></td>
						<fmt:formatDate value="${link.additionDate}" var="dateString" pattern="yyyy-MM-dd HH:mm" />
						<td><c:out value="${dateString}" /></td>
						<td><c:out value="${link.utility}" /></td>
						<td><c:out value="${link.directory.getDirectoryName()}" /></td>
						<td>
						<c:if test="${link.status}"><c:out value="checked" /></c:if>
						<c:if test="${!link.status}"><c:out value="unchecked" /></c:if>
						</td>
						<td align="center">
							<a class="btn btn-default" href="editLink_${link.linkId}" title="Edit"><em class="fa fa-pencil"></em></a>
							<button class="btn btn-danger" data-toggle="modal" data-target=".bs-example-modal-sm${link.linkId}" title="Delete"><em class="fa fa-trash"></em></button>
								<div class="modal fade bs-example-modal-sm${link.linkId}" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
								  <div class="modal-dialog modal-sm">
								    <div class="modal-content">
								      <div class="alert alert-danger" role="alert">Do you really wont to delete link <br><b>${link.linkName}</b></div>
								      	<div class="modal-footer">
									        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
									        <a href="../links/deleteLink_${link.linkId}" class="btn btn-danger" title="Confirm">Delete</a>
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