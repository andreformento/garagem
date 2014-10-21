<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>
<head>
<jsp:include page="../_template/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../_template/topo.jsp"></jsp:include>
	${param.codTipoCategoriaOrcamento}

	<form id="frmCadastro" action="gravarCarro">
		<div class="formSobreposto">
			<div class="guias">
				<div class="guiaEsquerda">
					<div class="botoes">
						<div>
							<input id="btAtividades" type="button" value="Funilaria"
								onclick="location.href='registrarAtividades'" />
						</div>
						<div>
							<input id="btAtividades" type="button" value="Tapeçaria"
								onclick="location.href='registrarAtividades'" />
						</div>
						<div>
							<input id="btAtividades" type="button" value="Elétrica"
								onclick="location.href='registrarAtividades'" />
						</div>
						<div>
							<input id="btAtividades" type="button" value="Acabamento"
								onclick="location.href='registrarAtividades'" />
						</div>
						<div>
							<input id="btAtividades" type="button" value="Mecânica"
								onclick="location.href='registrarAtividades'" />
						</div>
						<div>
							<input id="btAtividades" type="button" value="Outros"
								onclick="location.href='registrarAtividades'" />
						</div>
					</div>
				</div>
				<div class="guiaCentral">
					<div id="dvOrcamentos">
						<div class="formInterno">
							<div id="dvFormulario" class="fields1">
								<div>
									<label for="txtAcao">Ação</label> <input id="txtAcao"
										type="text" value="Pintura das portas" />
								</div>
								<div>
									<label for="txtHistoria">Observação</label>
									<textarea id="txtHistoria" rows="4" cols="35">Cor azul</textarea>
								</div>

							</div>
						</div>
					</div>
				</div>
				<div class="guiaDireita">
					<div class="miniatura">
						<img src="<c:url value='/images/porsche.jpg'/>" />
					</div>
				</div>
			</div>
		</div>
	</form>

	<jsp:include page="../_template/rodape.jsp"></jsp:include>
</body>

</html>