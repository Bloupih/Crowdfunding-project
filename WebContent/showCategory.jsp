<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show project</title>
<%@ include file="/includes/headers.jsp"%>
</head>
<body>

	<%@ include file="/includes/menu.jsp"%>
	<div class="container">
		<h1>Projets de la catégorie <c:out value="${category.name}" /></h1>
		<h3><br />"<c:out value="${category.content}" />"</h3>

		
		<hr/>
		
			<%@ include file="/includes/listProjects.jsp"%>	
		
		
	</div>
	<%@ include file="/includes/footer.jsp" %>
	
</body>
</html>