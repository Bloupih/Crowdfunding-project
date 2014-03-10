<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List projects</title>
<%@ include file="/includes/headers.jsp"%>
</head>
<body>

	<%@ include file="/includes/menu.jsp"%>
		<div class="container">
			<h2>Liste des catégories</h2>
			<hr/>
			<c:forEach items="${categories}" var="c">
			
				<div id="category" class="col-md-3">
					<h4>
						<strong><c:out value="${c.name}" /></strong>  
					</h4>
					
					<p><c:out value="${c.content}" /></p>
					
					<p><br />
						<a class="btn btn-default" href="showCategory?id=${c.id}" role="button">Voir les projets &raquo;</a>
						<c:if test="${not empty role && role == 0}">
							<br />
							<form method="post" action="<%=request.getContextPath()%>/auth/admin/removeCategory">
								<input type="hidden" name="id" value="${c.id}" />
								<input type="submit" class="btn btn-danger" value="Supprimer cette catégorie">
							</form>
						</c:if>
					</p>
				</div>
			</c:forEach>
		</div>
	<%@ include file="/includes/footer.jsp"%>

</body>
</html>