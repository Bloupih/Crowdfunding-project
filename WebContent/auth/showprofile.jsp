<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profil</title>
<%@ include file="/includes/headers.jsp"%>

</head>
<body>

	<%@ include file="/includes/menu.jsp" %>
	<div class="container">
	<h2>Editer mon profil</h2>
	
	<c:if test="${errors}">
		<p style="color: red">Des erreurs sont présentes sur le formulaire</p>
	</c:if>

	<form action="<%= request.getContextPath() %>/auth/editProfile" method="GET">
		<div class="form-group">
			<p>
				<label for="name">Nom : </label> <c:out value='${user.name}'/>
			</p>
	
			<p>
				<label for="content">Prenom : </label> <c:out value='${user.firstname}'/>
			</p>
	
			<p>
				<label for="price">Mail : </label> <c:out value='${user.mail}'/>
			</p>
			
			<p>
				<input type="submit" class="btn btn-success" value="Editer mes informations" />
			</p>
		</div>
	</form>
	</div>
	<%@ include file="/includes/footer.jsp" %>

</body>
</html>