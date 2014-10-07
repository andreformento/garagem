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
				<h3>Bem vindo, usu�rio. Voc� ainda n�o possui nenhum ve�culo cadastrado.</h3>
				<h3>Para come�ar cadastre seu ve�culo em "Garagem>Novo"</h3>
			</div>
		</div>
		
		<jsp:include page="_template/rodape.jsp"></jsp:include>
	</html>
</body>