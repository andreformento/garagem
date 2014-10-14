<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>
<head>
<jsp:include page="_template/head.jsp"></jsp:include>
</head>
<body onload='document.loginForm.username.focus();'>
	<div class="topoInicio">
		<h1><!-- Portal Restomod --> - login_page</h1>
	</div>

	<div class="centralizadoInicio">

		<%
			String errorString = (String) request.getAttribute("error");
			if (errorString != null && errorString.trim().compareToIgnoreCase("true") == 0) {
				out.println("Incorrect login name or password. Please retry using correct login name and password.");
			}
		%>

		<form name='loginForm' action="loginPage" method='post'>
			<div class="fields">
				<div>
					<label for="username">User</label> <input name='username'
						id='username' type="text" />
				</div>
				<div>
					<label for="password">Password</label> <input name='password'
						id='password' type="password" />
				</div>
				<div>
					<label for="efetuaLogin">&nbsp;</label> <input id="efetuaLogin"
						type="submit" value="Login" />
				</div>
			</div>
			<!-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> -->
		</form>
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