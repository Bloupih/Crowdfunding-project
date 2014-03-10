<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Créer une catégorie</title>
<%@ include file="/includes/headers.jsp"%>
</head>
<body>
	<%@ include file="/includes/menu.jsp" %>
	<div class="container">
			<h2>Créer une nouvelle catégorie</h2>
			<c:if test="${errors}">
				<p style="color: red">Des erreurs sont présentes sur le formulaire</p>
			</c:if>
			<form action="<%= request.getContextPath() %>/auth/admin/addCategory" method="post">
				<div class="form-group">
					<p>
						<label for="name">Nom de la catégorie :</label>
						<input type="text" class="form-control" name="name" id="" />
						<label for="name">Description de la catégorie :</label>
						<input type="text" class="form-control" name="content" id="" />
					</p>
					<p><input type="submit" class="btn btn-success" value="Créer la nouvelle catégorie" /></p>
				</div>
			</form>
	</div>
	<%@ include file="/includes/footer.jsp" %>
</body>
</html>