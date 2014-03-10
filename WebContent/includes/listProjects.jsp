<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<c:forEach items="${projects}" var="project">
			
				<div id="project" class="col-md-3">
					<div id="infos col-md-3">
						<h5>
							<span class="badge"><span class="glyphicon glyphicon-tag"><a href="showCategory?id=<c:out value="${project.category.id}" />"/><c:out value="${project.category.name}" /></a></span>
						</h5>
						<h4><strong><c:out value="${project.name}" /></strong> </h4> 
						<br/>
						<span class="badge objectif_price">
						<strong><fmt:formatNumber value="${project.price}" type="currency"/> </strong> - objectif <br/>
						<strong><fmt:formatNumber value="${project.getContributedPrice()}" type="currency"/></strong> déjà collecté !</span>
						<p class="description"><c:out value="${project.getMiniDescription()}" /></p>
						
					</div><!-- end #infos -->
					<a class="btn btn-default" href="<%=request.getContextPath()%>/showProject?id=${project.id}" role="button">Voir détails &raquo;</a>
					
					<%@ include file="/includes/progress-bar.jsp"%>
					
					<p><br />
						
						<c:if test="${not empty role && role == 0}">
							<a class="col-md-1 col-md-offset-1" href="<%=request.getContextPath()%>/auth/admin/removeProject?id=<c:out value='${project.id}' />">
									<button type="submit" class="btn btn-danger">
										<i class="fa fa-trash-o"> Supprimer ce projet</i>
									</button>
								</a>
						
						
							<br />
						
						</c:if>
					</p>
				</div>
			</c:forEach>
		</div>