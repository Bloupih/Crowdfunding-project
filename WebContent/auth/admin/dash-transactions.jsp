<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>administration des transactions</title>

 <%@ include file="/includes/headers.jsp"%>
</head>
<body>
	<div id="wrapper">
	 <%@ include file="/includes/menu.jsp"%>
	 
	 <div id="page-wrapper">
		<div class="row">
          <div class="col-lg-12">
            <h1>Dashboard <small>&raquo Gestion des transactions</small></h1>
            <ol class="breadcrumb">
              <li class="active"><i class="fa fa-dashboard"></i> Gerer les differentes transactions </li>
            </ol>
            
            <c:if test="${alert == 0}">
				<div class="alert alert-warning alert-dismissable">La transaction n'a pas pu être supprimée correctement.</div>
			</c:if>
			 <c:if test="${alert == 1}">
				<div class="alert alert-success alert-dismissable">La transaction a été supprimée de la base de donnée avec succès !</div>
			</c:if>
           </div>
        </div><!-- /.row -->

        <div class="row">
          <div class="col-lg-16">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <div class="row">
                  <div class="col-xs-6">
                    <i class="fa fa-eur fa-5x"></i>
                  </div>
                  <div class="col-xs-6 text-right">
                    <p class="announcement-heading"><c:out value="${transactions.size()}"/></p>
                    <p class="announcement-text">Contributions</p>
                  </div>
                </div>
              </div>
        </div><!-- /.row -->

        <div class="row">
          <div class="col-lg-12">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa fa-eur"></i> Listes des transactions</h3>
              </div>
              <div class="panel-body">
                <div class="table-responsive">
	              <table class="table table-hover table-striped tablesorter">
	                <thead>
	                  <tr>
	                    <th class="header">Id transaction <i class="fa fa-sort"></i></th>
	                    <th class="header">Contributeur <i class="fa fa-sort"></i></th>
	                    <th class="header">Projet <i class="fa fa-sort"></i></th>
	                    <th class="header">Date Transaction <i class="fa fa-sort"></i></th>
	                    <th class="header">Montant <i class="fa fa-sort"></i></th>
	               		<th class="header">Modifications <i class="fa"></i></th>
	                  </tr>
	                </thead>
	                
	                <tbody>
	                <c:forEach  items="${transactions}" var="transaction" begin="0" end="4" >
	                      <tr>
	                        <td><c:out value="${transaction.getId() }" /></td>
	                        <td><c:out value="${transaction.getNameUser() }" /></td>
	                        <td><c:out value="${transaction.getNameProject() }" /></td>
	                        <td><c:out value="${transaction.getDate() }" /></td>
	                        <td><c:out value="${transaction.getContributedValue() }" /></td>
			                <td>					
								<a class="col-md-1 col-md-offset-1" href="<%=request.getContextPath()%>/auth/admin/removeTransaction?id=<c:out value='${transaction.getId()}' />">
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
        </div>
        </div>
        
         <%@ include file="includes/footer-admin.jsp"%>
</body>
</html>