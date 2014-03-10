<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Créer un project</title>
<%@ include file="/includes/headers.jsp"%>
</head>
<body>

	<%@ include file="/includes/menu.jsp" %>
	<div class="container">
	<h2>Créer votre nouveau projet</h2>
	
	<c:if test="${errors}">
		<p style="color: red">Des erreurs sont présentes sur le formulaire</p>
	</c:if>

	<form action="<%= request.getContextPath() %>/auth/admin/editProject" method="POST">
		<div class="form-group">
			
			<div class="input-group col-md-8">
			<label for="userID">Créateur du projet</label>
				<select name="userID" class="form-control selectpicker">
					<c:forEach items="${users}" var="u">
						<option <c:if test="${u.id == UserDao.getUserByPseudo(username).getId()}">selected=true</c:if> value="${u.id}">${u.pseudo}</option>
					</c:forEach>
				</select>
			</div>
			
			<div class="input-group col-md-8">
				<span class="input-group-addon">Nom</span>
				<input type="text" class="form-control" size="40" name="name" id="name" value="<c:out value="${project.name}"/>"/>
			</div>
			<div class="input-group col-md-4">
				<span class="input-group-addon">Prix à atteindre</span>
				<input type="text" data-min="1" data-max="100" class="form-control" size="10" name="price" id="price" value="<c:out value="${project.price}"/>"/>
				<span class="input-group-addon">€</span>
			</div>
			<br/>
			
			<div class="input-group col-md-16">
				<label for="category">Catégorie</label>
				<select name="category" class="form-control selectpicker">
					<c:forEach items="${categories}" var="c">
						<option <c:if test="${c.id == project.getCategory().getId()}">selected=true</c:if> value="${c.id}">${c.name}</option>
					</c:forEach>
				</select>
			</div>
			
			
			<div class="input-group">
				<span class="input-group-addon">Description</span>
				<textarea class="form-control" name="content" id="content" cols="40" ><c:out value="${project.content}" /></textarea>
			</div>
	
			
			
			<div class="row">
				<div class="input-group col-md-2">
					<label for="price">Date début</label>
					<input type="date" class="form-control" name="dateDebut" id="date" value="<c:out value="${project.dateStart}"/>" />
					<span class="add-on"><i class="icon-calendar"></i></span>
				</div>
			
				<div class="input-group col-md-2">
					<label for="price">Date fin</label>
					<input type="date" class="form-control" name="dateEnd" id="date" value="<c:out value="${project.dateEnd}"/>"/>
					
					<input type="hidden" class="form-control" name="id" id="id" value="<c:out value="${project.id}"/>"/>
					<span class="add-on"><i class="icon-calendar"></i></span>
				</div>
			</div>
			
	
			<div class="input-group">
				<input type="submit" class="btn btn-success" name="validate" value="Valider les modifications" />
			</div>
		</div>
	</form>
	</div>
	<%@ include file="/includes/footer.jsp" %>

</body>
</html>