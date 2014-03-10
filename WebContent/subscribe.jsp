<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add project</title>
<%@ include file="/includes/headers.jsp"%>
</head>
<body>

	<%@ include file="/includes/menu.jsp" %>
	<div class="container">
	<h2>S'enregister</h2>
	
	<c:if test="${errors}">
		<p style="color: red">Des erreurs sont présentes sur le formulaire</p>
	</c:if>

	<form action="<%= request.getContextPath() %>/subscribe" method="post">
		<div class="form-group">
			<p>
				<label for="pseudo">Pseudo :</label>
				<input type="text" class="form-control" size="40" name="pseudo" id="pseudo" />
			</p>
			
			<p>
				<label for="nom">Nom :</label>
				<input type="text" class="form-control" size="40" name="nom" id="nom" />
			</p>
	
			<p>
				<label for="prenom">Prenom :</label>
				<input type="text" class="form-control" size="40" name="prenom" id="prenom" />
			</p>
	
			<p>
				<label for="mail">Mail :</label>
				<input type="email" class="form-control" size="40" name="mail" id="mail" />
			</p>
				
			<p>
				<label for="password">Password :</label>
				<input type="password" class="form-control" size="10" name="password" id="password" />
			</p>
				
			<p>
				<label for="pass2">Retapez votre password :</label>
				<input type="password" class="form-control" size="10" name="pass2" id="pass2" />
			</p>
	
			<p>
				<input type="submit" class="btn btn-success" name="subscribe" value="S'inscrire" />
			</p>
		</div>
	</form>
	</div>
	<%@ include file="/includes/footer.jsp" %>

</body>
</html>