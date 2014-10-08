<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>
<head>
<jsp:include page="../_template/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../_template/topo.jsp"></jsp:include>

	<form id="frmCadastro" action="gravarCarro">
		<div class="formSobreposto">
			<div class="botoes">
				<div>
					<input id="btAtividades" type="button" value="Funilaria" onclick="location.href='registrarAtividades'" />
				</div>
				<div>
					<input id="btAtividades" type="button" value="Tapeçaria" onclick="location.href='registrarAtividades'" />
				</div>
				<div>
					<input id="btAtividades" type="button" value="Elétrica" onclick="location.href='registrarAtividades'" />
				</div>
				<div>
					<input id="btAtividades" type="button" value="Acabamento" onclick="location.href='registrarAtividades'" />
				</div>
				<div>
					<input id="btAtividades" type="button" value="Mecânica" onclick="location.href='registrarAtividades'" />
				</div>
				<div>
					<input id="btAtividades" type="button" value="Outros" onclick="location.href='registrarAtividades'" />
				</div>
			</div>
		</div>
	</form>

	<jsp:include page="../_template/rodape.jsp"></jsp:include>
</html>
</body>