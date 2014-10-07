<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>

<jsp:include page="../../_template/head.jsp"></jsp:include>
<body>
	<jsp:include page="../../_template/topo.jsp"></jsp:include>
	<div>
		<h4>Cáculo de matriz</h4>
	</div>

	<form:form modelAttribute="matrizParametro" action="valoresMatriz"
		method="post">
		<div class="valor" id="frmValores">
			<div>Identificação da matriz</div>
			<div>
				<form:label path="quantidadeDeLinhas" for="txtQuantidadeDeLinhas">Quantidade de linhas:</form:label>
				<form:input path="quantidadeDeLinhas" id="txtQuantidadeDeLinhas" />
				<form:errors path="quantidadeDeLinhas" cssClass="error" />
			</div>
			<div>
				<form:label path="quantidadeDeColunas" for="txtQuantidadeDeColunas">Quantidade de colunas:</form:label>
				<form:input path="quantidadeDeColunas" id="txtQuantidadeDeColunas" />
				<form:errors path="quantidadeDeColunas" cssClass="error" />
			</div>

			<div>
				<input type="submit" value="Configurar valores" />
			</div>
		</div>
	</form:form>

	<jsp:include page="../../_template/rodape.jsp"></jsp:include>
</body>
</head>
</html>