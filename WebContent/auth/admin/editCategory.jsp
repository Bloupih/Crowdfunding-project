<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editer la catégorie</title>
<%@ include file="/includes/headers.jsp"%>
</head>
<body>

	<%@ include file="/includes/menu.jsp" %>
	<div class="container">
	<h2>Editer la catégorie</h2>
	
	<c:if test="${errors}">
		<p style="color: red">Des erreurs sont présentes sur le formulaire</p>
	</c:if>

	<form action="<%= request.getContextPath() %>/auth/admin/editCategory" method="POST">
		<input type="hidden"  name="id"  value="<c:out value='${category.id}'/>">
		<div class="form-group">
			<p>
				<label for="nom">Nom :</label>
				<input type="text" class="form-control" size="40" name="nom" id="nom" value="<c:out value='${category.name}'/>"/>
			</p>
	
			<p>
				<label for="prenom">Description :</label>
				<input type="text" class="form-control" size="40" name="content" id="content" value="<c:out value='${category.content}'/>"/>
			</p>
			
			<p>
				<input type="submit" class="btn btn-success" name="sender" value="Sauver les modifications" />
			</p>
		</div>
	</form>
	</div>
	<%@ include file="/includes/footer.jsp" %>

</body>
</html>