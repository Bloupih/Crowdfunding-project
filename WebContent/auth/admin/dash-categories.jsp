<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ page import="com.supinfo.supcrowdfunding.entity.CategoryDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>administration des categories</title>

 <%@ include file="/includes/headers.jsp"%>
</head>
<body>
	<div id="wrapper">
	 <%@ include file="/includes/menu.jsp"%>
	 
	 <div id="page-wrapper">
		<div class="row">
          <div class="col-lg-12">
            <h1>Dashboard <small>&raquo administration des catégories</small></h1>
            <ol class="breadcrumb">
              <li class="active"><i class="fa fa-dashboard"></i> Ajouter/Editer/Supprimer les differentes catégories </li>
            </ol>
            
            <c:if test="${alert == 0}">
				<div class="alert alert-warning alert-dismissable">La catégorie n'a pas pu être supprimée correctement.</div>
			</c:if>
			 <c:if test="${alert == 1}">
				<div class="alert alert-success alert-dismissable">La catégorie a été supprimée de la base de donnée avec succès !</div>
			</c:if>
          </div>
        </div><!-- /.row -->

        <div class="row">
          <div class="col-lg-16">
            <div class="panel panel-danger">
              <div class="panel-heading">
                <div class="row">
                  <div class="col-xs-6">
                    <i class="fa fa-archive fa-5x"></i>
                  </div>
                  <div class="col-xs-6 text-right">
                    <p class="announcement-heading"><c:out value="${totalCountCategories}"/></p>
                    <p class="announcement-text">Catégories</p>
                  </div>
                </div>
              </div>
        </div><!-- /.row -->

        <div class="row">
          <div class="col-lg-12">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-archive"></i> Liste des catégories</h3>
              </div>
              <div class="panel-body">
                <div class="table-responsive">
		              <table class="table table-hover table-striped tablesorter">
		                <thead>
		                  <tr>
		                    <th class="header">Catégorie <i class="fa fa-sort"></i></th>
		                    <th class="header headerSortUp">Details <i class="fa"></i></th>
		                    <th class="header">Nombre de projets <i class="fa fa-sort"></i></th>
		                    <th class="header">Modification <i class="fa"></i></th>
		                  </tr>
		                </thead>
		                <tbody>
		                
		                <c:forEach items="${categories}" var="category">
			                <tr>
			                    <td><c:out value="${category.name}" /></td>
			                    <td><a class="btn btn-default" href="<%=request.getContextPath()%>/showCategory?id=${category.id}" role="button">Voir détails &raquo;</a>
								</td>
								<td><c:out value= "${category.getCountProject()}"/></td>
								<td>
									<a class="col-md-1 col-md-offset-1" href="<%=request.getContextPath()%>/auth/admin/categoriesManagement/editCategory?id=<c:out value='${category.id}' />">
										<button type="submit" class="btn btn-warning">
											<i class="fa fa-pencil-square-o"></i>
										</button>
									</a>
									
									<div class="col-md-1 col-md-offset-1">
										<button type="submit" class="btn btn-danger" data-toggle="modal" data-target="#deleteModal">
											<i class="fa fa-trash-o"></i>
										</button>
									</div>
									<!--  Modal -->
									<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
										  <div class="modal-dialog">
										    <div class="modal-content">
										      <div class="modal-header">
										        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										        <h4 class="modal-title" id="myModalLabel">Confirmer la suppression de la catégorie <c:out value='${category.name}' /> </h4>
										      </div>
										      <div class="modal-body">
										      	<c:choose>
													<c:when test="${category.getCountProject() > 0}">
														 <p>
												      		Attention, il semblerait que la catégorie que vous désirez supprimer contient des projets.
												      	</p>
													</c:when>
													<c:when test="${category.getCountProject() == 0}"> 
														<p>
												      	La catégorie que vous désirez supprimer est vide, vous pouvez la supprimer sans risques :)
												      </p>
													</c:when>
												</c:choose>
										      
								                <div class="raw">
								                  <div class="col-xs-6">
								                    <i class="fa fa-pencil-square-o fa-5x"></i>
								                  </div>
								                  <div class="col-xs-6 text-right">
								                    <p class="announcement-heading"><c:out value='${category.getCountProject()}' /></p>
								                    <p class="announcement-text">Projets</p>
								                  </div>
								                </div>
				                
										      <div class="modal-footer">
										        <button type="button" class="btn btn-default" data-dismiss="modal">Annuler la suppression</button>
										        <a href="<%=request.getContextPath()%>/auth/admin/removeCategory?id=<c:out value='${category.id}' />">
										        	<button type="button" class="btn btn btn-danger"><i class="fa fa-trash-o"></i> Je suis sûr, supprimer la catégorie</button>
										      	</a>
										      </div>
										    </div><!-- /.modal-content -->
										  </div><!-- /.modal-dialog -->
										</div><!-- /.modal -->
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
                <h3 class="panel-title"><i class="fa fa-user"></i> Ajouter une catégorie</h3>
              </div>
              <div class="panel-body">
              
              	<form action="<%= request.getContextPath() %>/auth/admin/categoriesManagement/addCategory" method="post">
					<div class="form-group">
						<p>
							<label for="nom">Nom :</label>
							<input type="text" class="form-control" size="40" name="name" id="name" />
						</p>
				
						<p>
							<label for="content">Description :</label>
							<input type="text" class="form-control" size="40" name="content" id="content" />
						</p>
				
						<p><input type="submit" class="btn btn-success" name="addCategory" value="Créer la catégorie" /></p>
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