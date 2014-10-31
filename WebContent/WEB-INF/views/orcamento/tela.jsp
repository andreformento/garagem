<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../_template/head.jsp"></jsp:include>
	<script type="text/javascript" src="resources/js/orcamento.js"></script>
</head>
<body onload="carregarOrcamentos(${param.codCategoriaOrcamento})">
	<jsp:include page="../_template/topo.jsp"></jsp:include>

	<form id="frmCadastro" action="gravarCarro">
		<div class="formSobreposto">
			<div class="guias">
				<div class="guia">
					<div class="botoes">
						<c:forEach items="${categoriaOrcamentoList}" var="categoriaOrcamento" varStatus="uStatus">
							<div>
								<input 
									id="btCategoriaOrcamento_${categoriaOrcamento.codigo}" 
									type="button" 
									value="${categoriaOrcamento.descricao}"
									onclick="carregarOrcamentos(${categoriaOrcamento.codigo})" />
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="guiaCentral">
					<div id="dvlistaInterna">
						<div class="title"><div class="tituloCategoria"><h4>Selecione uma categoria</h4></div></div>
					</div>
				</div>
				<div class="guiaDireita">
					<div class="miniatura">
						<c:if test="${not empty carroFotoEncode}">
							<jsp:include page="../_template/imagemPadrao.jsp"></jsp:include>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</form>

	<jsp:include page="../_template/rodape.jsp"></jsp:include>
</body>

</html>