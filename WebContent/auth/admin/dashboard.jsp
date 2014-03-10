<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

    <!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Dashboard - SupCrowdFunding</title>

  <%@ include file="/includes/headers.jsp"%>
  </head>

  <body>

    <div id="wrapper">

      <%@ include file="/includes/menu.jsp"%>
      
      <div id="page-wrapper">

        <div class="row">
          <div class="col-lg-12">
            <h1>Dashboard <small>Général</small></h1>
            <ol class="breadcrumb">
              <li class="active"><i class="fa fa-dashboard"></i> Dashboard</li>
            </ol>
            <div class="alert alert-success alert-dismissable">
              <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
              Bienvenue sur le panel admin de SupCrowdFunding ! 

            </div>
          </div>
        </div><!-- /.row -->

        <div class="row">
          <div class="col-lg-3">
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
              <a href="<%=request.getContextPath()%>/auth/admin/projectsManagement">
                <div class="panel-footer announcement-bottom">
                  <div class="row">
                    <div class="col-xs-6">
                      Voir les projets
                    </div>
                    <div class="col-xs-6 text-right">
                      <i class="fa fa-arrow-circle-right"></i>
                    </div>
                  </div>
                </div>
              </a>
            </div>
          </div>
          <div class="col-lg-3">
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
              <a href="<%=request.getContextPath()%>/auth/admin/usersManagement">
                <div class="panel-footer announcement-bottom">
                  <div class="row">
                    <div class="col-xs-6">
                      Voir les utilisateurs
                    </div>
                    <div class="col-xs-6 text-right">
                      <i class="fa fa-arrow-circle-right"></i>
                    </div>
                  </div>
                </div>
              </a>
            </div>
          </div>
          <div class="col-lg-3">
            <div class="panel panel-danger">
              <div class="panel-heading">
                <div class="row">
                  <div class="col-xs-6">
                    <i class="fa fa-archive fa-5x"></i>
                  </div>
                  <div class="col-xs-6 text-right">
                    <p class="announcement-heading"><c:out value="${totalCountCategories}"/></p>
                    <p class="announcement-text">Categories</p>
                  </div>
                </div>
              </div>
              <a href="<%=request.getContextPath()%>/auth/admin/categoriesManagement">
                <div class="panel-footer announcement-bottom">
                  <div class="row">
                    <div class="col-xs-6">
                      Voir les categories
                    </div>
                    <div class="col-xs-6 text-right">
                      <i class="fa fa-arrow-circle-right"></i>
                    </div>
                  </div>
                </div>
              </a>
            </div>
          </div>
          
          <div class="col-lg-3">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <div class="row">
                  <div class="col-xs-6">
                    <i class="fa fa-eur fa-5x"></i>
                  </div>
                  <div class="col-xs-6 text-right">
                    <p class="announcement-heading"><c:out value="${transactions.size()}"/></p>
                    <p class="announcement-text">Transactions</p>
                  </div>
                </div>
              </div>
              <a href="<%=request.getContextPath()%>/auth/admin/transactionsManagement">
                <div class="panel-footer announcement-bottom">
                  <div class="row">
                    <div class="col-xs-6">
                      Voir les transactions
                    </div>
                    <div class="col-xs-6 text-right">
                      <i class="fa fa-arrow-circle-right"></i>
                    </div>
                  </div>
                </div>
              </a>
            </div>
          </div>
          
        </div><!-- /.row -->

        <div class="row">
         
         	<div id="morris-chart-bar"></div>

        </div><!-- /.row -->

        <div class="row">
          <div class="col-lg-4">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa-long-arrow-right"></i> Nombre de projets par catégorie</h3>
              </div>
              <div class="panel-body">
                <div id="morris-chart-donut"></div>
                <div class="text-right">
                  <a href="<%=request.getContextPath()%>/auth/admin/categoriesManagement">Voir en détails <i class="fa fa-arrow-circle-right"></i></a>
                </div>
              </div>
            </div>
          </div>
          
          <div class="col-lg-8">
            <div class="panel panel-primary">
              <div class="panel-heading">
                <h3 class="panel-title"><i class="fa fa fa-eur"></i> Dernières transactions</h3>
              </div>
              <div class="panel-body">
                <div class="table-responsive">
                  <table class="table table-bordered table-hover table-striped tablesorter">
                    <thead>
                      <tr>
                        <th>Contributeur <i class="fa fa-sort"></i></th>
                        <th>Nom du projet  <i class="fa fa-sort"></i></th>
                        <th>Transaction <i class="fa fa-sort"></i></th>
                        <th>Montant (<i class="fa fa-eur"></i>) <i class="fa fa-sort"></i></th>
                      </tr>
                    </thead>
                    <tbody>
                    <c:forEach  items="${transactions}" var="transaction" begin="0" end="4" >
                      <tr>
                        <td><c:out value="${transaction.getNameUser() }" /></td>
                        <td><c:out value="${transaction.getNameProject() }" /></td>
                        <td><c:out value="${transaction.getDate() }" /></td>
                        <td><c:out value="${transaction.getContributedValue() }" /></td>
                      </tr>
                    </c:forEach>
                    </tbody>
                  </table>
                </div>
                <div class="text-right">
                  <a href="<%=request.getContextPath()%>/auth/admin/transactionsManagement">Voir toutes les transactions <i class="fa fa-arrow-circle-right"></i></a>
                </div>
              </div>
            </div>
          </div>
        </div><!-- /.row -->

      </div><!-- /#page-wrapper -->

    </div><!-- /#wrapper -->

	<%@ include file="includes/footer-admin.jsp"%>	
		
	<script type="text/javascript">
	
	Morris.Donut({
		  element: 'morris-chart-donut',
		  data: [
				<c:forEach items="${categories}" var="category">
			    	{label: "<c:out value="${category.name}" />", value: "<c:out value="${category.getCountProject()}" />"},
			   </c:forEach>
		   
		  ],
		  formatter: function (y) { return y;}
		});
	
	Morris.Bar ({
		  element: 'morris-chart-bar',
		  data: [
			<c:forEach items="${projects}" var="project">
			{device: '<c:out value="${project.name}" />', geekbench: <c:out value="${project.getContributedPrice()}"/>},
			
			</c:forEach>
			
		  ],
		  xkey: 'device',
		  ykeys: ['geekbench'],
		  labels: ['€ cumulés'],
		  barRatio: 0.4,
		  xLabelAngle: 35,
		  hideHover: 'auto'
		});

	</script>
  </body>
</html>