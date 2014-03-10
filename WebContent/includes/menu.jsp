<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- Sidebar -->
      <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="<%=request.getContextPath()%>/Index"><i class="fa fa-money"></i> WaSup'CrowdFunding</a>
        </div>
        
     	<c:if test="${role == '0'}">
	        <!-- Collect the nav links, forms, and other content for toggling -->
	        <div class="collapse navbar-collapse navbar-ex1-collapse">
	          <ul id="adminMenu" class="nav navbar-nav side-nav">
	            <li><a href="<%=request.getContextPath()%>/auth/admin"><i class="fa fa-dashboard"></i> Dashboard</a></li>
	            <li><a href="<%=request.getContextPath()%>/auth/admin/projectsManagement"><i class="fa fa-pencil-square-o"></i> Projets</a></li>
	            <li><a href="<%=request.getContextPath()%>/auth/admin/categoriesManagement"><i class="fa fa-archive"></i> Catégories</a></li>
	            <li><a href="<%=request.getContextPath()%>/auth/admin/usersManagement"><i class="fa fa-users"></i> Utilisateurs</a></li>
	            <li><a href="<%=request.getContextPath()%>/auth/admin/transactionsManagement"><i class="fa fa fa-eur"></i> Transactions</a></li>
	       <i id="button_hover" class="fa fa-arrow-right fa-inverse"></i>
	          </ul>
	          
	          
	     </c:if> 
	          <ul class="nav navbar-nav">
	      			<li> <a class="navbar-left" href="<%=request.getContextPath()%>/listProject">Tous les projets</a></li>
	      			<li> <a class="navbar-left" href="<%=request.getContextPath()%>/listCategory">Catégories</a></li>
	      	  </ul>
	     

		<c:choose>
	       <c:when test="${not empty role }">
	          <ul class="nav navbar-nav navbar-right navbar-user">
	            
	            <li class="dropdown user-dropdown">
	              <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <c:out value="${username}"/>  <b class="caret"></b></a>
	              <ul class="dropdown-menu">
	                <c:if test="${role!=2 }">
	                <li><a href="<%=request.getContextPath()%>/auth/addProject"><i class="fa fa fa-plus"></i> Créer un nouveau projet</a></li>
	                 </c:if>
	                 <c:if test="${role == '0'}">
	                	<li><a href="<%=request.getContextPath()%>/auth/admin/addCategory"><i class="fa fa-tags"></i> Créer une nouvelle catégorie</a></li>
	                	 <li class="divider"></li>
	                	<li><a href="<%=request.getContextPath()%>/auth/admin"><i class="fa fa-gear"></i> Panel admin</a></li>
	                </c:if> 
	                 <li class="divider"></li>
	                <li><a href="<%=request.getContextPath()%>/auth/showProfile"><i class="fa fa-user"></i> Editer mon Profil</a></li>
	                <li class="divider"></li>
	                <li><a href="<%=request.getContextPath()%>/logout"><i class="fa fa-power-off"></i> Déconnexion</a></li>
	              </ul>
	            </li>
	          </ul>
	        </c:when>
			 <c:otherwise> <%@ include file="/includes/login.jsp"%></c:otherwise>
		</c:choose>  
	          
        </div><!-- /.navbar-collapse -->
      </nav>
