

 		<form method="POST" action="<%=request.getContextPath()%>/login" class="navbar-form navbar-right">
            <div class="form-group">
              <input type="text" name="pseudo" placeholder="Pseudo" class="form-control">
            </div>
            <div class="form-group">
              <input type="password" name="password" placeholder="Password" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">Se Connecter !</button>
            <a href="<%=request.getContextPath()%>/subscribe"> <button type="button" class="btn btn-default">Pas encore membre ?</button> </a>
            <c:if test="${errorLogin}">
				<p style="color: red">Des erreurs sont présentes sur le formulaire</p>
			</c:if>
          </form>



