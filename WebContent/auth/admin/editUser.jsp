<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editer mon profil</title>
<%@ include file="/includes/headers.jsp"%>
</head>
<body>

	<%@ include file="/includes/menu.jsp" %>
	<div class="container">
	<h2>Editer l'utilisateur <c:out value='${user.name}'/></h2>
	
	<c:if test="${errors}">
		<p style="color: red">Des erreurs sont présentes sur le formulaire</p>
	</c:if>

	<form action="<%= request.getContextPath() %>/auth/admin/userManagement/editUser" method="POST">
		<input type="hidden"  name="id"  value="<c:out value='${user.id}'/>">
		<div class="form-group">
			<p>
				<label for="nom">Nom :</label>
				<input type="text" class="form-control" size="40" name="nom" id="nom" value="<c:out value='${user.name}'/>"/>
			</p>
	
			<p>
				<label for="prenom">Prenom :</label>
				<input type="text" class="form-control" size="40" name="prenom" id="prenom" value="<c:out value='${user.firstname}'/>"/>
			</p>
	
			<p>
				<label for="mail">Mail :</label>
				<input type="text" class="form-control" size="40" name="mail" id="mail" value="<c:out value='${user.mail}'/>"/>
			</p>
	
			<p>
				<label for="password">Mot de passe :</label>
				<input type="text" class="form-control" size="40" name="password" id="name" placeholder="Entrez un password uniquement si vous voulez changer de password" />
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