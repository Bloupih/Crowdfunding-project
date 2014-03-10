
<c:set var="contributed" value="${project.getContributedPrice()}" />
<c:set var="percent" value="${(((contributed - project.price) / project.price) * 100) + 100}"/>
<fmt:formatNumber var="percentFormated" type="number" maxFractionDigits="2" value="${percent}" />
		
		
		<h4 id="project_percent">Complété à <c:out value="${percentFormated}" />% !</h4>
		<div class="progress progress-striped">
		  <div class="progress-bar progress-bar-info" role="progressbar" aria-valuemin="0" aria-valuenow="<c:out value="${percentFormated}"/>" style="width: <c:out value="${percent}"/>%;">
		  </div>
		</div>