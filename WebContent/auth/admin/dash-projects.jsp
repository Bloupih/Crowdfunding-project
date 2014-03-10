<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>administration des projets</title>

 <%@ include file="/includes/headers.jsp"%>
</head>
<body>
	<div id="wrapper">
	 <%@ include file="/includes/menu.jsp"%>
	 
	 <div id="page-wrapper">

        <div class="row">
          <div class="col-lg-12">
            <h1>Dashboard <small>&raquo administration des projets</small></h1>
            <ol class="breadcrumb">
              <li class="active"><i class="fa fa-dashboard"></i> Ajouter/Editer/Supprimer les differents projets </li>
            </ol>
            
            <c:if test="${alert == 0}">
				<div class="alert alert-warning alert-dismissable">Le projet n'a pas pu être supprimer correctement.</div>
			</c:if>
			 <c:if test="${alert == 1}">
				<div class="alert alert-success alert-dismissable">Le projet a été supprimé de la base de donnée avec succès !</div>
			</c:if>
            
          </div>
        </div><!-- /.row -->

        <div class="row">
          <div class="col-lg-16">
            <div class="panel panel-info">
              <div class="panel-heading">
                <div class="row">
                  <div class="col-xs-6">
                    <i class="fa fa-pencil-square-o fa-5x"></i>
                  </div>
                  <div class="col-xs-6 text-right">
                    <p class="announcement-heading"><c:out value="${totalCountProjects}"/></p>
                    <p class="announcement-text">Projets</p>
                  </div>
                </div>
              </div>
              
          
        </div><!-- /.row -->

        <div class="row">
          <div class="col-lg-12">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-bar-chart-o"></i> Listes des projets</h3>
              </div>
              <div class="panel-body">
                
                	
                	
                	
                	<div class="table-responsive">
              <table class="table table-hover table-striped tablesorter">
                <thead>
                  <tr>
                    <th class="header">Projet <i class="fa fa-sort"></i></th>
                    <th class="header">Prix objectif <i class="fa fa-sort"></i></th>
                    <th class="header">Prix collecté <i class="fa fa-sort"></i></th>
                    <th class="header">Accomplissement <i class="fa fa-sort"></i></th>
                    <th class="header">Deadline <i class="fa fa-sort"></i></th>
                    <th class="header">Nb de contributeurs <i class="fa fa-sort"></i></th>
                    <th class="header headerSortUp">Details <i class="fa"></i></th>
                    <th class="header"> Actions <i class="fa"></i></th>
                  </tr>
                </thead>
                <tbody>
                
                <c:forEach items="${projects}" var="project">
	                <tr>
	                    <td><c:out value="${project.name}" /></td>
	                    <td><fmt:formatNumber value="${project.price}" type="currency"/></td>
	                    <td><fmt:formatNumber value="${project.contributedPrice}" type="currency"/></td>
	                    <td><%@ include file="/includes/progress-bar.jsp"%></td>
	                      <td><c:out value="${project.dateEnd}" /></td>
	                      <td><c:out value="${project.getNumberOfContributors()}" /></td>
	                    <td><a class="btn btn-default" href="<%=request.getContextPath()%>/showProject?id=${project.id}" role="button">Voir détails &raquo;</a>
						</td>
						<td>
	                   
								
								<a class="col-md-1 col-md-offset-1" href="<%=request.getContextPath()%>/auth/admin/editProject?id=<c:out value='${project.id}' />">
									<button type="submit" class="btn btn-warning">
										<i class="fa fa-pencil-square-o"></i>
									</button>
								</a>
								
								
								<a class="col-md-1 col-md-offset-1" href="<%=request.getContextPath()%>/auth/admin/removeProject?id=<c:out value='${project.id}' />">
									<button type="submit" class="btn btn-danger">
										<i class="fa fa-trash-o"></i>
									</button>
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
                <h3 class="panel-title"><i class="fa fa-user"></i> Ajouter un projet</h3>
              </div>
              <div class="panel-body">
	
			<c:if test="${errors}">
				<p style="color: red">Des erreurs sont présentes sur le formulaire</p>
			</c:if>

			<form action="<%= request.getContextPath() %>/auth/addProject" method="post">
				<div class="form-group">
					
					<div class="input-group col-md-8">
						<span class="input-group-addon">Nom</span>
						<input type="text" class="form-control" size="40" name="name" id="name" placeholder="Car un projet mérite un nom !"/>
					</div>
					<div class="input-group col-md-8">
						<span class="input-group-addon">Prix à atteindre</span>
						<input type="text" data-min="1" data-max="100" class="form-control" size="50" name="price" id="price" placeholder="L'objectif à atteindre en € !"/>
						<span class="input-group-addon">€</span>
					</div>
					<br/>
					
					<div class="input-group col-md-16">
						<label for="category">Catégorie</label>
						<select name="category" class="form-control selectpicker">
							<c:forEach items="${categories}" var="c">
								<option value="${c.id}">${c.name}</option>
							</c:forEach>
						</select>
					</div>
					
					
					<div class="input-group">
						<span class="input-group-addon">Description</span>
						<textarea class="form-control" name="content" id="content" cols="40" placeholder="Dites en nous un peu plus à propos de votre projet ..."></textarea>
					</div>
			
					
					
					<div class="row">
						<div class="input-group col-md-2">
							<label for="dateStart">Date début</label>
							<input type="date" class="form-control" name="dateStart" id="date" />
							<span class="add-on"><i class="icon-calendar"></i></span>
						</div>
					
						<div class="input-group col-md-2">
							<label for="dateEnd">Date fin</label>
							<input type="date" class="form-control" name="dateEnd" id="date" />
							<span class="add-on"><i class="icon-calendar"></i></span>
						</div>
					</div>
					
			
					<div class="input-group">
						<input type="submit" class="btn btn-success" value="Créer le nouveau projet" />
					</div>
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