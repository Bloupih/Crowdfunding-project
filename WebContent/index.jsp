<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.supinfo.supcrowdfunding.entity.RoleDao" %>
<%@ page import="com.supinfo.supcrowdfunding.entity.UserDao" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>SupCrowdFunding</title>

<%@ include file="/includes/headers.jsp"%>

</head>
<body>

<%@ include file="/includes/menu.jsp"%>
 <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h1>Bienvenue !</h1>
        <p>Cette web-app est un système de Crowd-Funding développé en JavaEE (Servlets,JSP,JPA) pour la partie back-office 
        et avec le framework Bootstrap 3.0.2 pour la partie front-office.</p>
        <p>C'est un mini-projet d'étude de Bachelor of Science de l'école d'ingénieur SupInfo Paris.</p>
        <p><a href="<%=request.getContextPath()%>/listProject" class="btn btn-primary btn-lg" role="button">Voir les projets &raquo;</a></p>
      </div>
    </div>
    
    <div class="container">
    	<%@ include file="/includes/listProjects.jsp"%>		
    </div>
    
    
  
<%@ include file="/includes/footer.jsp"%>
<%
try{
	if (RoleDao.getRoleNameById(0).equals(null)){
		RoleDao.instanciateTable();
		UserDao.instanciateTable();
	}
}
catch (Exception ex){
	RoleDao.instanciateTable();
	UserDao.instanciateTable();
}
%>
</body>
</html>