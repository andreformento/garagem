<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>

<html>
<head>
<jsp:include page="_template/head.jsp"></jsp:include>
</head>
<body onload='document.loginForm.username.focus();'>
	<div class="topoInicio">
		<h1><!-- Portal Restomod --></h1>
	</div>

	<div class="centralizadoInicio">
		<form:form name='loginForm' id="loginForm" action="loginExec" method="post" commandName="entidade">
			<div class="fields">
				<div>
					<label for="username">User</label>
					<form:input path="username" />
				</div>
				<div>
					<label for="password">Password</label>
					<form:input path="password" />
				</div>
				<div>
					<label for="efetuaLogin">&nbsp;</label> <input id="efetuaLogin"
						type="submit" value="Login" />
				</div>
			</div>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			
			<c:if test="${not empty param.error}" >
				<div class="mensagemWarning">${param.error}</div>
			</c:if>
		</form:form>
	</div>

	<div class="rodapePaginaInicio">
		<ul id="portal">
			<li>O portal restore serve como um guia para o acompanhamento da
				sua restauração ou modificação.</li>
			<li>Cadastre seu veiculo, liste as peças, controle o tempo, o
				investimento e conte com a nossa ajuda para ver seu projeto pronto.</li>
		</ul>
	</div>

	<jsp:include page="_template/rodape.jsp"></jsp:include>
</body>
</html>