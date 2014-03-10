<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show project</title>
<%@ include file="/includes/headers.jsp"%>
</head>
<body>

	<%@ include file="/includes/menu.jsp"%>
	

	
	
	
	<div id="show_project" class="container">
	<div class="row">
		<div class="col-md-8">
			<h1><c:out value="${project.name}" /></h1>
			<h5><c:out value="${project.getPseudoCreator()}" /></h5>
			<h5><span class="glyphicon glyphicon-tag"></span></span> <c:out value="${project.category.name}" /></h5>
			<h5><br />"<c:out value="${project.content}" />"</h5>
		</div>
	
		<div id="infos_state" class="col-md-4">
			<h3> <fmt:formatNumber value="${project.price}" type="currency"/> d'objectif </h3>
			<h3> <fmt:formatNumber value="${project.contributedPrice}" type="currency"/> collecté ! </h3>
			
			<br/>
			<span class="glyphicon glyphicon-calendar"></span>
			<h5>
				
				<c:out value="${project.dateStart}" />
				<span class="glyphicon glyphicon-chevron-right"></span>
				<c:out value="${project.dateEnd}" />
			</h5>
			<%@ include file="/includes/progress-bar.jsp"%>
			
			<c:if test="${not empty role && ( role == 0 || role == 1) }">
								<!-- Button trigger modal -->
				<button id="contribute" class="btn btn-primary btn-block" data-toggle="modal" data-target="#myModal">
				<h4>Contribuer à ce projet</h4>  <span class="glyphicon glyphicon-thumbs-up"></span>
				</button>
			</c:if>
			
			<c:if test="${role == '0'}">
							<br/>
							<a class="col-md-1" href="<%=request.getContextPath()%>/auth/admin/removeProject?id=<c:out value='${project.id}' />">
									<button type="submit" class="btn btn-danger">
										<i class="fa fa-trash-o"> Supprimer ce projet</i>
									</button>
								</a>
			</c:if>
		</div>
	</div> <!-- en row -->
	
				<c:if test="${not empty username}">
								
				
				<!-- Modal -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				  <div class="modal-dialog">
				    <div class="modal-content">
				      <div class="modal-header">
				        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				        <h4 class="modal-title" id="myModalLabel">Contribuer au projet "<c:out value="${project.name}" />"</h4>
				      </div>
				      <div class="modal-body">
				      	<form class="raw" method="POST" action="<%=request.getContextPath()%>/auth/contributeToProject"  class="form-inline" role="form">
						  <input type="hidden" name="id" value="${project.id}" />
						  	<div class="form-group">
							  	<div class="badge objectif_price col-md-4">
									<strong>Objectif du projet <c:out value="${project.price}" /> € </strong> <br/>
									<strong>Déjà <c:out value="${project.getContributedPrice()}" /> € collecté !</strong> 
								</div>
						  		
						  		
						  	<div class="input-group row col-md-6 col-md-offset-2">
								<span class="input-group-addon">Prix</span>
								<input type="text" class="form-control" size="10" name="contributed_price" id="price" placeholder="Ma contribution ..."/>
								<span class="input-group-addon">€</span>
							</div>
						  </div>
						  <br/>
						   
						  <button type="submit" class="btn btn-success bg-lg">Valider ma contribution !</button>
						  <button type="button" class="btn btn-danger col-md-offset-2" data-dismiss="modal">Annuler</button>
						   </div>
						  </div>
						</form>
				      
				      	  
				      
				       
				      </div>
				      
				    </div><!-- /.modal-content -->
				  </div><!-- /.modal-dialog -->
				</div><!-- /.modal -->
				<br/>
				
			</c:if>
		
	</div> <!-- end .container -->
	<%@ include file="/includes/footer.jsp" %>
	
</body>
</html>