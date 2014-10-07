<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>
	<head>
		<jsp:include page="_template/head.jsp"></jsp:include>
	</head>
	<body>
		<div class="topoInicio">
			<h1>Portal Restomod</h1>
		</div>
		
		<div class="centralizadoInicio">
			<form action="fazerLogin">
				<div class="fields">
					<label for="user">User</label>
					<input id="user" type="text"  />
					<label for="user">Password</label>
					<input id="password" type="password"  />
					
					<input type="submit" value="Login" />
				</div>
			</form>
		</div>
		
		<div class="rodapePaginaInicio">
			<ul id="portal">
				<li>O portal restore serve como um guia para o acompanhamento da sua restauração ou modificação.</li>
				<li>Cadastre seu veiculo, liste as peças, controle o tempo, o investimento e conte com a nossa ajuda para ver seu projeto pronto.</li>
			</ul>
		</div>
		
		<jsp:include page="_template/rodape.jsp"></jsp:include>
	</html>
</body>