<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>administration des utilisateurs</title>

 <%@ include file="/includes/headers.jsp"%>
</head>
<body>
	<div id="wrapper">
	 <%@ include file="/includes/menu.jsp"%>
	 
	 <div id="page-wrapper">
		<div class="row">
          <div class="col-lg-12">
            <h1>Dashboard <small>&raquo administration des utilisateurs</small></h1>
            <ol class="breadcrumb">
              <li class="active"><i class="fa fa-dashboard"></i> Ajouter/Editer/Supprimer les differents utilisateurs </li>
            </ol>
            
            <c:if test="${alert == 0}">
				<div class="alert alert-warning alert-dismissable">L'utilisateur n'a pas pu être supprimé correctement.</div>
			</c:if>
			 <c:if test="${alert == 1}">
				<div class="alert alert-success alert-dismissable">L'utilisateur a été supprimé de la base de donnée avec succès !</div>
			</c:if>
            
          </div>
        </div><!-- /.row -->

        <div class="row">
          <div class="col-lg-16">
            <div class="panel panel-warning">
              <div class="panel-heading">
                <div class="row">
                  <div class="col-xs-6">
                    <i class="fa fa-users fa-5x"></i>
                  </div>
                  <div class="col-xs-6 text-right">
                    <p class="announcement-heading"><c:out value="${totalCountUsers}"/></p>
                    <p class="announcement-text">Utilisateurs</p>
                  </div>
                </div>
              </div>
              
          
        </div><!-- /.row -->

        <div class="row">
          <div class="col-lg-12">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-users"></i> Listes des utilisateurs</h3>
              </div>
              <div class="panel-body">
                <div class="table-responsive">
	              <table class="table table-hover table-striped tablesorter">
	                <thead>
	                  <tr>
	                    <th class="header">ID<i class="fa fa-sort"></i></th>
	                    <th class="header">Argent engagé <i class="fa fa-sort"></i></th>
	                    <th class="header">Pseudo <i class="fa fa-sort"></i></th>
	                    <th class="header">Projets créés<i class="fa fa-sort"></i></th>
	                    <th class="header">Nom <i class="fa fa-sort"></i></th>
	                    <th class="header">Prénom <i class="fa fa-sort"></i></th>
	                    <th class="header">Mail <i class="fa fa-sort"></i></th>
	                    <th class="header">Rôle <i class="fa fa-sort"></i></th>
	               
	                    <th class="header">Modifications <i class="fa"></i></th>
	                  </tr>
	                </thead>
	                <tbody>
	                
	                <c:forEach items="${users}" var="user">
	                	<c:if test="${user.getRole()==0}"> <c:set var="style" value='success' /> </c:if>
	                	<c:if test="${user.getRole()==1}">
	                		<c:set var="style" value='normal' />
	                		<c:set var="locked" value='fa fa-unlock' />
	                		<c:set var="disabled" value='' /> 
	                	</c:if>
	                	<c:if test="${user.getRole()==2}"> 
	                		<c:set var="style" value='danger' /> 
	                		<c:set var="locked" value='fa fa-lock' />
	                		<c:set var="disabled" value='' /> 
	                	</c:if>
	                	
	                	<c:if test="${ user.getRole() == 0 }"> 
	                		<c:set var="locked" value='fa fa-unlock' />
	                		<c:set var="disabled" value='disabled="disabled"' /> 
	                	</c:if>
	                	
			                <tr class="<c:out value="${style}"/>">
			                    <td><c:out value="${user.id}" /></td>
			                    <td><c:out value="${user.moneyEngaged()}" /></td>
			                    <td><c:out value="${user.pseudo}" /></td>
			                    <td><c:out value="${user.countproject()}"/></td>
			                    <td><c:out value="${user.name}" /></td>
			                    <td><c:out value="${user.firstname}" /></td>
			                    <td><c:out value="${user.mail}" /></td>
			                    <td><c:out value="${user.getRoleName()}" /></td>
			                    <td>
			                   		<a class="btn btn-warning" href="<%=request.getContextPath()%>/auth/admin/userManagement/editUser?id=<c:out value='${user.id}' />" role="button">
										<i class="fa fa-pencil-square-o"/></i>
									</a>
									
									<a class="btn btn-default" href="<%=request.getContextPath()%>/auth/admin/banUser?id=<c:out value='${user.id}' />" role="button" <c:out value="${disabled}"/>>
										<i class="<c:out value="${locked}"/>"></i>
									</a>
									
									<a class="btn btn-danger" href="<%=request.getContextPath()%>/auth/admin/removeUser?id=<c:out value='${user.id}' />" role="button">
										<i class="fa fa-trash-o"></i>
									</a>
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
        </div><!-- /.row -->
        
        <div class="row">
          <div class="col-lg-6">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-user"></i> Ajouter un utilisateur</h3>
              </div>
              <div class="panel-body">
              
              	<form action="<%= request.getContextPath() %>/auth/admin/userManagement/addUser" method="post">
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
				<label for="prenom">Prénom :</label>
				<input type="text" class="form-control" size="40" name="prenom" id="prenom" />
			</p>
	
			<p>
				<label for="mail">Mail :</label>
				<input type="text" class="form-control" size="40" name="mail" id="mail" />
			</p>
				
			<p>
				<label for="password">Password :</label>
				<input type="password" class="form-control" size="10" name="password" id="password" />
			</p>
				
			<p>
				<label for="pass2">Retapez le password :</label>
				<input type="password" class="form-control" size="10" name="pass2" id="pass2" />
			</p>
	
			<p>
				<input type="submit" class="btn btn-success" name="subscribe" value="Créer l'utilisateur" />
			</p>
		</div>
	</form>
             </div>
          </div>
         </div>
         
        
         
        </div><!-- /.row -->
        
        </div>
        </div>
   		<%@ include file="includes/footer-admin.jsp"%>
         	
</body>
</html>