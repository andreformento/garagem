<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>
	<head>
		<jsp:include page="_template/head.jsp"></jsp:include>
	</head>
	<body>
		<jsp:include page="_template/topo.jsp"></jsp:include>
		
		<div class="fundo">
			<div class="bemVindo">
				<h3>Bem vindo, usuário. Você ainda não possui nenhum veículo cadastrado.</h3>
				<h3>Para começar cadastre seu veículo em "Garagem>Novo"</h3>
			</div>
		</div>
		
		<jsp:include page="_template/rodape.jsp"></jsp:include>
	</html>
</body>