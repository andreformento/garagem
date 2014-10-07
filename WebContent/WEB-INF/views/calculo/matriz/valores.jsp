<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>

<jsp:include page="../../_template/head.jsp"></jsp:include>
<body>
	<jsp:include page="../../_template/topo.jsp"></jsp:include>
	<div>
		<h4>Cáculo de matriz - valores</h4>
	</div>


	<form:form modelAttribute="matriz" action="calcularMatriz"
		method="post">
		<div class="valor" id="frmValores">
			<input type="button" onclick="history.go(-1);" value="Voltar" />
			<div>Identificação da matriz</div>
			<div>
				<form:label path="parametro.quantidadeDeLinhas" for="txtQuantidadeDeLinhas">Quantidade de linhas:</form:label>
				<form:input path="parametro.quantidadeDeLinhas" id="txtQuantidadeDeLinhas" disabled="true" />
			</div>
			<div>
				<form:label path="parametro.quantidadeDeColunas" for="txtQuantidadeDeColunas">Quantidade de colunas:</form:label>
				<form:input path="parametro.quantidadeDeColunas" id="txtQuantidadeDeColunas" disabled="true" />
			</div>
			
			<c:forEach items="${matriz.listMatrizLinha}" var="matrizLinha">
				<div>
					<c:forEach items="#{matrizLinha.valores}" var="valor">
						<input type="text" value="${valor}" />
					</c:forEach>
					
					<output> = </output>
				
					<input type="text" value="${matrizLinha.resultado}" />
				</div>
			</c:forEach>
	
			<div>
				<input type="submit" value="Calcular" />
			</div>
		</div>
	</form:form>

	<jsp:include page="../../_template/rodape.jsp"></jsp:include>
</body>
</head>
</html>